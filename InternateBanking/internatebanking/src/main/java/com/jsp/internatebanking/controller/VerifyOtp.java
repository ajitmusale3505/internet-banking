package com.jsp.internatebanking.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.internatebanking.dao.UserDao;
import com.jsp.internatebanking.entity.Users;
import com.jsp.internatebanking.util.OtpUtil;
import com.jsp.internatebanking.util.PasswordUtil;

@WebServlet(value = "/verifyOtp")
public class VerifyOtp extends HttpServlet{
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    HttpSession session = request.getSession();

	    int enteredOtp = Integer.parseInt(request.getParameter("otp"));
	    Integer sessionOtp = (Integer) session.getAttribute("otp");

	    if (sessionOtp == null || enteredOtp != sessionOtp) {
	        response.getWriter().println("<script>alert('Invalid OTP'); window.history.back();</script>");
	        return;
	    }

	    Users user = (Users) session.getAttribute("user");
	    String newPassword = (String) session.getAttribute("newPassword");

	 
	    String newSalt = PasswordUtil.generateSalt();
	    String hashedPassword = PasswordUtil.hashPassword(newPassword, newSalt);

	    user.setSalt(newSalt);
	    user.setPassword(hashedPassword);

	    UserDao dao = new UserDao();
	    dao.updateUser(user);
 
	    session.removeAttribute("otp");
	    session.removeAttribute("newPassword");

	    response.getWriter().println(
	        "<script>" +
	        "alert('Password updated successfully');" +
	        "window.location='" + request.getContextPath() + "/userprofile.jsp';" +
	        "</script>"
	    );
	}
}
