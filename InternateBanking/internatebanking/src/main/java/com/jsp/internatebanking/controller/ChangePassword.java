package com.jsp.internatebanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.internatebanking.entity.Users;
import com.jsp.internatebanking.util.OtpUtil;
import com.jsp.internatebanking.util.PasswordUtil;
import com.jsp.internatebanking.util.SendEmail;

@WebServlet(value = "/changePassword")
public class ChangePassword extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();
	    Users user = (Users) session.getAttribute("user");

	    String currentPassword = request.getParameter("currentPassword");
	    String newPassword = request.getParameter("newPassword");

	    
	    String hashedCurrent = PasswordUtil.hashPassword(currentPassword, user.getSalt());

	    if (!hashedCurrent.equals(user.getPassword())) {
	        response.getWriter().println("<script>alert('Wrong current password'); window.history.back();</script>");
	        return;
	    }

	  
	    int otp = OtpUtil.generateOtp();

	    
	    session.setAttribute("otp", otp);
	    session.setAttribute("newPassword", newPassword);

	     
	    response.getWriter().println(
	        "<script>" +
	        "alert('Your OTP is: " + otp + "');" +
	        "window.location='" + request.getContextPath() + "/verifyOtp.jsp';" +
	        "</script>"
	    );
	}
}
