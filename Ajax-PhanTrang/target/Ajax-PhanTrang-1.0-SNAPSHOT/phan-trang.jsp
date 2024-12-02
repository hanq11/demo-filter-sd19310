<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 02/12/2024
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Bang</h2>
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Ten</th>
                <th>Dia chi</th>
                <th>Luong</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${danhSach}" var="bacSi">
                <tr>
                    <td> ${bacSi.id} </td>
                    <td> ${bacSi.ten} </td>
                    <td> ${bacSi.diaChi} </td>
                    <td> ${bacSi.luong} </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/bac-si/phan-trang?page=${page - 1}">Prev</a>
    <a href="/bac-si/phan-trang?page=${page + 1}">Next</a>
</body>
</html>
