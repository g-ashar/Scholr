/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import static com.gashar.fxml.LoginController.sw;
import static com.gashar.fxml.SwitchFXML.switchScreen;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author 1003334001
 */
public class MainpageController extends SwitchFXML implements Initializable {

    @FXML
    private Button logoutButton;
    @FXML
    private Button benchButton;
    @FXML
    private ListView<String> benchList;
    @FXML
    private Button createButton;
    @FXML
    private ListView<String> createList;
    @FXML
    private Button learnButton;
    @FXML
    private ListView<String> learnList;
    @FXML
    private Button socialButton;
    @FXML
    private ListView<String> socialList;

    @FXML
    public void gotoBenchAction() {
        String chosenShortcut = benchList.getSelectionModel().getSelectedItem();
        if (chosenShortcut.equals("Home")) {
            switchScreen("BenchHomepage");
        }
    }

    @FXML
    public void gotoCreateAction() {
        String chosenShortcut = createList.getSelectionModel().getSelectedItem();
        if (chosenShortcut.equals("Home")) {
            switchScreen("CornerHomepage");
        }
    }

    @FXML
    public void gotoLearnAction() {
        String chosenShortcut = learnList.getSelectionModel().getSelectedItem();
        if (chosenShortcut.equals("Home")) {
            switchScreen("LocationHomepage");
        }
    }

    @FXML
    public void gotoSpotAction() {
        String chosenShortcut = socialList.getSelectionModel().getSelectedItem();
        if (chosenShortcut.equals("Home")) {
            switchScreen("SpotHomepage");
        }
    }

    public void logoutAction() {
        showLogoutConfirmation();
        switchScreen("LoginRegistration");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(benchButton);
        switchToNormalStyle(createButton);
        switchToNormalStyle(learnButton);
        switchToNormalStyle(socialButton);
        switchToNormalStyle(logoutButton);

        ObservableList<String> items = FXCollections.observableArrayList("Home");
        benchList.setItems(items);
        createList.setItems(items);
        learnList.setItems(items);
        socialList.setItems(items);

    }

}
