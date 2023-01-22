/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 *
 * @author gasha
 */
public class CreateCourseController extends SwitchFXML implements Initializable {
    
    @FXML
    private ComboBox pageComboBox;
    @FXML
    private Button goButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(goButton);
        switchToNormalStyle(pageComboBox);
        ObservableList<String> ol = FXCollections.observableArrayList("Mainpage", "Beginnr's Bench", "Login screen (logout)");
        pageComboBox.setItems(ol);
    }
    
    public void goAction() {
        String selection = (String) pageComboBox.getValue();
        if(selection == null) {
            showGoError();
        } else if(selection.contains("Begin")) {
            switchScreen("BenchHomepage");
        } else if(selection.contains("Login")) {
            showLogoutConfirmation();
            switchScreen("LoginRegistration");
        } else {
            switchScreen("Mainpage");
        }
    }
    
    public static void showGoError() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error");
        error.setContentText("Please select a page to go to.");
        error.setHeaderText(null);
        error.showAndWait();
    }
    
}
