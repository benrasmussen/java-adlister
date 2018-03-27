<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: benrasmussen
  Date: 3/27/18
  Time: 10:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getMethod().equalsIgnoreCase("post")) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals("") || password.equals("")) {
            response.setContentType("text/html");
            PrintWriter err = response.getWriter();
            err.println("<h6>You must enter a valid username and password</h6>");
        }
        if (username.equals("admin") && password.equals("password")) {
            response.sendRedirect("/profile.jsp");
        }
    }
%>

<html>
<head>
    <jsp:include page="partials/Bootstrap.jsp"></jsp:include>
</head>
<body>

    <jsp:include page="partials/navbar.jsp"></jsp:include>

    <jsp:include page="partials/header-top.jsp">
            <jsp:param name="header_top" value="Welcome to Adlister!"/>
    </jsp:include>


    <div class="main-div" style="width: 500px">
        <h1>Please Log In</h1>
        <form action="/login.jsp" method="POST"> <!-- action has to route to specified folder and sends a POST request to login.jsp -->
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block" value="Log In">
        </form>
    </div>
</body>
</html>
