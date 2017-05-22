<%--
  Created by IntelliJ IDEA.
  User: Dell
  Date: 22-May-17
  Time: 8:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page session="false" %>
<html>
<head>
    <title>Upload File Request Page</title>
</head>
<body>
<form method="POST" action="http://localhost:8080/uploadFile" enctype="multipart/form-data">
    File to upload: <input type="file" name="file">

    Name: <input type="text" name="name">


    <input type="submit" value="Upload"> Press here to upload the file!
</form>
</body>
</html>