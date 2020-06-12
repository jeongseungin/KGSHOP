<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
.nav {
	float: left;
}

.section {
	padding-left: 300px;
}
</style>
</head>
<body onload="init();">
	<script language="JavaScript">
 //총 가격 계산
  var sell_price;
  var product_count;

  function init () {
		sell_price = document.view.sell_price.value;
		product_count = document.view.product_count.value;
		document.view.sum.value = sell_price;
		change();
	}

	function add () {
		hm = document.view.product_count;
		sum = document.view.sum;
		
	
		if(hm.value >=${productlist.product_stock}){
			 alert('최대수량 입니다');
		}else{
			hm.value ++ ;
		}

		sum.value = parseInt(hm.value) * sell_price;
	}

	function del () {
		hm = document.view.product_count;
		sum = document.view.sum;
			if (hm.value > 1) {
				hm.value -- ;
				sum.value = parseInt(hm.value) * sell_price;
			}
		if(hm.value <= 1){
			alert('최소수량입 니다');
		}
	}

	function change () {
		hm = document.view.product_count;
		sum = document.view.sum;

			if (hm.value < 0) {
				hm.value = 0;
			}
		sum.value = parseInt(hm.value) * sell_price;
	}  
 
  </script>
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


		<section class="section">
			수량 : <input type=hidden name="sell_price"
				value="${productlist.product_name_price}"> 
				<input type="button" value=" - " onclick="del();" class="minus"  style="border:none; background:none;"> 
				<input type="text" name="product_count" value="1" size="3" onchange="change();" style="text-align: center; border:none; background:none;;"
				class="numBox" min="1" max="${productlist.product_stock}" readonly="readonly"> 
				<input type="button" value=" + " onclick="add();" class="plus"  style="border:none; background:none;"><br>
		</section>
		<p>
		
		<p>
			<input type="hidden" name="product_name_image" value="${productlist.product_name_image }">
			<input type="hidden" name="product_name_title" value="${productlist.product_name_title}">
			<input type="hidden" name="product_name_price" value="${productlist.product_name_price}">
			
		<div class="section">
			<input type="submit" value="장바구니담기">
			<button onclick="location.href='#'">결제하기</button>
		</div>
		<p>
	</form>
	<div class="section">
			총금액 : <input type="text" name="sum" id="money" size="11" readonly 
			style="border: none; border-right: 0px; border-top: 0px; boder-left: 0px; boder-bottom: 0px;"
				onkeyup="numberWithCommas(this.vale)">
		</div>
	<section>상품 설명 : ${productlist.product_name_detail}</section>
	<p>
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