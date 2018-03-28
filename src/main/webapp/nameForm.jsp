<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getMethod().equalsIgnoreCase("POST")) {
        String username = request.getParameter("name");
        if (username.equals("name")) {
            response.sendRedirect("/namePage.jsp");
        }
    }
%>



<html>
<head>
    <title>Title</title>
</head>
<body>

<h3>Please Enter your name</h3>
<form action="/name" method="post">
    <input type="text" name="username">
    <button type="submit">Submit your name</button>
</form>


<%-- this is a JSP comment, you will *not* see this in the html --%>
<!-- this is an HTML comment, you *will* see this in the html -->
</body>
</html>