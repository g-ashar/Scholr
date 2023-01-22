/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.db;

import com.gashar.fxml.AccountController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gasha
 */
public class UploadDatabase extends AccessDatabase {

    public static void addUser(String lastName, String firstName, String username, String pass) {
        if (!checkUsername(username)) {
            PreparedStatement ps;

            String registerQuery = "INSERT INTO `persons`(`LastName`, `FirstName`, `username`, `passkey`, `doneTut`) VALUES (?,?,?,?,?)";

            try {
                ps = cnx.prepareStatement(registerQuery);
                ps.setString(1, lastName);
                ps.setString(2, firstName);
                ps.setString(3, username);
                ps.setString(4, pass);
                ps.setString(5, "false");
                if (ps.executeUpdate() != 0) {
                    AccountController.showCreationBox();
                } else {
                    AccountController.showCreationErrorBox();
                }
            } catch (SQLException ex) {
                System.out.println("Account not created: " + ex);
            }

        }
    }

    public static void switchDoneTut(String username) {
        PreparedStatement st;
        String query = "UPDATE persons SET doneTut=? WHERE username=?";
        System.out.println(query);

        try {
            st = cnx.prepareStatement(query);
            st.setString(1, "true");
            st.setString(2, username);
            st.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Connection did not work: " + ex);
        }

    }

}
