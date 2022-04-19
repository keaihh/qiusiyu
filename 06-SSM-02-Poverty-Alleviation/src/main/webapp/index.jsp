<%--
  Created by IntelliJ IDEA.
  User: 33342
  Date: 2022/4/13
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>文件上传页</title>
</head>
<body>
<form method="post" action="/uploadImg" src="http://localhost:8081/upload/${img}" enctype="multipart/form-data">
    <input type="file" name="file">
    <input type="submit" value="上传">
</form>
<img src="http://localhost:8081/upload/${img}">
<form method="post" action="/file/download?filename=${img}">
    <input type="submit" value="下载">
</form>

</body>
</html>
