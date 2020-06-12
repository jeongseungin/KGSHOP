<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  
<html>
<head>
	<title>Home</title>
	  <!-- Bootstrap core CSS -->
  <link href="./resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="./resources/css/shop-homepage.css" rel="stylesheet">
</head>
<body>

<h1>노트북 카테고리</h1>

<c:forEach items="${notebooklists}" var="dto">
상품 고유번호 : ${dto.product_name_no}<br>
상품 카테고리 : ${dto.product_category_no}	<br>
상품 명 :  <a href ="productview/view2?product_name_no=${dto.product_name_no}">${dto.product_name_title}</a>	<br>
상품 가격 :<fmt:formatNumber value="${dto.product_name_price}"  /> 원  	<br>	
상품 설명 :  ${dto.product_name_detail}	<br>
상품 썸네일 : <img src="<spring:url value='/imgUpload/'/>${dto.product_thumbnail }" ><br>
상품 이미지 : <img src="<spring:url value='/imgUpload/'/>${dto.product_name_image }" ><br>
재고량 :  ${dto.product_stock} 개<br>
<hr>
</c:forEach>


<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/">KG SHOP</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">홈
              <span class="sr-only">(current)</span>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="QnA">Q&A게시판</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="bootMember">회원가입</a>
          </li>
           <li class="nav-item">
            <a class="nav-link" href="shoppingcart?user_id=test">장바구니</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="bootlogin">로그인</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

      
        <div class="list-group" style=position:fixed;>
          <h1 class="my-4">Category</h1>
          <a href="notebookproduct" class="list-group-item">노트북</a>
          <a href="computerproduct" class="list-group-item">컴퓨터</a>
          <a href="moniterproduct" class="list-group-item">모니터</a>
          <a href="mouseproduct" class="list-group-item">마우스</a>
          <a href="speakerproduct" class="list-group-item">스피커</a>
          <a href="graphiccardproduct"class="list-group-item">그래픽카드</a>
          <a href="cpuproduct" class="list-group-item">CPU</a>
          <a href="mainboardproduct" class="list-group-item">메인보드</a>
          <a href="hddproduct" class="list-group-item">하드디스크</a>
          <a href="sddproduct" class="list-group-item">SDD</a>
       
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <br>

        <div class="row">
		<c:forEach items="${notebooklists}" var="dto">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <a href="productview?product_name_no=${dto.product_name_no}"><img class="card-img-top" src="<spring:url value='/imgUpload/'/>${dto.product_thumbnail }" ></a>
              <div class="card-body">
                <h4 class="card-title">
                  <a href="productview?product_name_no=${dto.product_name_no}">${dto.product_name_title}</a>
                </h4>
                <h5><fmt:formatNumber value="${dto.product_name_price}"  /> 원 </h5>
                <p class="card-text"> ${dto.product_name_detail}</p>
              </div>
              <div class="card-footer">
            			  재고량 :  ${dto.product_stock} 개
              </div>
            </div>
          </div>
		</c:forEach>
        </div>
        <!-- /.row -->

      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="./resources/vendor/jquery/jquery.min.js"></script>
  <script src="./resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
