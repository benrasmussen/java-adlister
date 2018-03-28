
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>COLOR PICKER</title>
</head>
<body>

<h1>Enter your favorite color</h1>
<form action="/PickColor" method="POST">
    <input type="color" name="color">
    <input type="text" name="title">
    <button>Submit</button>
</form>

</body>
</html>