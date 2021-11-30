<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 昊洋
  Date: 2021/8/17
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件下载</title>
</head>
<body>
<fieldset>
    <legend>文件下载</legend>
    <table>
        <tr>
            <td>文件名</td>
            <td>下载</td>
        </tr>
        <c:forEach var="fileName" items="${fileNames}">
            <tr>
                <td>${fileName}</td>
               <%-- <td><a href="${pageContext.request.contextPath}/download?filename=${fileName}">download</a></td>--%>
                    <td><a href="${pageContext.request.contextPath}/down?filename=${fileName}">download</a></td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
