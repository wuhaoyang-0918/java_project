<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 昊洋
  Date: 2021/8/17
  Time: 17:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h1>单文件上传</h1>
<form action="${pageContext.request.contextPath}/upload/singleFile" method="post" enctype="multipart/form-data">
    选择文件:<input type="file" name="multipartFile"><br>
    文件描述：<label>
    <textarea rows="2" name="description"></textarea>
</label><br>
    <input type="submit" value="提交">
</form>
<h1>多文件上传</h1>
<form action="${pageContext.request.contextPath}/upload/singleFiles" method="post" enctype="multipart/form-data">
    <fieldset>
        <legend>上传文件1</legend>
        选择文件:<input type="file" name="multipartFile"><br>
        文件描述：<label>
        <textarea rows="3" name="description"></textarea>
    </label><br>
    </fieldset>
    <fieldset>
        <legend>上传文件2</legend>
        选择文件:<input type="file" name="multipartFile"><br>
        文件描述：<label>
        <textarea rows="3" name="description"></textarea>
    </label><br>
    </fieldset>
    <input type="submit" value="提交">
</form>
<h1>文件下载</h1>
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
                <td><a href="${pageContext.request.contextPath}/download?filename=${fileName}">download</a></td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>
