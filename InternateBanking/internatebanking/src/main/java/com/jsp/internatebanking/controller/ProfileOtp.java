package com.jsp.internatebanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.internatebanking.util.OtpUtil;

public class ProfileOtp extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int otp = OtpUtil.generateOtp();

	        HttpSession session = request.getSession();
	        session.setAttribute("flow", "profile");

	        OtpUtil.storeOtp(session, otp);

	        request.setAttribute("generatedOtp", otp);

	        request.getRequestDispatcher("verifyOtp.jsp").forward(request, response);
	    }
}
