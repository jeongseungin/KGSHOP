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
<h1>상의 카테고리</h1>

<c:forEach items="${toplists}" var="dto">
상품 고유번호 : ${dto.product_name_no}  	<br>
상품 카테고리 : ${dto.product_category_no}	<br>
상품 명 :  <a href =" ">${dto.product_name_title}</a>	<br>
상품 가격 :  ${dto.product_name_price}	<br>	
상품 설명 :  ${dto.product_name_detail}	<br>

상품 이미지 : <img src="<spring:url value='/imgUpload/'/>${dto.product_thumbnail }" ><br>
상품 이미지 : <img src= "<c:url value='${dto.product_thumbnail }'/>"><br>
${dto.product_name_image }<br>
상품 사이즈 :  ${dto.product_name_size}<br>
상품 색깔 :  ${dto.product_name_color}	<br>
재고량 :  ${dto.product_stock}<br>
</c:forEach>

</body>
</html>