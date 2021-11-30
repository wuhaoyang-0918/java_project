<%--
  Created by IntelliJ IDEA.
  User: 昊洋
  Date: 2021/8/17
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出</title>
</head>
<body>
退出！！！
<%
session.removeAttribute("userName");
%>
</body>
</html>
