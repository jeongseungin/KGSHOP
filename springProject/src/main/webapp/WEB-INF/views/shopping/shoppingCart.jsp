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
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
$(function(){ 
	//전체선택 체크박스 클릭 	
	$("#allCheck").click(function() { 
			if ($("#allCheck").prop("checked")) {
				$("input[type=checkbox]").prop("checked", true); 
			} else { 
				$("input[type=checkbox]").prop("checked", false);
			}
		})
	})
</script>
<style>
table.type08 {
    border-collapse: collapse;
    text-align: center;
    line-height: 1.5;
    border-left: 1px solid #ccc;
    margin: 20px 10px;
}

table.type08 thead th {
    padding: 10px;
    font-weight: bold;
    border-top: 1px solid #ccc;
    border-right: 1px solid #ccc;
    border-bottom: 2px solid #c00;
    background: #dcdcd1;
}
table.type08 tbody th {
 
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
    background: #ececec;
}
table.type08 td {
   
    padding: 10px;
    vertical-align: center;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>
<h1>장바구니 페이지</h1>

<table class="type08">
	<tr>
		<th scope="cols">전체선택 : <input type="checkbox" id="allCheck"/></th>
            <th scope="cols">이미지</th><th scope="cols">상품명</th><th scope="cols">가격</th><th scope="cols">수량</th><th scope="cols">합계</th>
	</tr>
	<c:forEach items="${shoppingcart}" var="shoppingcart">
	<tr>
		<td scope="row"><input type="checkbox" name="checkBox" ></td>
		<td scope="row"><img src="<spring:url value='/imgUpload/'/>${shoppingcart.product_name_image }"/></td>
		<td scope="row">${shoppingcart.product_name_title}</td>
		<td scope="row"><fmt:formatNumber value="${shoppingcart.product_name_price}" pattern="###,###,###"  />원</td>
		<td scope="row">${shoppingcart.product_count}</td>
		<td scope="row"><fmt:formatNumber value="${shoppingcart.product_name_price * shoppingcart.product_count}" pattern="###,###,###"  />원</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" style="text-align: right;"><input type="submit" value="선택구매"><input type="submit" value="전체구매"></td>		
	</tr>
	<tr>
		<td colspan="6" style="text-align: right;"><input type="button" value="선택삭제"><input type="submit" value="전체삭제"></td>		
	</tr>
</table> 
 
</body>
</html>