<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<span style="color:red">上传成功</span><br>
<br>
<c:forEach items="${imgs}" var="img">
	<a href="${pageContext.request.contextPath}/downloadFile.do?fileName=${img}">
		<img alt="" src="${pageContext.request.contextPath}/upload/${img}" 
		style="width:300px;height:260px;"/>
	</a>
</c:forEach>
</body>
</html>