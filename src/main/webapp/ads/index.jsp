<%--
  Created by IntelliJ IDEA.
  User: benrasmussen
  Date: 3/28/18
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
    <style>

        @import url('https://fonts.googleapis.com/css?family=Pacifico');

        h1 {
            color: seagreen;
            font-family: Nadeem, sans-serif;
        }

        p   {
            font-family: Pacifico, sans-serif;
            color: cornflowerblue;
        }

    </style>
</head>
<body>

    <h1>Welcome to AdLister!</h1>
    <hr>

        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <hr>
                <h1>${ad.title}</h1>
                <p>${ad.description}</p>
                <hr>
            </div>
        </c:forEach>


</body>
</html>
