<%--
  Created by IntelliJ IDEA.
  User: 昊洋
  Date: 2021/8/15
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>接受请求参数</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    姓名：<input type="text" name="name"> <br/>
    年龄：<input type="text" name="age"> <br/>
    <input type="submit" value="提交参数">
</form>
</body>
</html>
