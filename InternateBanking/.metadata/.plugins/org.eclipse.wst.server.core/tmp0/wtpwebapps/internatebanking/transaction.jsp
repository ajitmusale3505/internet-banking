<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send Money</title>

<!-- ✅ LOAD CSS PROPERLY -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dashboard.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/transaction.css">

</head>

<body>

<!-- ✅ INCLUDE NAVBAR INSIDE BODY -->
<jsp:include page="navbar.jsp" />

<!-- PAGE CONTENT -->
<div class="transaction-container">

    <h2>Send Money</h2>

    <form action="transaction" method="post">

        <input type="email" name="email" placeholder="Enter User Email..." required><br>

        <input type="number" name="amount" placeholder="0.00" required><br>

        <input type="submit" name="send" value="Send">

        <h4 class="error-msg">${error}</h4>

    </form>

</div>

<a href="dashboard.jsp" class="back-btn">Back To Dashboard</a>

</body>
</html>