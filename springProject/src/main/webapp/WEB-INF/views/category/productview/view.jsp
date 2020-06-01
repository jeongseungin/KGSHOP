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
<h1>상품 상세보기</h1>


상품 고유번호 : ${productlist.product_name_no}<br>
상품 카테고리 : ${productlist.product_category_no}	<br>
상품 명 :  ${productlist.product_name_title}	<br>
상품 가격 :<fmt:formatNumber value="${productlist.product_name_price}"  /> 원  	<br>	
상품 설명 :  ${productlist.product_name_detail}	<br>
상품 썸네일 : <img src="<spring:url value='/imgUpload/'/>${productlist.product_thumbnail }" ><br>
상품 이미지 : <img src="<spring:url value='/imgUpload/'/>${productlist.product_name_image }" ><br>
재고량 :  ${productlist.product_stock} 개<br>
<hr>

<a href="modifyproduct?product_name_no=${productlist.product_name_no}"><button>수정</button></a>  
<a href="deleteproduct?product_name_no=${productlist.product_name_no}"><button>삭제</button></a>

</body>
</html>