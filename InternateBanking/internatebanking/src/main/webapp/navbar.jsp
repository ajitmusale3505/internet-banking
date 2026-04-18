<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

<%@ page import="com.jsp.internatebanking.entity.Users" %>

<%
Users user = (Users) session.getAttribute("user");
%>

<div class="navbar">

    <!-- LEFT -->
    <div class="navbar-left">
        <span class="logo">MyBank</span>
    </div>

    <!-- CENTER -->
    <div class="navbar-center">
        <a href="dashboard.jsp">Home</a>
        <a href="history">Transactions</a>
        <a href="transaction.jsp">Transfer</a>
        <a href="userprofile.jsp">Profile</a>
    </div>

    <!-- RIGHT (PROFILE ICON) -->
    <div class="navbar-right">

        <div class="profile-container">

            <% if (user != null && user.getProfileImage() != null) { %>
                <img 
                    src="<%=request.getContextPath()%>/getProfileImage?id=<%=user.getId()%>" 
                    class="profile-img"
                />
            <% } else { %>
                <div class="profile-img default-avatar">U</div>
            <% } %>

            <!-- DROPDOWN -->
            <div class="dropdown">
                <p><strong><%= user != null ? user.getName() : "User" %></strong></p>
                <a href="userprofile.jsp">View Profile</a>
                <a href="logout">Logout</a>
            </div>

        </div>

    </div>

</div>