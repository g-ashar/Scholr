/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 *
 * @author 1003334001
 */
public class LearnCourseController extends SwitchFXML implements Initializable {
    
    @FXML
    private Button backButton;
    @FXML
    private Button printRunButton;
    @FXML
    private TextField printField;
    @FXML
    private TextField printOutputField;
    @FXML
    private Button doneCourseButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(backButton);
        switchToNormalStyle(printRunButton);
        switchToNormalStyle(doneCourseButton);
    }
    
    public void backAction() {
        switchScreen("BenchHomepage");
    }
    
    public void doneCourseAction() {
        switchScreen("BenchHomepage");
    }
    
    public void runPrintStatementAction() {
        String runCode = printField.getText();
        if(runCode.contains("System.out.println(\"") && runCode.contains("\");")) {
            printOutputField.setText(runCode.substring(20, runCode.lastIndexOf("\"")));
        } else {
            printOutputField.setText("Error");
        }
    }
    
}
