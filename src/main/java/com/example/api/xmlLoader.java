/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.api;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author kamh1
 */
public class xmlLoader {

    String ruta;

    public xmlLoader(String ruta) {
        this.ruta = ruta;
    }

    public Boolean Validador() {
        boolean validador = false;
        
        try {
            File fxmlFile = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(fxmlFile);

            doc.getDocumentElement().normalize();
            //CAMPOS REQUIRDO NOMBRE, FECHA INICIO FIN, DIRECCION
            try {
                System.out.println("Fecha Inicio: " + doc.getDocumentElement().getAttribute("FechaInicio"));
                System.out.println("Fecha Final: " + doc.getDocumentElement().getAttribute("FechaFinal"));
                System.out.println("---------------------------");

                NodeList nList = doc.getElementsByTagName("Persona");

                for (int i = 0; i < nList.getLength(); i++) {
                    Node nNode = nList.item(i);

                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;

                        System.out.println(eElement.getElementsByTagName("Nombres").item(0).getTextContent());
                        System.out.println(eElement.getElementsByTagName("ApellidoPaterno").item(0).getTextContent());
                    }
                    System.out.println("----------------------------");
                }
                
                validador = true;
            } catch (Exception e) {
                System.out.println("Verifique que todos los campos requeridos se encuentren");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return validador;
    }

}
