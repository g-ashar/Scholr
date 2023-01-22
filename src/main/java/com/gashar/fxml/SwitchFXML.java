/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import com.gashar.cloud.AccessCloud;
import com.gashar.cloud.UploadCloud;
import static com.gashar.fxml.LoginController.sw;
import java.io.IOException;

import com.gashar.db.FirebaseService;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuButton;
import javafx.scene.control.RadioButton;

/**
 *
 * @author gasha
 */
public class SwitchFXML {
    AccessCloud amazonObj = new UploadCloud("mycoursesbucketscholrapplication");
    
    private String name, username, password, createCourseName;
    private final String buttonHoverStyle = "-fx-font-family: Tahoma; -fx-background-color: gray; -fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black; "
            + "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
    private String buttonStyle = "-fx-font-family: Tahoma; -fx-background-color: linear-gradient(#f2f2f2, #d6d6d6), linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%), linear-gradient(#dddddd 0%, #f6f6f6 50%); "
            + "-fx-background-radius: 8,7,6; -fx-background-insets: 0,1,2; -fx-text-fill: black; -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );";
    private FirebaseService s;

    public FirebaseService getS() {
        return s;
    }

    public void setS(FirebaseService s) {
        this.s = s;
    }

    public static void switchScreen(String fxml) {
        try {
            FXMLHandler.setRoot(fxml);
        } catch (IOException ex) {
            System.out.println("Switch did not work.");
            System.out.println(ex);
        }
    }
    
    public static void showLogoutConfirmation() {
        Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Successful logout");
        confirm.setContentText("Logged out successfully. See you next time, " + sw.getName() + ".");
        confirm.setHeaderText(null);
        confirm.showAndWait();
        sw.setName(null);
        sw.setUsername(null);
        sw.setPassword(null);
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getCourseName() {
        return this.createCourseName;
    }
    
    public void setCourseName(String s) {
        this.createCourseName = s;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public void setName(String n) {
        this.name = n;
    }
    
    public void setUsername(String u) {
        this.username = u;
    }
    
    public void setPassword(String p) {
        this.password = p;
    }
    
    public void switchToNormalStyle(Button b) {
        b.setStyle(buttonStyle);
        b.setOnMouseEntered(e -> b.setStyle(buttonHoverStyle));
        b.setOnMouseExited(e -> b.setStyle(buttonStyle));
    }
    
    public void switchToNormalStyle(MenuButton b) {
        b.setOnMouseEntered(e -> b.setStyle(buttonHoverStyle));
        b.setOnMouseExited(e -> b.setStyle(buttonStyle));
    }
    
    public void switchToNormalStyle(ComboBox b) {
        b.setOnMouseEntered(e -> b.setStyle(buttonHoverStyle));
        b.setOnMouseExited(e -> b.setStyle(buttonStyle));
    }
    
    public void switchToNormalStyle(RadioButton b) {
        b.setOnMouseEntered(e -> b.setStyle(buttonHoverStyle));
        b.setOnMouseExited(e -> b.setStyle(buttonStyle));
    }
    
    public void switchToHoverStyle(Button b) {
        b.setOnMouseEntered(e -> b.setStyle(buttonHoverStyle));
        b.setOnMouseExited(e -> b.setStyle(buttonHoverStyle));
    }
    
}
