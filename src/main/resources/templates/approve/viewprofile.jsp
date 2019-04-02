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
<title>显示所有用户信息</title>
</head>
<body>
  <%@include file="../../header.jsp" %>
  <form action="editUserinfo"  >
	<table class="table" >
	  <tr>
	    <td align="right">用户等级：</td>
	    <td>${userinfo.userLevel}</td>
	  </tr>
	  <tr>
	    <td align="right">用户名：</td>
	    <td><input type="text" value="${userinfo.tuName}" ></td>
	  </tr>
	  <tr>
	    <td align="right">登录名：</td>
	    <td>${userinfo.username}</td>
	  </tr>
	  <tr>
	    <td align="right">创建日期：</td>
	    <td>${userinfo.createtime}</td>
	  </tr>
	  <tr>
	    <td align="right">性别：</td>
	    <td>${userinfo.sex eq "1"?"男":"女"}</td>
	  </tr>
	  <tr>
	    <td align="right">生日：</td>
	    <td>${userinfo.age }</td>
	  </tr>
	  <tr>
	    <td align="right">所在地：</td>
	    <td>${userinfo.address}</td>
	  </tr>
	  <tr>
	    <td align="right">家乡：</td>
	    <td>${userinfo.hometown}</td>
	  </tr>
	  <tr>
	    <td align="right">邮箱：</td>
	    <td>${userinfo.email}   <a>  修改</a></td>
	  </tr>
	  <tr>
	    <td align="right">联系电话：</td>
	    <td>${userinfo.phone}  <a>  修改</a></td>
	  </tr>
	  <tr>
	    <td align="right"><input type="button" value="修改" onclick="window.location='/UpdateUserinfo'"></td>
	    <td><input type="button"    value="返回"  onclick="javascript:history.back(-1);"></td>
	  </tr>
	</table>
  </form>
</body>
</html>