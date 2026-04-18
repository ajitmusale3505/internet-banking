package com.jsp.internatebanking.util;

import javax.servlet.http.HttpSession;

public class OtpUtil {

    public static int generateOtp() {
        return (int)(Math.random() * 9000) + 1000;
    }

    public static void storeOtp(HttpSession session, int otp) {
        session.setAttribute("otp", otp);
    }

    public static boolean verifyOtp(HttpSession session, int enteredOtp) {
        Object otpObj = session.getAttribute("otp");

        if (otpObj == null) return false;

        int sessionOtp = (int) otpObj;
        return sessionOtp == enteredOtp;
    }
}