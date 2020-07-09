package com.example.viikko9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    EditText date;
    EditText timeStart;
    EditText timeEnd;

    ArrayList<String> movies = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        date = (EditText)findViewById(R.id.editText);
        timeStart = (EditText)findViewById(R.id.editText2);
        timeEnd = (EditText)findViewById(R.id.editText3);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        //https://stackoverflow.com/questions/22395417/error-strictmodeandroidblockguardpolicy-onnetwork

        Areas.readAreas();
        //laitetaan kaikki teatterit arraylistiin ja käydään ne läpi spinnerilla.
        //alustus
        ArrayList<String> spinnerFile = Areas.getTname();
        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerFile);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //
        spinner.setAdapter(adapter);




    }
}