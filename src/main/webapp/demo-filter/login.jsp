<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 25/11/2024
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ${message}
    <h1>Dang nhap</h1>
    <form action="/demo-filter/login" method="post">
        Username: <input type="text" name="username"> <br>
        Password: <input type="text" name="password"> <br>
        <button>Login</button>
    </form>
</body>
</html>
