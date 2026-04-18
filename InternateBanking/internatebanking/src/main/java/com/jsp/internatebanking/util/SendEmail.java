package com.jsp.internatebanking.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public static void sendOTP(String toEmail, int otp) {

        final String fromEmail = "ajitmusale355@gmail.com";   // replace
        final String password = "@jit3505";       // replace

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(fromEmail));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject("OTP Verification");
            message.setText("Your OTP is: " + otp);

            Transport.send(message);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}