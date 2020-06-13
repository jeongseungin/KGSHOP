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
<style type="text/css">
.nav {
   float: left;
}

.section {
   padding-left: 300px;
}
</style>
</head>
<body>
<h1>상품 상세보기</h1>

<div class="nav">
      <img
         src="<spring:url value='/imgUpload/'/>${productlist.product_name_image }"><br>
</div>
<div class="section">
      <font>상품명 &nbsp;&nbsp;&nbsp;${productlist.product_name_title}</font>
</div>
<p>
<div class="section">
      <font>상품가격 &nbsp;&nbsp;&nbsp;<fmt:formatNumber
            value="${productlist.product_name_price}" pattern="###,###,###" />원
      </font>
   </div>
<p>

  <form name="view" id="view" method="post" action="SaveshoppingCart">
  <input type="hidden" name="product_name_image" value="${productlist.product_name_image }">
  <input type="hidden" name="product_name_title" value="${productlist.product_name_title}">
  <input type="hidden" name="product_name_price" value="${productlist.product_name_price}">
    <section class="section">      
          <button type="button" class="minus"  style="border:none; background:none;">-</button>
수량 : <input type="number" class="numBox" name="product_count" min="1" max="${productlist.product_stock}" value="1" readonly="readonly"/>
        <button type="button" class="plus"  style=" border:none; background:none;">+</button> 
 </section>
 <script>
 $(".plus").click(function(){
	   var num = $(".numBox").val();
	   var plusNum = Number(num) + 1;
	   $(".sumprice").val(plusNum*"${productlist.product_name_price}");
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
	   $(".sumprice").val(minusNum*"${productlist.product_name_price}");
	   if(minusNum <= 0) {
	    $(".numBox").val(num);
	    alert('최소수량은 1개 입니다');
	    
	   } else {
	    $(".numBox").val(minusNum);   
	  
	   }

	  });

 
 </script> 
 <p>
 

  <div class="section">
   총 금액 : <input type="number" class="sumprice" value="${productlist.product_name_price}" readonly="readonly"/> 원
   </div>
    <div class="section">
 <p>

 <input type="submit" value="장바구니담기">
 <button onclick="location.href='#'">결제하기</button> 
 </div>
 </form>
 
 <section>상품 설명 : ${productlist.product_name_detail}</section>


<!-- 관리자만 볼수있게 설정해야됩니다 -->
<c:choose>
         <c:when test="${id eq 'system'}">
            <a href="modifyproduct?product_name_no=${productlist.product_name_no}"><button>수정</button></a>
            <a href="deleteproduct?product_name_no=${productlist.product_name_no}"><button>삭제</button></a>
         </c:when>
         <c:when test="${empty id}"> </c:when>
         <c:otherwise>         
         </c:otherwise>
      </c:choose>
</body>
</html>