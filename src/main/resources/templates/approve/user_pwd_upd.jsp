<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<title>修改密码</title>
</head>
<body>
  <%@include file="../../header.jsp" %>
  <form  action="/UpdatePassword" name="login" method="post">
	<table class="table" >
	  <tr>
	  	<td>输入原密码：</td>
	  	<td><input type="text"  name="originalPassword"></td>
  	  </tr>
  	  <tr>
	    <td>输入新密码：</td>
	  	<td><input type="text"  name="newPassword"></td>
  	  </tr>
  	  <tr>
	  	<td>确认新密码：</td>
	  	<td><input type="text"  name="confirmNewPassword"></td>	  
  	  </tr>
	</table>
  </form>
</body>
</html>