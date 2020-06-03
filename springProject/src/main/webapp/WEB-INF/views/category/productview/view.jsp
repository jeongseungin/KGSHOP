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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

</head>
<body>
<h1>상품 상세보기</h1>

상품 고유번호 : ${productlist.product_name_no}<br>
상품 카테고리 : ${productlist.product_category_no}	<br>
상품 설명 :  ${productlist.product_name_detail}	<br>
재고량 :  ${productlist.product_stock} 개<br>

상품 명 :${productlist.product_name_title}<br>
상품 가격 :<fmt:formatNumber value="${productlist.product_name_price}" pattern="###,###,###"  />원	<br>	
상품 이미지 :<img src="<spring:url value='/imgUpload/'/>${productlist.product_name_image }"><br>


  
  
  <form name="view" id="view" method="post" action="SaveshoppingCart">
  <input type="hidden" name="product_name_image" value="${productlist.product_name_image }">
  <input type="hidden" name="product_name_title" value="${productlist.product_name_title}">
  <input type="hidden" name="product_name_price" value="${productlist.product_name_price}">
    		<button type="button" class="minus"  style="border:none; background:none;">-</button>
수량 : <input type="number" class="numBox" name="product_count" min="1" max="${productlist.product_stock}" value="1" readonly="readonly"/>
  		<button type="button" class="plus"  style=" border:none; background:none;">+</button> 
  <hr>
 <script>
  $(".plus").click(function(){
   var num = $(".numBox").val();
   var plusNum = Number(num) + 1;
   
   if(plusNum >= "${productlist.product_stock}") {
    $(".numBox").val(num);
    alert('최대수량 입니다');
   } else {
    $(".numBox").val(plusNum);          
   }
  });
  
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   
   if(minusNum <= 0) {
    $(".numBox").val(num);
    alert('최소수량은 1개 입니다');
   } else {
    $(".numBox").val(minusNum);          
   }
  });
 </script> 
 <input type="submit" value="장바구니담기">
 </form>
 
<hr>

<!-- 관리자만 볼수있게 설정해야됩니다 -->
<a href="modifyproduct?product_name_no=${productlist.product_name_no}"><button>수정</button></a>  
<a href="deleteproduct?product_name_no=${productlist.product_name_no}"><button>삭제</button></a>

</body>
</html>