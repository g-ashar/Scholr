/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import static com.gashar.fxml.LoginController.sw;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ProcessingInstruction;

/**
 *
 * @author gasha
 */
public class CreateFXML extends SwitchFXML {

    public static void createFXMLFile(String fileName, String[] compNames, String[] compValues) {

        String dir = System.getProperty("user.dir");
        String filePath = dir + "/src/main/resources/" + fileName + ".fxml";

        try {

            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

            Document document = documentBuilder.newDocument();

            //imports
            ProcessingInstruction imp1 = document.createProcessingInstruction("import", "javafx.scene.layout.AnchorPane");
            ProcessingInstruction imp2 = document.createProcessingInstruction("import", "javafx.scene.control.Button");
            ProcessingInstruction imp3 = document.createProcessingInstruction("import", "javafx.scene.control.TextField");
            ProcessingInstruction imp4 = document.createProcessingInstruction("import", "javafx.scene.control.Label");
            ProcessingInstruction imp5 = document.createProcessingInstruction("import", "javafx.scene.control.TextArea");
            ProcessingInstruction imp6 = document.createProcessingInstruction("import", "javafx.scene.control.RadioButton");
            ProcessingInstruction imp7 = document.createProcessingInstruction("import", "javafx.scene.control.ToggleGroup");
            ProcessingInstruction imp8 = document.createProcessingInstruction("import", "javafx.scene.control.ComboBox");
            ProcessingInstruction imp9 = document.createProcessingInstruction("import", "javafx.scene.text.Font");

            // anchorpane element
            Element root = document.createElement("AnchorPane");
            root.setAttribute("maxHeight", "-Infinity");
            root.setAttribute("maxWidth", "-Infinity");
            root.setAttribute("minHeight", "-Infinity");
            root.setAttribute("minWidth", "-Infinity");
            root.setAttribute("prefHeight", "400.0");
            root.setAttribute("prefWidth", "600.0");                    // sets attributes of AnchorPane to normal
            root.setAttribute("stylesheets", "@GeneralSheet.css");
            root.setAttribute("fx:controller", "com.gashar.fxml.CourseController");
            root.setAttribute("xmlns", "http://javafx.com/javafx/8.0.171");
            root.setAttribute("xmlns:fx", "http://javafx.com/fxml/1");
            document.appendChild(root);
            root.getParentNode().insertBefore(imp1, root);
            root.getParentNode().insertBefore(imp2, root);
            root.getParentNode().insertBefore(imp3, root);
            root.getParentNode().insertBefore(imp4, root); // add imports
            root.getParentNode().insertBefore(imp5, root);
            root.getParentNode().insertBefore(imp6, root);
            root.getParentNode().insertBefore(imp7, root);
            root.getParentNode().insertBefore(imp8, root);
            root.getParentNode().insertBefore(imp9, root);

            // children element
            Element children = document.createElement("children");
            root.appendChild(children);
            Element backButton = document.createElement("Button");
            backButton.setAttribute("fx:id", "backButton");
            backButton.setAttribute("layoutX", "500");
            backButton.setAttribute("layoutY", "15");
            backButton.setAttribute("mnemonicParsing", "false");
            backButton.setAttribute("onAction", "#backAction");
            backButton.setAttribute("styleClass", "generalButton");
            backButton.setAttribute("text", "Back");
            Element finishButton = document.createElement("Button");
            finishButton.setAttribute("fx:id", "finishButton");
            finishButton.setAttribute("layoutX", "550");
            finishButton.setAttribute("layoutY", "15");
            finishButton.setAttribute("mnemonicParsing", "false");
            finishButton.setAttribute("onAction", "#finishAction");
            finishButton.setAttribute("styleClass", "generalButton");
            finishButton.setAttribute("text", "Finish");
            children.appendChild(backButton);
            children.appendChild(finishButton);

            Element mainLabel = document.createElement("Label");
            mainLabel.setAttribute("layoutX", "15");
            mainLabel.setAttribute("layoutY", "15");
            mainLabel.setAttribute("text", sw.getCourseName() + " by " + sw.getUsername());
            Element font = document.createElement("font");
            Element font2 = document.createElement("Font");
            font2.setAttribute("name", "Tahoma");
            font2.setAttribute("size", "20.0");
            font.appendChild(font2);
            mainLabel.appendChild(font);
            children.appendChild(mainLabel);

            Element[] elems = new Element[5];
            Element[] answers = new Element[5];
            Element[] radioButtons = new Element[10];
            Element[] comboBoxes = new Element[5];
            String delimeter = "/***/";

            for (int i = 0; i < compNames.length; i++) {
                switch (compNames[i]) {
                    case "Section header":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", compValues[i]);
                        Element font3 = document.createElement("font");
                        Element font4 = document.createElement("Font");
                        font4.setAttribute("name", "Tahoma");
                        font4.setAttribute("size", "15.0");
                        font3.appendChild(font4);
                        elems[i].appendChild(font3);
                        break;
                    case "One line info":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", compValues[i]);
                        break;
                    case "Big info":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", compValues[i]);
                        elems[i].setAttribute("wrapText", "true");
                        break;
                    case "One line answer":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", compValues[i]);
                        answers[i] = document.createElement("TextField");
                        answers[i].setAttribute("promptText", "Type answer here.");
                        answers[i].setAttribute("fx:id", "answerField" + i);
                        break;
                    case "2 choice button":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", "Choose the correct answer to the above question.");
                        radioButtons[i * 2] = document.createElement("RadioButton");
                        radioButtons[i * 2].setAttribute("text", compValues[i].substring(0, compValues[i].indexOf(delimeter)));
                        radioButtons[i*2].setAttribute("fx:id", "radioButton" + (i*2));
                        radioButtons[(i * 2) + 1] = document.createElement("RadioButton");
                        radioButtons[(i * 2) + 1].setAttribute("text", compValues[i].substring(compValues[i].indexOf(delimeter) + 5));
                        radioButtons[(i*2) + 1].setAttribute("fx:id", "radioButton" + ((i*2) + 1));
                        break;
                    case "Choice box":
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", "Choose the correct answer to the above question.");
                        comboBoxes[i] = document.createElement("ComboBox");
                        comboBoxes[i].setAttribute("promptText", "Choose the correct answer.");
                        comboBoxes[i].setAttribute("fx:id", "comboBox" + i);
                        break;
                    default:
                        elems[i] = document.createElement("Label");
                        elems[i].setAttribute("text", "Empty Information");
                        break;
                }
            }
            elems[0].setAttribute("layoutX", "15");
            elems[0].setAttribute("layoutY", "66.6666666");

            elems[1].setAttribute("layoutX", "15");
            elems[1].setAttribute("layoutY", "133.333333");

            elems[2].setAttribute("layoutX", "15");
            elems[2].setAttribute("layoutY", "200");

            elems[3].setAttribute("layoutX", "15");
            elems[3].setAttribute("layoutY", "266.666666");

            elems[4].setAttribute("layoutX", "15");
            elems[4].setAttribute("layoutY", "333.333333");

            for (int i = 0; i < 5; i++) {
                double yPos = 0;
                switch (i) {
                    case 0:
                        yPos = 100;
                        break;
                    case 1:
                        yPos = 170;
                        break;
                    case 2:
                        yPos = 230;
                        break;
                    case 3:
                        yPos = 300;
                        break;
                    case 4:
                        yPos = 370;
                        break;
                }
                if (answers[i] != null) {
                    answers[i].setAttribute("layoutX", "15");
                    answers[i].setAttribute("layoutY", "" + yPos);
                    children.appendChild(answers[i]);
                }
                if (radioButtons[i * 2] != null) {
                    radioButtons[i * 2].setAttribute("layoutX", "15");
                    radioButtons[(i * 2) + 1].setAttribute("layoutX", "200");
                    radioButtons[i * 2].setAttribute("layoutY", "" + yPos);
                    radioButtons[(i * 2)+1].setAttribute("layoutY", "" + yPos);
                    children.appendChild(radioButtons[i*2]);
                    children.appendChild(radioButtons[(i*2)+1]);
                }
                if(comboBoxes[i] != null) {
                    comboBoxes[i].setAttribute("layoutX", "15");
                    comboBoxes[i].setAttribute("layoutY", "" + yPos);
                    children.appendChild(comboBoxes[i]);
                }
            }
            children.appendChild(elems[0]);
            children.appendChild(elems[1]);
            children.appendChild(elems[2]);
            children.appendChild(elems[3]);
            children.appendChild(elems[4]);

            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(filePath));

            transformer.transform(domSource, streamResult);

            System.out.println("Done creating XML File");

        } catch (ParserConfigurationException | TransformerException pce) {
            System.out.println(pce);
        } //catch (IOException ex) {
//            Logger.getLogger(CreateFXML.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

}
