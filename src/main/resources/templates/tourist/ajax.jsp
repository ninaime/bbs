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
<title>异步刷新</title>
<script type="text/javascript">
	function getRoleInfo(){
		$.ajax({
			type:"post",
			url:"<%=request.getContextPath()%>/Common/getRoleInfo",
			data:'{"roleId":'+$("#roleId").val()+'}',
			contentType:"application/json;charset=utf-8",
			success:function(sysRole){
				$("#roleName").val(sysRole.roleName);
				$("#describe").val(sysRole.describe);
			},error:function(XMLHttpRequest, textStatus, errorThrown){
            	alert("请求对象XMLHttpRequest: "+XMLHttpRequest);
            	alert("错误类型textStatus: "+textStatus);
            	alert("异常编号"+XMLHttpRequest.status);
            	alert("执行步数"+XMLHttpRequest.readyState);
            	alert("异常对象errorThrown: "+errorThrown);
            }
		});
	}
</script>
</head>
<body>
<div>
	 <%@include file="../header.jsp" %>
	角色编号：<input type="text" id="roleId" name="roleId" onblur="getRoleInfo()"><br>
	角色姓名：<input type="text" name="roleName" id="roleName"><br>
	角色描述：<input type="text"  name="describe"  id="describe"><br>
</div>
</body>
</html>