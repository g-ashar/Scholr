/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import static com.gashar.fxml.LoginController.sw;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

/**
 *
 * @author gasha
 */
public class HomepageController extends SwitchFXML implements Initializable{

    @FXML
    private Label topLabel;
    @FXML
    private Button logoutButton;

    @FXML
    private Label introLabel;
    @FXML
    private TextArea area;

    @FXML
    private MenuButton chooseButton;
    @FXML
    private MenuItem learnChoice;
    @FXML
    private MenuItem createChoice;
    @FXML
    private MenuItem socialChoice;
    @FXML
    private MenuItem beginChoice;
    @FXML
    private Button completeButton;

    public void learnChosen() {
        chooseButton.setText(learnChoice.getText());
        introLabel.setText(learnChoice.getText());
        area.setText("This will be where users can search for courses that are made by other users. The FXMLs will be loaded in from the cloud using AmazonS3. There will be a basic search engine as well as "
                + "some reccomendations based on user preferences. This will be implmented in Prototype 2.");
    }

    public void createChosen() {
        chooseButton.setText(createChoice.getText());
        introLabel.setText(createChoice.getText());
        area.setText("This will be where users can create there own courses, save, and publish them. They will be saved on the cloud using AmazonS3. The main component of this implementation "
                + "will be the GUI features for accessibility. A basic implementation will be present in Prototype 2.");
    }

    public void socialChosen() {
        chooseButton.setText(socialChoice.getText());
        introLabel.setText(socialChoice.getText());
        area.setText("This will be where users can interact with one another, giving feedback on courses and sending/receiving messages. To be implemented in the near future.");
    }

    public void beginChosen() {
        chooseButton.setText(beginChoice.getText());
        introLabel.setText(beginChoice.getText());
        area.setText("This will be where users can begin to experience the main building blocks for creating and accessing courses. There will be tutorials as well as some developer made courses. "
                + "This will be implmented in Prototype 2.");
    }

    public void logoutAction() {
        showLogoutConfirmation();
        switchScreen("LoginRegistration");
    }
    
    
    
    public void goToMainPageAction() {
        switchScreen("Mainpage");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(logoutButton);
        switchToNormalStyle(completeButton);
        switchToNormalStyle(chooseButton);
    }

}
