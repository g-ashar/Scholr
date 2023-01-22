/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author gasha
 */
public class CourseController extends SwitchFXML implements Initializable {

    public static String[] answersForFields;
    public static char[] answersForRadioButtons;
//    public static ArrayList<String> choiceBoxOptions;

    @FXML
    private Button backButton;
    @FXML
    private Button finishButton;

    @FXML
    private TextField answerField0;
    @FXML
    private TextField answerField1;
    @FXML
    private TextField answerField2;
    @FXML
    private TextField answerField3;
    @FXML
    private TextField answerField4;

    @FXML
    private RadioButton radioButton0;
    @FXML
    private RadioButton radioButton1;
    @FXML
    private RadioButton radioButton2;
    @FXML
    private RadioButton radioButton3;
    @FXML
    private RadioButton radioButton4;
    @FXML
    private RadioButton radioButton5;
    @FXML
    private RadioButton radioButton6;
    @FXML
    private RadioButton radioButton7;
    @FXML
    private RadioButton radioButton8;
    @FXML
    private RadioButton radioButton9;
    
    private String correctAnswer = "";

//    @FXML
//    private ComboBox comboBox0;
//    @FXML
//    private ComboBox comboBox1;
//    @FXML
//    private ComboBox comboBox2;
//    @FXML
//    private ComboBox comboBox3;
//    @FXML
//    private ComboBox comboBox4;
    private String[] oneLineAnswers = new String[5];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(backButton);
        switchToNormalStyle(finishButton);
        if (radioButton0 != null) {
            ToggleGroup buttonGroup0 = new ToggleGroup();
            radioButton0.setToggleGroup(buttonGroup0);
            radioButton1.setToggleGroup(buttonGroup0);
        }
        if (radioButton2 != null) {
            ToggleGroup buttonGroup1 = new ToggleGroup();
            radioButton2.setToggleGroup(buttonGroup1);
            radioButton3.setToggleGroup(buttonGroup1);
        }
        if (radioButton4 != null) {
            ToggleGroup buttonGroup2 = new ToggleGroup();
            radioButton4.setToggleGroup(buttonGroup2);
            radioButton5.setToggleGroup(buttonGroup2);
        }
        if (radioButton6 != null) {
            ToggleGroup buttonGroup3 = new ToggleGroup();
            radioButton6.setToggleGroup(buttonGroup3);
            radioButton7.setToggleGroup(buttonGroup3);
        }
        if (radioButton8 != null) {
            ToggleGroup buttonGroup4 = new ToggleGroup();
            radioButton8.setToggleGroup(buttonGroup4);
            radioButton9.setToggleGroup(buttonGroup4);
        }
    }

    public void backAction() {
        switchScreen("LocationHomepage");
    }

    public void finishAction() {
        // check answers
        //comp 1
        if (radioButton0 != null) {
            if(answersForRadioButtons[0] == 'A') {
                if(radioButton0.isSelected()) {
                    correctAnswer += "Question 1: Correct. ";
                } else {
                    correctAnswer += "Question 1: Incorrect. Correct answer: " + radioButton0.getText() + ". ";
                }
            } else {
                if(radioButton1.isSelected()) {
                    correctAnswer += "Question 1: Correct. ";
                } else {
                    correctAnswer += "Question 1: Incorrect. Correct answer: " + radioButton1.getText() + ". ";
                }
            }
        } else if (answerField0 != null) {
            if(answerField0.getText().toLowerCase().equals(answersForFields[0])) {
                correctAnswer += "Question 1: Correct. ";
            } else {
                correctAnswer += "Question 1: Incorrect. Correct answer: " + answersForFields[0] + ". ";
            }
        }
        
        //comp 2
        if (radioButton2 != null) {
            if(answersForRadioButtons[1] == 'A') {
                if(radioButton2.isSelected()) {
                    correctAnswer += "Question 2: Correct. ";
                } else {
                    correctAnswer += "Question 2: Incorrect. Correct answer: " + radioButton2.getText() + ". ";
                }
            } else {
                if(radioButton3.isSelected()) {
                    correctAnswer += "Question 2: Correct. ";
                } else {
                    correctAnswer += "Question 2: Incorrect. Correct answer: " + radioButton3.getText() + ". ";
                }
            }
        } else if (answerField1 != null) {
            if(answerField1.getText().toLowerCase().equals(answersForFields[1])) {
                correctAnswer += "Question 2: Correct. ";
            } else {
                correctAnswer += "Question 2: Incorrect. Correct answer: " + answersForFields[1] + ". ";
            }
        }
        
        // comp 3
        if (radioButton4 != null) {
            if(answersForRadioButtons[2] == 'A') {
                if(radioButton4.isSelected()) {
                    correctAnswer += "Question 3: Correct. ";
                } else {
                    correctAnswer += "Question 3: Incorrect. Correct answer: " + radioButton4.getText() + ". ";
                }
            } else {
                if(radioButton5.isSelected()) {
                    correctAnswer += "Question 3: Correct. ";
                } else {
                    correctAnswer += "Question 3: Incorrect. Correct answer: " + radioButton5.getText() + ". ";
                }
            }
        } else if (answerField2 != null) {
            if(answerField2.getText().toLowerCase().equals(answersForFields[2])) {
                correctAnswer += "Question 3: Correct. ";
            } else {
                correctAnswer += "Question 3: Incorrect. Correct answer: " + answersForFields[2] + ". ";
            }
        }
        
        // comp 4
        if (radioButton6 != null) {
            if(answersForRadioButtons[3] == 'A') {
                if(radioButton6.isSelected()) {
                    correctAnswer += "Question 4: Correct. ";
                } else {
                    correctAnswer += "Question 4: Incorrect. Correct answer: " + radioButton6.getText() + ". ";
                }
            } else {
                if(radioButton7.isSelected()) {
                    correctAnswer += "Question 4: Correct. ";
                } else {
                    correctAnswer += "Question 4: Incorrect. Correct answer: " + radioButton7.getText() + ". ";
                }
            }
        } else if (answerField3 != null) {
            if(answerField3.getText().toLowerCase().equals(answersForFields[3])) {
                correctAnswer += "Question 4: Correct. ";
            } else {
                correctAnswer += "Question 4: Incorrect. Correct answer: " + answersForFields[3] + ". ";
            }
        }
        
        //comp 5
        if (radioButton8 != null) {
            if(answersForRadioButtons[4] == 'A') {
                if(radioButton8.isSelected()) {
                    correctAnswer += "Question 5: Correct. ";
                } else {
                    correctAnswer += "Question 5: Incorrect. Correct answer: " + radioButton8.getText() + ". ";
                }
            } else {
                if(radioButton9.isSelected()) {
                    correctAnswer += "Question 5: Correct. ";
                } else {
                    correctAnswer += "Question 5: Incorrect. Correct answer: " + radioButton9.getText() + ". ";
                }
            }
        } else if (answerField4 != null) {
            if(answerField4.getText().toLowerCase().equals(answersForFields[4])) {
                correctAnswer += "Question 5: Correct. ";
            } else {
                correctAnswer += "Question 5: Incorrect. Correct answer: " + answersForFields[4] + ". ";
            }
        }
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("Course complete.");
        error.setContentText(correctAnswer);
        error.setHeaderText(null);
        error.showAndWait();
        
        switchScreen("LocationHomepage");
    }

}
