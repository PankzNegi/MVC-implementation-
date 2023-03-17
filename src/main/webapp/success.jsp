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

 //User user=(User) session.getAttribute("user");
//User user=(User) request.getAttribute("user"); replaced this code below with JSTL



%>
<jsp:useBean id="user"  class="com.pankz.dto.User" scope="request"></jsp:useBean> 
<!-- id has to match the attribute that we're trying to pull up(whatever be the getAttribute parameter) -->
<!-- Above is JSTL tag to get the object from the request -->
            <!-- Printing username using script block -->
<!-- JSTL assumes attribute name same as variable name -->
Hello <jsp:getProperty property="userName" name="user"/>

</body>
</html>