/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.fxml;

import com.gashar.json.Course;
import com.gashar.json.ParseJSON;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author 1003334001
 */
public class LocationController extends SwitchFXML implements Initializable {

    @FXML
    private Button backButton;
    @FXML
    private Button startCourseButton;
    @FXML
    private TextField courseSearchField;
    @FXML
    private ComboBox categoryBox;
    @FXML
    private TableView<Course> courses;
    @FXML
    private TableColumn<Course, String> nameCol;
    @FXML
    private TableColumn<Course, Long> numberCol;
    @FXML
    private TableColumn<Course, String> authorCol;
    @FXML
    private Button searchButton;

    public void backAction() {
        switchScreen("Mainpage");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(categoryBox);
        switchToNormalStyle(backButton);
        switchToNormalStyle(searchButton);
        switchToNormalStyle(startCourseButton);
        ObservableList<String> ol = FXCollections.observableArrayList("By name", "By course number");
        categoryBox.setItems(ol);
        nameCol.setCellValueFactory(new PropertyValueFactory("courseName"));
        authorCol.setCellValueFactory(new PropertyValueFactory("creatorUsername"));
        numberCol.setCellValueFactory(new PropertyValueFactory("courseNumber"));
        categoryBox.setValue("By name");
    }

    public void searchCoursesAction() {
        courses.getItems().clear();
        ArrayList<String> courseNames = ParseJSON.getCourseNames();
        ArrayList<String> creatorNames = ParseJSON.getCreatorNames();
        ArrayList<Long> courseNumbers = ParseJSON.getCourseNumbers();
        if (courseSearchField.getText() == null || courseSearchField.getText().equals("")) {
            for (int i = 0; i < courseNames.size(); i++) {
                courses.getItems().add(new Course(courseNames.get(i), courseNumbers.get(i), creatorNames.get(i)));
            }
        } else {
            String pref = courseSearchField.getText().toLowerCase();
            boolean content = false;
            if (categoryBox.getValue().equals("By name") || categoryBox.getValue() == null) {
                content = true;
            }
            ArrayList<String> prefCourseNames = new ArrayList<String>();
            ArrayList<String> prefCreatorNames = new ArrayList<String>();
            ArrayList<Long> prefCourseNumbers = new ArrayList<Long>();
            if (content) {
                for (int i = 0; i < courseNames.size(); i++) {
                    if (courseNames.get(i).toLowerCase().contains(pref)) {
                        prefCourseNames.add(courseNames.get(i));
                        prefCreatorNames.add(creatorNames.get(i));
                        prefCourseNumbers.add(courseNumbers.get(i));
                    }
                }
            } else {
                for (int i = 0; i < courseNames.size(); i++) {
                    if (courseNumbers.get(i).equals(Long.parseLong(pref))) {
                        prefCourseNames.add(courseNames.get(i));
                        prefCreatorNames.add(creatorNames.get(i));
                        prefCourseNumbers.add(courseNumbers.get(i));
                    }
                }
            }
            for (int i = 0; i < prefCourseNames.size(); i++) {
                courses.getItems().add(new Course(prefCourseNames.get(i), prefCourseNumbers.get(i), prefCreatorNames.get(i)));
            }

        }

    }

    public void viewCourseAction() {
        if (courses.getSelectionModel().getSelectedItem() == null) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setTitle("Please select a course");
            error.setContentText("No course has been selected to open.");
            error.setHeaderText(null);
            error.showAndWait();
        } else {
            switchScreen(courses.getSelectionModel().getSelectedItem().getCourseName());
        }

    }

}
