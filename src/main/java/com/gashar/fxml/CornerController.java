/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import static com.gashar.fxml.LoginController.sw;
import com.gashar.json.AddJSON;
import com.gashar.json.ParseJSON;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author 1003334001
 */
public class CornerController extends SwitchFXML implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button createButton;
    @FXML
    private RadioButton simpleButton;
    @FXML
    private RadioButton importButton;
    @FXML
    private TextField courseNameField;
    @FXML
    private Button selectButton;
    @FXML
    private Button openButton;
    @FXML
    private ListView continueCoursesPane;
    @FXML
    private Button publishButton1;
    @FXML
    private ListView publishedCoursesPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup createGroup = new ToggleGroup();
        simpleButton.setToggleGroup(createGroup);
        importButton.setToggleGroup(createGroup);
        switchToNormalStyle(publishButton1);
        switchToNormalStyle(openButton);
        switchToNormalStyle(backButton);
        switchToNormalStyle(createButton);
        switchToNormalStyle(simpleButton);
        switchToNormalStyle(importButton);
        switchToNormalStyle(selectButton);
        selectButton.setDisable(true);
        //setCoursesPane(ParseJSON.getCourseNames(sw.getUsername()));
        //if(sw.getCourseName() != null) {
        //    continueCoursesPane.getItems().add(sw.getCourseName());
        //}

    }

    public void setCoursesPane(ArrayList<String> courseName) {
        ObservableList ol = FXCollections.observableArrayList(courseName);
        continueCoursesPane.setItems(ol);
    }

    public void publishAction() {
        publishedCoursesPane.setItems(continueCoursesPane.getSelectionModel().getSelectedItems());
        AddJSON.addToJSON(sw.getUsername(), sw.getCourseName());
        showPublishConfirmation();
    }
    
    public static void showPublishConfirmation() {
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("Course Published");
        error.setContentText("See \"Published courses\" to see your course.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showFilenameError() {
        Alert error = new Alert(Alert.AlertType.ERROR);
        error.setTitle("Error in Filename");
        error.setContentText("Please do not leave filename blank.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public static void showFileOpenBox() {
        Alert error = new Alert(Alert.AlertType.CONFIRMATION);
        error.setTitle("File copied to project folder");
        error.setContentText("Opening project now.");
        error.setHeaderText(null);
        error.showAndWait();
    }

    public void backAction() {
        switchScreen("Mainpage");
    }

    public void createCourseAction() {
        String courseName = courseNameField.getText();
        sw.setCourseName(courseName);
        System.out.println(courseName);
        if (importButton.isSelected()) {
            if (!courseNameField.getText().equals("")) {
                String path = FXMLHandler.openImportDialog();
                if (!path.equals("none")) {
                    File toCopy = new File(path);
                    String dir = System.getProperty("user.dir");
                    File copied = new File(dir + "/src/main/resources/" + courseName + ".fxml");
                    try {
                        FileUtils.copyFile(toCopy, copied);
                    } catch (IOException ex) {
                        System.out.println("File could not be copied");
                    }
                    showFileOpenBox();
                    switchScreen(courseName);
                }

            } else {
                showFilenameError();
            }

        } else if (simpleButton.isSelected()) {
            if (!courseNameField.getText().equals("")) {
                switchScreen("SimpleCreateTemplate");
            } else {
                showFilenameError();
            }
        }
    }
    
    public void openLocationAction() {
        switchScreen("LocationHomepage");
    }

}
