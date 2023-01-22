/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import com.gashar.authorize.AuthDatabase;
import com.gashar.db.FirebaseService;
import com.gashar.db.Person;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author gasha
 */
public class LoginController extends SwitchFXML implements Initializable {

    protected static SwitchFXML sw;
    protected static HomepageController hc = new HomepageController();
    private static boolean init = false;

    @FXML
    private Button login;
    @FXML
    private Button sign;
    @FXML
    private TextField field;
    @FXML
    private PasswordField passField;
    @FXML
    private Label lbl;

    @FXML
    public void signUpAction() {
        switchScreen("AccountCreation");
    }

    @FXML
    public void loginAction() throws IOException, ExecutionException, InterruptedException {
        FirebaseService s = sw.getS();
        boolean usernameCheck = s.checkUsername(field.getText());
        if (!usernameCheck) {
            showUsernameError();
        } else {
            boolean passCheck = s.checkPassword(field.getText(), passField.getText());
            if (passCheck) {
                sw.setUsername(field.getText());
                sw.setPassword(passField.getText());
                Person p = s.getUserDetails(field.getText());
                sw.setName(p.getFirstname() + " " + p.getLastname());
                showConfirmation();
                switchScreen("Mainpage");
            } else {
                showLoginError();
            }
        }

    }

    public static void showLoginError() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Login");
        error.setContentText("Username and password does not match. Please try again.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showUsernameError() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Login");
        error.setContentText("Username does not exist. Please create an account.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showConfirmation() {
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("Successful login");
        error.setContentText("Logged in successfully. Welcome back, " + sw.getName() + ".");
        error.setHeaderText(null);
        error.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (!init) {
            sw = new SwitchFXML();
            FirebaseService s = null;
            try {
                s = AuthDatabase.authorizeFirebase();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sw.setS(s);
            init = true;
        }
        switchToNormalStyle(login);
        switchToNormalStyle(sign);
        String folderPath = System.getProperty("user.dir");
        String fileName = folderPath + "/temp/json/user_courses.json";
        try {
            amazonObj.downloadObject("user_courses.json", "user_courses.json");
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
