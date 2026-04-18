package com.jsp.internatebanking.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.internatebanking.entity.Users;
import com.jsp.internatebanking.util.JPAUtil;
import com.jsp.internatebanking.util.OtpUtil;

@WebServlet("/forget")
public class ForgetPasswordController extends HttpServlet{
	@Override
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String email = request.getParameter("email");

	        int otp = OtpUtil.generateOtp();

	        HttpSession session = request.getSession();
	        session.setAttribute("email", email);
	        session.setAttribute("flow", "forgot");

	        OtpUtil.storeOtp(session, otp);

	        request.setAttribute("generatedOtp", otp);

	        request.getRequestDispatcher("verifyOtp.jsp").forward(request, response);
	    }
}
