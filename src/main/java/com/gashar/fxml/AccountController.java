/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import com.gashar.authorize.AuthEmail;
import com.gashar.db.AccessDatabase;
import com.gashar.db.FirebaseService;
import com.gashar.db.Person;
import com.gashar.db.UploadDatabase;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

/**
 *
 * @author gasha
 */
public class AccountController extends SwitchFXML implements Initializable {

    @FXML
    private Button continueButton;

    @FXML
    private Label mainLabel;

    @FXML
    private Button backButton;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    public void backAction() {
        switchScreen("LoginRegistration");
    }

    @FXML
    public void registerAction() throws ExecutionException, InterruptedException {

        if (!anyEmpty()) {
            if (AuthEmail.validateEmail(emailField.getText())) {
                if (AuthEmail.authEmail(firstNameField.getText(), lastNameField.getText())) {
                    String code = showEmailValidationBox(emailField.getText());
                    if (AuthEmail.verifyCode(code)) {
                        // database access
                        boolean exists = LoginController.sw.getS().checkUsername(userField.getText());
                        if (exists) {
                            showUsernameErrorBox();
                        } else {
                            Person p = new Person(firstNameField.getText(), lastNameField.getText(), userField.getText(), passField.getText(), emailField.getText());
                            LoginController.sw.getS().saveUserDetails(p);
                            showCreationBox();
                        }
                        switchScreen("LoginRegistration");
                    } else {
                        showCodeVerifyError();
                    }
                } else {
                    showEmailIncorrectBox();
                }

            } else {
                showEmailIncorrectBox();
            }
        } else {
            showEmptyFieldBox();
        }

//        boolean exists = AccessDatabase.checkUsername(userField.getText());
//        if (exists) {
//            showUsernameErrorBox();
//        } else {
//            UploadDatabase.addUser(lastNameField.getText(), firstNameField.getText(), userField.getText(), passField.getText());
//            switchScreen("LoginRegistration");
//        }
    }

    private boolean anyEmpty() {
    return (userField.getText() == null || userField.getText().isBlank()) || (passField.getText() == null ||
            passField.getText().isBlank()) || (firstNameField.getText() == null || firstNameField.getText().isBlank()) ||
            (lastNameField.getText() == null || lastNameField.getText().isBlank()) ||
            (emailField.getText() == null || emailField.getText().isBlank());
    }

    public static void showUsernameErrorBox() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Registration");
        error.setContentText("This username has already been taken. Choose another one or login with that username.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showEmptyFieldBox() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Fields");
        error.setContentText("Some field is empty above! Please fill all fields above so we can " +
                "fill your account with the relevant information");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static String showEmailValidationBox(String email) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Email validation");
        dialog.setHeaderText(null);
        dialog.setContentText("Please check your email (" + email + ") for a validation code and input it here.");
        dialog.showAndWait();
        return dialog.getEditor().getText();
    }

    public static void showEmailIncorrectBox() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Email");
        error.setContentText("The email provided is not of a valid format. Please check it!");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showCreationBox() {
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("Account created successfully");
        error.setContentText("Account created, redirecting you to login screen.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showCreationErrorBox() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Account could not be created");
        error.setContentText("Please try again in a moment");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showCodeVerifyError() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Account could not be created");
        error.setContentText("Code is incorrect! Please retry and enter the correct code!");
        error.setHeaderText(null);
        error.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(continueButton);
        switchToNormalStyle(backButton);
    }

}
