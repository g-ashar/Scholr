/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gashar.email;

import java.util.Properties;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author gasha
 */
public class Email {

    private final static String email = Credential.getEmail();
    private final static String password = Credential.getPassword();
    private String address;
    private String firstname;
    private String lastname;
    private String code;

    public Email(String address, String fn, String ln) {
        this.address = address;
        this.firstname = fn;
        this.lastname = ln;
    }

    public boolean sendEmail() {
        try {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        System.out.println(address);

        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email, password);
            }
        };

        Session session = Session.getInstance(properties, auth);

            Message msg = prepareMessage(session);
            Transport.send(msg);
        } catch (Exception ex) {
            return false;
        }
        return true;

    }

    private Message prepareMessage(Session session) throws MessagingException {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(email));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(address));
        message.setSubject("Scholr: Action Required");

        StringBuilder c = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            Random rand = new Random();
            c.append(rand.nextInt(10));
        }
        this.code = c.toString();
        message.setContent("<h2>Hi " + this.firstname + " " + this.lastname + "! Welcome to the Scholr Community!</h1>\n" +
                "  <p>Before we get started, please validate your email address by " +
                "copying the code below and using it in the desktop app!</p>\n" +
                "  <center>\n" +
                "    <h1>" + this.code + "</h1>\n" +
                "  </center>\n" +
                "  <p>Thank you!</p>\n" +
                "  <p>The Scholr team</p>", "text/html");
        return message;
    }

    public String getCode() {
        return code;
    }

}
