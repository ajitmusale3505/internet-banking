package com.jsp.internatebanking.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jsp.internatebanking.dao.TransactionDao;
import com.jsp.internatebanking.dao.UserDao;
import com.jsp.internatebanking.entity.BankTransaction;
import com.jsp.internatebanking.entity.Users;


@WebServlet(value = "/history")
public class HistoryController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");

        String type = request.getParameter("type"); // debit / credit / all

        List<BankTransaction> allTransactions = TransactionDao.getAllTransactions(user.getId());

        List<BankTransaction> filteredList = new ArrayList<>();

        if (type == null || type.equals("all")) {
            filteredList = allTransactions;
        } else if (type.equals("debit")) {
            for (BankTransaction t : allTransactions) {
                if (t.getSenderID() == user.getId()) {
                    filteredList.add(t);
                }
            }
        } else if (type.equals("credit")) {
            for (BankTransaction t : allTransactions) {
                if (t.getReciverID() == user.getId()) {
                    filteredList.add(t);
                }
            }
        }

        request.setAttribute("transactions", filteredList);
        request.setAttribute("userId", user.getId());

        request.getRequestDispatcher("history.jsp").forward(request, response);
    }
}
