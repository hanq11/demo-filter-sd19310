<%--
  Created by IntelliJ IDEA.
  User: syn
  Date: 02/12/2024
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="../jquery.js"></script>
    <script>
        function showData() {
            $.ajax({
                url: "/api/sinh-vien/get-all",
                type: "get",
                dataType: "json",
                success: function (response) {
                    console.log(response);
                },
                error: function () {
                    console.log("Loi");
                }
            })
        }
    </script>
</head>
<body>
<button onclick="showData()">Show data</button>
</body>
</html>
