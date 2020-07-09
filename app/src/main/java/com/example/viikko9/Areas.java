package com.example.viikko9;


import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
//pitää kirjaa kaikista elokuvateattereista tietorakenteen arraylistin avulla
public class Areas {

    public static ArrayList<AAreas> area = new ArrayList<AAreas>();


    public static void readAreas (){

        try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            String urlString = "https://www.finnkino.fi/xml/TheatreAreas/";
            Document doc = builder.parse(urlString);
            doc.getDocumentElement().normalize();
            //https://www.youtube.com/watch?v=WE3-Dqaar3I&feature=youtu.be

            NodeList nList = doc.getDocumentElement().getElementsByTagName("TheatreArea");

            for (int i = 0; i<nList.getLength(); i++) {
                Node node = nList.item(i);


                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String ID = element.getElementsByTagName("ID").item(0).getTextContent();
                    String name = element.getElementsByTagName("Name").item(0).getTextContent();
                    AAreas info = new AAreas(ID, name);
                    area.add(info);


                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            System.out.println("########## DONE ##########");
        }
    }

    public static ArrayList<String> getTname() {
        ArrayList<String> names = new ArrayList<String>();
        for(int i = 0; i<area.size();i++) {
            names.add(area.get(i).name);
        }
        return names;
    }




}
