/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.authorize;

import com.gashar.email.Email;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author gasha
 */
public class AuthEmail implements Authorize {

    private static String[] CREDENTIALS;
    private static String address;
    private static Email email;

    @Override
    public Object authorize() {
        return null;
    }

    @Override
    public void saveCredentials(String path) {

    }

    @Override
    public String[] getCredentials() {
        return CREDENTIALS;
    }

    public static boolean authEmail(String first, String last) {
        email = new Email(address, first, last);
        return (email.sendEmail());

    }

    public static boolean validateEmail(String input) {
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
        Pattern mailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = mailPat.matcher(input);
        address = input;
        return matcher.find();
    }

    public static boolean verifyCode(String entered) {
        return email.getCode().equals(entered);
    }
}
