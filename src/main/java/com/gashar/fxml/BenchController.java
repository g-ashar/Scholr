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
import javafx.scene.control.TextArea;

/**
 *
 * @author 1003334001
 */
public class BenchController extends SwitchFXML implements Initializable {

    @FXML
    private Button cTutButton;
    @FXML
    private Button lTutButton;
    @FXML
    private Button gLearnButton;
    @FXML
    private Button cLearnButton;
    @FXML
    private Button lLearnButton;
    @FXML
    private Button sLearnButton;
    @FXML
    private Button backButton;
    @FXML
    private TextArea learnArea;

    public void chooseGAction() {
        switchToNormalStyle(cLearnButton);
        switchToNormalStyle(lLearnButton);
        switchToNormalStyle(sLearnButton);
        switchToHoverStyle(gLearnButton);
        learnArea.setText("- Scholr is an application designed to aid individuals in their pursuit of education, from learning to teaching.\n\n"
                + "- There are four main features of the application, outlined in the tutorial you may have seen upon registration. There's Beginnr's Bench (Where you are now), Creatr's Corner, "
                + "Learnr's Location, and Social Spot.\n\n"
                + "- Click the buttons below to learn more about each feature.");
    }

    public void chooseCAction() {
        switchToNormalStyle(gLearnButton);
        switchToNormalStyle(lLearnButton);
        switchToNormalStyle(sLearnButton);
        switchToHoverStyle(cLearnButton);
        learnArea.setText("- Creatr's Corner is a place where you can unlock your inner creativity and create courses to aid others learn more about their world. \n\n"
                + "- You can create and publish courses for the world to see, using basic controls to make it more interactive then a piece of paper.");
    }

    public void chooseLAction() {
        switchToNormalStyle(cLearnButton);
        switchToNormalStyle(gLearnButton);
        switchToNormalStyle(sLearnButton);
        switchToHoverStyle(lLearnButton);
        learnArea.setText("- Learnr's Location is your one-stop shop for viewing usermade courses.\n\n"
                + "- You can search for courses by keyword, creator's name, and course code.\n\n"
                + "- There will also be a recommended section in case you're having a hard time deciding which course to do.");
    }

    public void chooseSAction() {
        switchToNormalStyle(cLearnButton);
        switchToNormalStyle(lLearnButton);
        switchToNormalStyle(gLearnButton);
        switchToHoverStyle(sLearnButton);
        learnArea.setText("- Social Spot allows users to interact with one another, utilizing a message and friend system.\n\n"
                + "- Search for other users and see their courses and friends.");
    }

    public void gotoLTutAction() {
        switchScreen("LearnCourse");
    }
    
    public void backAction() {
        switchScreen("Mainpage");
    }
    
    public void gotoCTutAction() {
        switchScreen("CreateCourse");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        switchToNormalStyle(cTutButton);
        switchToNormalStyle(lTutButton);
        switchToNormalStyle(cLearnButton);
        switchToNormalStyle(lLearnButton);
        switchToNormalStyle(sLearnButton);
        switchToNormalStyle(gLearnButton);
        switchToNormalStyle(backButton);
    }

}
