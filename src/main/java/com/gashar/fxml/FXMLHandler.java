/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author gasha
 */
public class FXMLHandler extends Application {

//    private String currentFXMLPath;
//
//    public FXMLHandler(String path) {
//        currentFXMLPath = path;
//    }
//
//    public void loadFXML(String path) {
//
//    }
    private static Stage stage;

    public static void main(String[] args) {
//        FXMLHandler fxml = new FXMLHandler("/LoginRegistration.fxml");
//        fxml.start();
        launch(args);
    }

    @Override
    public void start(Stage stg) throws Exception {
        stage = stg;
        Scene scene = loadFXML("LoginRegistration");
        stage.setMaxHeight(400);
        stage.setMaxWidth(600);
        stage.setResizable(false);
        stg.setTitle("Scholr");
        stg.setScene(scene);
        stg.show();
    }

    public static void setRoot(String fxml) throws IOException {
        FXMLHandler handler = new FXMLHandler();
        stage.setScene(handler.loadFXML(fxml));
    }

    public Scene loadFXML(String fxml) throws IOException {
        String filePath = "/" + fxml + ".fxml";
        URL url = getClass().getResource(filePath);
        Parent root = null;
        try {
            root = FXMLLoader.load(url);
        } catch (NullPointerException ex) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Error in switching screens");
            error.setContentText("FXMLLoader is not functional at this time. Please build and clean project to eliminate errors and try again later.");
            error.setHeaderText(null);
            error.showAndWait();
        }
        Scene scn = new Scene(root);
        return scn;
    }

    public static String openImportDialog() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Import FXML File");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("FXML Files", "*.fxml"));
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile == null) {
            return "none";
        }
        return selectedFile.getPath();
    }

}
