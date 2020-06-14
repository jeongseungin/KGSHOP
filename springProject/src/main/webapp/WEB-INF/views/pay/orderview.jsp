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
<body>
<form name="order" method="post" action="Saveorders">
주문 정보
   <br>
상품 명 :<input type="text" value="${orderview.product_name_title}"  readonly="readonly" name="product_name_title"> <br>
상 품 이 미 지 : <img src="<spring:url value='/imgUpload/'/>${orderview.product_name_image}"/><br>
가 격 : <input type="text" value="${orderview.product_name_price}"  readonly="readonly" name="product_name_price"> <br>
			<button type="button" class="minus"  style="border:none; background:none;">-</button>
수량 : <input type="number" class="numBox" name="product_count" min="1"  value="1" readonly="readonly"/> 
  			<button type="button" class="plus"  style=" border:none; background:none;">+</button> <br>
 <script>
  $(".plus").click(function(){
   var num = $(".numBox").val();
   var plusNum = Number(num) + 1;
   $(".sumprice").val(plusNum*"${orderview.product_name_price}");
   if(plusNum >= "${orderview.product_stock}") {
    $(".numBox").val(num);
    alert('최대수량 입니다');
   } else {
    $(".numBox").val(plusNum);  
   }	
  });
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   $(".sumprice").val(minusNum*"${orderview.product_name_price}");
   if(minusNum <= 0) {
    $(".numBox").val(num);
    alert('최소수량은 1개 입니다');
    $(".sumprice").val("${orderview.product_name_price}");
   } else {
    $(".numBox").val(minusNum);   
   }
  });
 </script> 
총 금액 : <input type="number" class="sumprice"  readonly="readonly" name="product_sumprice" value="${orderview.product_name_price}" /> 원

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