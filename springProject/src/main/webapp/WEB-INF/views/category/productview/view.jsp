<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">

function pay(){
	var form = document.form;
	var count = document.getElementById("count").value;
	
	
	document.getElementById("product_count").value=count;
	
	form.submit();
}

</script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

 <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/shop-homepage.css" rel="stylesheet">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
.nav {
   float: left;
  padding-left: 400px;
  padding-top: 140px;
}

.section1 {
   padding-left: 900px;
   padding-top: 150px;
}
.section {
   padding-left: 900px;
 	
}
.section2 {

   padding-left: 900px; 
 
}
.button {

    width:250px;

    background-color: #f8585b;

    border: none;

    color:#fff;

    padding: 8px 0;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 15px;

    margin: 4px;

    cursor: pointer;
    
    border-radius:10px;

}
.button1 {

    width:250px;

    background-color: #5CD1E5;

    border: none;

    color:#fff;

    padding: 8px 0;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 15px;

    margin: 4px;

    cursor: pointer;
    
    border-radius:10px;

}
.button2 {

    width:100px;

    background-color: #f8585b;

    border: none;

    color:#fff;

    padding: 8px 0;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 15px;

    margin: 4px;

    cursor: pointer;
    
    border-radius:10px;

}
.button3 {

    width:100px;

    background-color: #5CD1E5;

    border: none;

    color:#fff;

    padding: 8px 0;

    text-align: center;

    text-decoration: none;

    display: inline-block;

    font-size: 15px;

    margin: 4px;

    cursor: pointer;
    
    border-radius:10px;

}
</style>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="home">KG SHOP</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
          <c:choose>
          	  <c:when test="${id eq 'system'}"><a class="nav-link" href="#" >${id }님 환영합니다 
              <span class="sr-only">(current)</span></a>
              </c:when>
              <c:when test="${empty id }"> <a class="nav-link" href="home">홈
              <span class="sr-only">(current)</span>
              </a></c:when>
          	  <c:when test="${id eq id}"><a class="nav-link" href="#" >${id }님 환영합니다 
              <span class="sr-only">(current)</span>
              </a>
              </c:when>       
          </c:choose>
           
            
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Q&A게시판</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="">리뷰게시판</a>
          </li>
          
         <li class="nav-item">
         <c:choose>
          	  <c:when test="${id eq 'system'}"></c:when>
          	  <c:when test="${empty id }"></c:when>
            <c:otherwise> <a class="nav-link" href="shoppingcart?user_id=${id}">장바구니</a></c:otherwise>
             </c:choose>
          </li>
            
           <li class="nav-item">

   
      	    <c:choose>
          	  <c:when test="${id eq 'system'}"><a class="nav-link" href="myPage">관리자페이지</a></c:when>
          	   <c:when test="${empty id }"> 
            	<a class="nav-link" href="bootMember">회원가입</a>
         		 </c:when>
          	  <c:otherwise><a class="nav-link" href="myPage">마이페이지</a></c:otherwise>    
            </c:choose>
          
          <li class="nav-item">
          	<c:choose>
          		  <c:when test="${empty id }"> <a class="nav-link" href="bootlogin">로그인</a> </c:when>
          		  <c:otherwise>  <a class="nav-link" href="logout">로그아웃</a></c:otherwise>       
            </c:choose>
          </li>
          
        </ul>
      </div>
    </div>
  </nav>


<div class="nav">
      <img
         src="<spring:url value='/imgUpload/'/>${productlist.product_name_image }"><br>
</div>
<div class="section1">
      <font>상품명: &nbsp;&nbsp;&nbsp;${productlist.product_name_title}</font>
</div>
<p>
<div class="section">
      <font>상품가격: &nbsp;&nbsp;&nbsp;<fmt:formatNumber
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
수량 : <input type="number" class="numBox" name="product_count" min="1" max="${productlist.product_stock}" value="1" readonly="readonly" 
style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; text-align: center;"/>
        <button type="button" class="plus"  style=" border:none; background:none;">+</button> 
 </section>
 <script>
  $(".plus").click(function(){
   var num = $(".numBox").val();
   var plusNum = Number(num) + 1;
   
   if(plusNum > "${productlist.product_stock}") {
    $(".numBox").val(num);
    alert('최대수량 입니다');
    $(".sumprice").val("${productlist.product_stock}"*"${productlist.product_name_price}");
   } else {
    $(".numBox").val(plusNum);
    $(".sumprice").val(plusNum*"${productlist.product_name_price}");
   }
	
  });
  
  $(".minus").click(function(){
   var num = $(".numBox").val();
   var minusNum = Number(num) - 1;
   $(".sumprice").val(minusNum*"${productlist.product_name_price}");

   if(minusNum <= 0) {
    $(".numBox").val(num);
    alert('최소수량은 1개 입니다');
    $(".sumprice").val("${productlist.product_name_price}");
 
   } else {
    $(".numBox").val(minusNum);   
   
   }

  });
 
 </script> 
 <p>
 

  <div class="section">
   총 금액 : <input type="number" class="sumprice" value="${productlist.product_name_price}" readonly="readonly"
   style="border:none;border-right:0px; border-top:0px; boder-left:0px; boder-bottom:0px; text-align: center;"/> 원
   </div>
    <div class="section">
 <p>
 </div>

 <div class="section2">
 <input type="submit" value="장바구니담기" class="button"><br>
 </div>
 <div style="padding-left: 400px;">
  
  </div>
 </form>
 
  <form name="form" action="orderview">
 	<input type="hidden" name="product_name_title" value="${productlist.product_name_title}">
 	<input type="hidden" name="product_count" value="" id="product_count">
 	<input type="button" value="결제하기" class="button1" onclick="pay()">
 </form>
  <c:choose>
         <c:when test="${id eq 'system'}">
            <a href="modifyproduct?product_name_no=${productlist.product_name_no}"><button class="button2">상품수정</button></a>
            <a href="deleteproduct?product_name_no=${productlist.product_name_no}"><button class="button3" style="margin-left: 20px;">상품삭제</button></a>
         </c:when>
         <c:when test="${empty id}"> </c:when>
         <c:otherwise>         
         </c:otherwise>
      </c:choose>
 <div style="padding-left: 400px; padding-top: 50px;">제품 설명 : ${productlist.product_name_detail}</div>
      
       
</body>
</html>