<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
<title>上传文件</title>

</head>
<body>
<div>
	<!-- 
		客户端：
			1.使用<input type="file">表单域
			2.提交方式使用post提交
			3.修改表单的enctype属性为enctype="multipart/form-data"
	 -->
	<form action="${pageContext.request.contextPath}/Common/upload" method="post" enctype="multipart/form-data">
		上传文件：<input type="file" name="uploadFile"/><br>
		<img alt="" src="${filePath }" name="uploadFile"><br>
		<input type="submit" value="上传">
	</form>
</div>
</body>
</html>