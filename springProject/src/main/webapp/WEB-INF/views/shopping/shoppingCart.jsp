<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>장바구니 페이지</h1>


유저아이디 :${shoppingcart.id }<br>
이미지 :<img src="<spring:url value='/imgUpload/'/>${shoppingcart.product_name_image }"/>
상품명 : ${shoppingcart.product_name_title}<br>
가격 : ${shoppingcart.product_name_price}<br>
수량 :${shoppingcart.product_count}<br>
 : 
총 가격 :<fmt:formatNumber value="${shoppingcart.product_name_price * shoppingcart.product_count}" pattern="###,###,###"  />원	<br>	


</body>
</html>