<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.pankz.dto.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<h3>Login Successfull</h3>
<%
User user=(User) session.getAttribute("user");



%>
Hello<%=user.getUserName() %>!!

</body>
</html>