/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.db;

import com.gashar.authorize.AuthDatabase;
import com.gashar.fxml.AccountController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gasha
 */
public class AccessDatabase {

    protected static final AuthDatabase db = new AuthDatabase();
    protected static final Connection cnx = db.authorize();

    public static boolean checkPassword(String username, String pass) {
        PreparedStatement st;
        ResultSet rs;
        boolean correct = false;

        //get username and password
        //create a select query to check if the username and the password exist in the database
        String query = "SELECT * FROM `persons` WHERE `username` = ? AND `passkey` = ?";
        try {
            st = cnx.prepareStatement(query);
            st.setString(1, username);
            st.setString(2, pass);
            rs = st.executeQuery();

            if (rs.next()) {
                correct = true;
            }

        } catch (SQLException ex) {
            System.out.println("Connection did not work: " + ex);
        }
        return correct;
    }

    public static boolean checkUsername(String username) {
        PreparedStatement st;
        ResultSet rs;
        boolean exists = false;
        String query = "SELECT * FROM `persons` WHERE `username` = ?";

        try {
            st = cnx.prepareStatement(query);

            st.setString(1, username);
            rs = st.executeQuery();

            if (rs.next()) {
                exists = true;
            }
        } catch (SQLException ex) {
            System.out.println("Connection did not work: " + ex);
        }
        return exists;
    }
    
    public static String checkDoneTut(String username) {
        PreparedStatement st;
        ResultSet rs;
        String done = "";
        String query = "SELECT * FROM `persons` WHERE `username` = ?";

        try {
            st = cnx.prepareStatement(query);

            st.setString(1, username);
            rs = st.executeQuery();

            if (rs.next()) {
                done = rs.getString("doneTut");
            }
        } catch (SQLException ex) {
            System.out.println("Connection did not work: " + ex);
        }
        return done;
    }

    public static String getName(String username) {
        PreparedStatement st;
        ResultSet rs;
        String name = "";
        String query = "SELECT * FROM `persons` WHERE `username` = ?";

        try {
            st = cnx.prepareStatement(query);

            st.setString(1, username);
            rs = st.executeQuery();

            if (rs.next()) {
                name = rs.getString("FirstName");
                name += " " + rs.getString("LastName");
            }
        } catch (SQLException ex) {
            System.out.println("Connection did not work: " + ex);
        }
        return name;
    }
}
