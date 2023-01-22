/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import static com.gashar.fxml.LoginController.sw;
import com.gashar.json.AddJSON;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

/**
 *
 * @author gasha
 */
public class SimpleCreateController extends SwitchFXML implements Initializable {

    @FXML
    private TextField courseNameField;
    @FXML
    private ComboBox comp1Box;
    @FXML
    private ComboBox comp2Box;
    @FXML
    private ComboBox comp3Box;
    @FXML
    private ComboBox comp4Box;
    @FXML
    private ComboBox comp5Box;
    @FXML
    private Button nextPageButton;
    @FXML
    private Button backButton;
    @FXML
    private Button finishButton;
    @FXML
    private AnchorPane contentPane;
    private ArrayList<TextField> headers = new ArrayList<TextField>();
    private ArrayList<TextField> oneLine = new ArrayList<TextField>();
    private ArrayList<TextArea> bigInfo = new ArrayList<TextArea>();
    private ArrayList<TextField> answer = new ArrayList<TextField>();
    private ArrayList<TextField> question = new ArrayList<TextField>();
    private ArrayList<TextField> choiceA = new ArrayList<TextField>();
    private ArrayList<TextField> choiceB = new ArrayList<TextField>();
    private ArrayList<TextField> choiceAnswer = new ArrayList<TextField>();
    private ArrayList<TextField> answersForChoice = new ArrayList<TextField>();
    private ArrayList<TextField> realAnswerChoice = new ArrayList<TextField>();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        courseNameField.setText(sw.getCourseName());
        switchToNormalStyle(comp1Box);
        switchToNormalStyle(finishButton);
        switchToNormalStyle(comp2Box);
        switchToNormalStyle(comp3Box);
        switchToNormalStyle(comp4Box);
        switchToNormalStyle(comp5Box);
        switchToNormalStyle(nextPageButton);
        nextPageButton.setDisable(true);
        switchToNormalStyle(backButton);
        ObservableList<String> ol = FXCollections.observableArrayList("Section header", "One line info", "Big info", "One line answer", "2 choice button");
        comp1Box.setItems(ol);
        comp2Box.setItems(ol);
        comp3Box.setItems(ol);
        comp4Box.setItems(ol);
        comp5Box.setItems(ol);
        for (int i = 0; i < 5; i++) {
            headers.add(i, new TextField());
            oneLine.add(i, new TextField());
            bigInfo.add(i, new TextArea());
            answer.add(i, new TextField());
            question.add(i, new TextField());
            choiceA.add(i, new TextField());
            choiceB.add(i, new TextField());
            choiceAnswer.add(i, new TextField());
            answersForChoice.add(i, new TextField());
            realAnswerChoice.add(i, new TextField());

        }
    }

    public void backAction() {
        boolean change = showBackWarning();
        if (change == true) {
            switchScreen("CornerHomepage");
        }
    }

    public static boolean showBackWarning() {
        Alert error = new Alert(Alert.AlertType.WARNING, "Go Back?", new ButtonType("Cancel"), new ButtonType("OK"));
        error.setTitle("Go back to Creatr's Corner");
        error.setContentText("Are you sure you want to go back? Your work will not be saved.");
        error.setHeaderText(null);
        error.showAndWait();
        String result = error.getResult().getText();
        return !result.equals("Cancel");
    }

    public void removeAll(int index) {
        contentPane.getChildren().remove(oneLine.get(index));
        contentPane.getChildren().remove(bigInfo.get(index));
        contentPane.getChildren().remove(answer.get(index));
        contentPane.getChildren().remove(question.get(index));
        contentPane.getChildren().remove(choiceA.get(index));
        contentPane.getChildren().remove(choiceB.get(index));
        contentPane.getChildren().remove(choiceAnswer.get(index));
        contentPane.getChildren().remove(answersForChoice.get(index));
        contentPane.getChildren().remove(realAnswerChoice.get(index));
        contentPane.getChildren().remove(headers.get(index));
    }

    // unfortunate wall of code, will optimize for next update
    public void addComp(double y, String type, int index) {
        removeAll(index);
        if (type.equals("Section header")) {
            if (headers.get(index) == null) {
                headers.set(index, new TextField());
            }
            headers.get(index).setFont(Font.font("Tahoma", 15));
            headers.get(index).setMinWidth(300);
            headers.get(index).setLayoutX(15.0);
            headers.get(index).setLayoutY(y);
            headers.get(index).setPromptText("Type header here.");
            contentPane.getChildren().add(headers.get(index));
        } else if (type.equals("One line info")) {
            if (oneLine.get(index) == null) {
                oneLine.set(index, new TextField());
            }
            oneLine.get(index).setFont(Font.font("Tahoma", 12));
            oneLine.get(index).setMinWidth(300);
            oneLine.get(index).setLayoutX(15.0);
            oneLine.get(index).setLayoutY(y);
            oneLine.get(index).setPromptText("Type short info here.");
            contentPane.getChildren().add(oneLine.get(index));
        } else if (type.equals("Big info")) {
            if (bigInfo.get(index) == null) {
                bigInfo.set(index, new TextArea());
            }
            bigInfo.get(index).setFont(Font.font("Tahoma", 12));
            bigInfo.get(index).setMinWidth(400);
            bigInfo.get(index).setMaxWidth(400);
            bigInfo.get(index).setMinHeight(70);
            bigInfo.get(index).setMaxHeight(70);
            bigInfo.get(index).setLayoutX(15.0);
            bigInfo.get(index).setLayoutY(y);
            bigInfo.get(index).setWrapText(true);
            bigInfo.get(index).setPromptText("Type info here.");
            contentPane.getChildren().add(bigInfo.get(index));
        } else if (type.equals("One line answer")) {
            if (question.get(index) == null) {
                question.set(index, new TextField());
            }
            if (answer.get(index) == null) {
                answer.set(index, new TextField());
            }
            question.get(index).setFont(Font.font("Tahoma", 12));
            question.get(index).setMinWidth(300);
            question.get(index).setLayoutX(15.0);
            question.get(index).setLayoutY(y);
            question.get(index).setPromptText("Type question here.");
            answer.get(index).setFont(Font.font("Tahoma", 12));
            answer.get(index).setMinWidth(300);
            answer.get(index).setLayoutX(15.0);
            answer.get(index).setLayoutY(y + 30);
            answer.get(index).setPromptText("Type answer here.");
            contentPane.getChildren().add(question.get(index));
            contentPane.getChildren().add(answer.get(index));
        } else if (type.equals("2 choice button")) {
            if (choiceA.get(index) == null) {
                choiceA.set(index, new TextField());
            }
            if (choiceB.get(index) == null) {
                choiceB.set(index, new TextField());
            }
            if (choiceAnswer.get(index) == null) {
                choiceAnswer.set(index, new TextField());
            }
            choiceA.get(index).setFont(Font.font("Tahoma", 12));
            choiceA.get(index).setMinWidth(125);
            choiceA.get(index).setLayoutX(15.0);
            choiceA.get(index).setLayoutY(y);
            choiceA.get(index).setPromptText("Type choice A here.");
            choiceB.get(index).setFont(Font.font("Tahoma", 12));
            choiceB.get(index).setMinWidth(125);
            choiceB.get(index).setLayoutX(15.0 + 145);
            choiceB.get(index).setLayoutY(y);
            choiceB.get(index).setPromptText("Type choice B here.");
            choiceAnswer.get(index).setFont(Font.font("Tahoma", 12));
            choiceAnswer.get(index).setMinWidth(200);
            choiceAnswer.get(index).setLayoutX(15.0);
            choiceAnswer.get(index).setLayoutY(y + 30);
            choiceAnswer.get(index).setPromptText("Type answer here. (A or B)");
            contentPane.getChildren().add(choiceA.get(index));
            contentPane.getChildren().add(choiceB.get(index));
            contentPane.getChildren().add(choiceAnswer.get(index));
        } //else if (type.equals("Choice box")) {
//            if (answersForChoice.get(index) == null) {
//                answersForChoice.set(index, new TextField());
//            }
//            if (realAnswerChoice.get(index) == null) {
//                realAnswerChoice.set(index, new TextField());
//            }
//            answersForChoice.get(index).setFont(Font.font("Tahoma", 12));
//            answersForChoice.get(index).setMinWidth(350);
//            answersForChoice.get(index).setLayoutX(15.0);
//            answersForChoice.get(index).setLayoutY(y);
//            answersForChoice.get(index).setPromptText("Type all available choices here, separated by ',' (commas).");
//            realAnswerChoice.get(index).setFont(Font.font("Tahoma", 12));
//            realAnswerChoice.get(index).setMinWidth(200);
//            realAnswerChoice.get(index).setLayoutX(15.0);
//            realAnswerChoice.get(index).setLayoutY(y + 30);
//            realAnswerChoice.get(index).setPromptText("Type the right answer here.");
//            contentPane.getChildren().add(answersForChoice.get(index));
//            contentPane.getChildren().add(realAnswerChoice.get(index));
//        }
    }

    public void comp1Change() {
        String selection = (String) comp1Box.getValue();
        addComp(25.0, selection, 0);
    }

    public void comp2Change() {
        String selection = (String) comp2Box.getValue();
        addComp(100, selection, 1);
    }

    public void comp3Change() {
        String selection = (String) comp3Box.getValue();
        addComp(175, selection, 2);
    }

    public void comp4Change() {
        String selection = (String) comp4Box.getValue();
        addComp(250, selection, 3);
    }

    public void comp5Change() {
        String selection = (String) comp5Box.getValue();
        addComp(325, selection, 4);
    }

    public void finishAction() throws IOException {
        sw.setCourseName(courseNameField.getText());
        String[] compNames = {(String) comp1Box.getValue(), (String) comp2Box.getValue(), (String) comp3Box.getValue(), (String) comp4Box.getValue(), (String) comp5Box.getValue()};
        String[] compValues = new String[5];
        boolean createFile = true;
        // "Section header", "One line info", "Big info", "One line answer", "2 choice button", "Choice box"
        CourseController.answersForFields = new String[5];
        CourseController.answersForRadioButtons = new char[5];
//        CourseController.choiceBoxOptions = new ArrayList<String>();
        for (int i = 0; i < compNames.length; i++) {
            switch (compNames[i]) {
                case "Section header":
                    if (headers.get(i).getText() != null) {
                        compValues[i] = headers.get(i).getText();
                    } else {
                        compValues[i] = "";
                    }
                    break;
                case "One line info":
                    compValues[i] = oneLine.get(i).getText();
                    break;
                case "Big info":
                    compValues[i] = bigInfo.get(i).getText();
                    break;
                case "One line answer":
                    compValues[i] = question.get(i).getText();
                    CourseController.answersForFields[i] = answer.get(i).getText();
                    break;
                case "2 choice button":
                    compValues[i] = choiceA.get(i).getText() + "/***/" + choiceB.get(i).getText();
//                    if (!choiceAnswer.get(i).getText().toUpperCase().contains("A") || !choiceAnswer.get(i).getText().toUpperCase().contains("B")) {
//                        createFile = false;
//                    }
                    CourseController.answersForRadioButtons[i] = choiceAnswer.get(i).getText().toUpperCase().charAt(0);
                    break;
//                case "Choice box":
//                    String newDelim = ",";
//                    Scanner sc = new Scanner(answersForChoice.get(i).getText());
//                    while(sc.hasNext()) {
//                        sc.useDelimiter(newDelim);
//                    }
//                    compValues[i] = answersForChoice.get(i).getText() + "/***/" + realAnswerChoice.get(i).getText();
//                    break;
                default:
                    compValues[i] = "";
                    break;
            }
        }
        if (createFile) {
            CreateFXML.createFXMLFile(sw.getCourseName(), compNames, compValues);
            showConfirmation();
            switchScreen("CornerHomepage");
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error in parsing information");
            error.setContentText("Please make sure the choice answer box stores \"a\" or \"b\".");
            error.setHeaderText(null);
            error.showAndWait();
        }

    }

    public static void showConfirmation() {
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("Creating course file now");
        error.setContentText("File has been created and stored in the cloud for usage in the cloud. Please publish this course in the Creatr's Corner Homepage. Redirecting now.");
        error.setHeaderText(null);
        error.showAndWait();
    }

}
