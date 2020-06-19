<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 배 너 수 정</h1>
<table>
<tr>
<th>배너 순서</th>	<th>카테고리</th><th>이미지</th><th>수 정</th>
</tr>
 <c:forEach items="${banner}" var="banner" >
<tr>
	<td>${banner.banner_no}</td>
	<td>${banner.banner_category }</td><td><img  src="<spring:url value='/imgUpload/'/>${banner.banner_image}" ></td>
	 <td><a href="Modifybanner?banner_no=${banner.banner_no}">수 정 하 기</a></td>
</tr>
</c:forEach>
</table>

</body>
</html>

