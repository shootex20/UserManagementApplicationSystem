<%-- 
    Document   : login
    Created on : Apr 6, 2021, 12:21:26 AM
    Author     : 813017
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Management System</h1>
        <br>
        <h3>Login</h3>
        <br>
        <form method="post">
        <label for="title">Username: </label>
        <input type="text" name="email" value="${email}">
        <br>
        <label for="title">Password: </label>
        <input type="password" name="password" value="${password}">
        <br>
        <input type="submit" name="login" value="Login">
        <br>
        <br>
        <h4>${loginmessage}</h4>
</form>
    </body>
</html>
