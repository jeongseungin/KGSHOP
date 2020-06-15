<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<script type="text/javascript">
	if(${orderview.product_stock} <= 0){
		alert('재고량이 없어 결제 하실수 없습니다');
		location.href="home";
	} 
</script>

<body >

<form name="order" method="post" action="Saveorders" >
주문 정보
   <br>
상품 명 :<input type="text" value="${orderview.product_name_title}"  readonly="readonly" name="product_name_title"> <br>
상 품 이 미 지 : <img src="<spring:url value='/imgUpload/'/>${orderview.product_name_image}"/><br>
가 격 : <input type="text" value="${orderview.product_name_price}" id="product_name_price" readonly="readonly" name="product_name_price"> <br>		
수량 : <input type="number" class="numBox" name="product_count"  id="count" value="${count}" readonly="readonly"/> 
총 금액 : <input type="number" class="sumprice"  readonly="readonly" name="product_sumprice" id="sumprice" value="${sum}" /> 원

<hr>
배송 정보 
주문 하시는 분 :<input type="text" value="${id}"  readonly="readonly" name="id">    <br>
이 메 일 : <input type="text" name="email">				<br>
주 소 : <input type="text" name="addr">				<br>
휴대 전화 : <input type="text" name="tel">			<br>

<input type="submit" value="결제하기">
</form>
</body>
</html>