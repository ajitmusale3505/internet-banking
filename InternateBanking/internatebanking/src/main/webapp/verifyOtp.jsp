<%@ page session="true" %>

<html>
<body>

<h2>Enter OTP</h2>

<form action="<%=request.getContextPath()%>/verifyOtp" method="post">

    <input type="text" name="otp" placeholder="Enter OTP" required />
    <br><br>

    <input type="submit" value="Verify OTP" />

</form>

</body>
</html>