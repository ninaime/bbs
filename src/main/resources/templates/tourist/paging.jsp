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
<title>头部信息</title>

<style>
	.small_input{
		width: 30px;
		height:20px;
	}

	.paging_a{
		color: black;
	}
	
	.span_button{
		line-height: 20px;
		cursor: pointer;
		color:black;
	}
	
</style>
</head>
<body>
<div>
  <ul class="pagination">
    <c:choose>
	  <c:when test="${page.pageNum<=page.beginIndex }">
	 	<li  class="disabled">
		  <a href="#" aria-label="Previous" >
			<span aria-hidden="true">首页</span>
		  </a>
		</li>
		<li  class="disabled">
				      <a href="#" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    </c:when>
				    <c:otherwise>
				    <li>
				      <a href="${pageContext.request.contextPath}/UserServlet/userShowAll?pages=${page.beginIndex}" aria-label="Previous">
				        <span aria-hidden="true">首页</span>
				      </a>
				    </li>
				    <li>
				      <a href="${pageContext.request.contextPath}/UserServlet/userShowAll?pages=${page.pageNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
				    </c:otherwise>
				    </c:choose>
				    <li><a href="#">1</a></li>
				    <li><a href="#">2</a></li>
				    <li><a href="#">3</a></li>
				    <li><a href="#">4</a></li>
				    <li><a href="#">5</a></li>
				    
				    <c:choose>
				      <c:when test="${page.pageNum>=page.endIndex }">
					    <li class="disabled">
					      <a href="#" aria-label="Next">
					        <span aria-hidden="true">&raquo;</span>
					      </a>
					    </li>
					    <li class="disabled">
					      <a href="#" aria-label="Previous">
					        <span aria-hidden="true">末页</span>
					      </a>
					    </li>
					  </c:when>
					  <c:otherwise>
						  <li>
						      <a href="${pageContext.request.contextPath}/UserServlet/userShowAll?pages=${page.pageNum+1}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
		</li>
		<li>
		  <a href="${pageContext.request.contextPath}/UserServlet/userShowAll?pages=${page.endIndex}" aria-label="Previous">
			<span aria-hidden="true">末页</span>
		  </a>
		</li>
	  </c:otherwise>
  	</c:choose>
  	<li>
	  <a aria-label="Previous" class="paging_a">
		<span aria-hidden="true">
			跳转到<input type="text"  name="pageNum"  class="small_input" maxlength="5">页
		 	<span class="span_button">跳转</span>
		</span>
	  </a>
  	</li>
  	<li>
	  <a aria-label="Previous">
		<span aria-hidden="true">总页数：${page.endIndex}</span>
	  </a>    
  	</li>
  	<li>
	  <a aria-label="Previous">
		<span aria-hidden="true">
		  每页
		  <select>
			<c:forEach begin="1" end="5"  varStatus="status">
			  <option value="pageSize">${status.index*10}</option>
		  	</c:forEach>
		  </select>
	 	  条
		</span>
	  </a>
  	</li>
  </ul>
</div>
</body>
</html>