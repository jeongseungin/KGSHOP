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
 table.type09 {
    border-collapse: collapse;
    text-align: center;
    line-height: 1.5;

}
table.type09 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #369;
    border-bottom: 3px solid #036;
}
table.type09 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: center;
    border-bottom: 1px solid #ccc;
    background: #f3f6f7;
}
table.type09 td {
    
    padding: 10px;
    vertical-align: center;
    border-bottom: 1px solid #ccc;
}
</style>
</head>
<body>
<h1>장바구니 페이지</h1>

<table border="1" class="type09">
	<tr>
		<th scope="cols">전체선택 : <input type="checkbox" id="allCheck"/></th>
            <th scope="cols">이미지</th><th scope="cols">상품명</th><th scope="cols">가격</th><th scope="cols">수량</th><th scope="cols">합계</th>
	</tr>
	<c:forEach items="${shoppingcart}" var="shoppingcart">
	<tr>
		<td><input type="checkbox" name="checkBox" scope="row"></td>
		<td><img src="<spring:url value='/imgUpload/'/>${shoppingcart.product_name_image }"/></td>
		<td>${shoppingcart.product_name_title}</td>
		<td><fmt:formatNumber value="${shoppingcart.product_name_price}" pattern="###,###,###"  />원</td>
		<td>${shoppingcart.product_count}</td>
		<td><fmt:formatNumber value="${shoppingcart.product_name_price * shoppingcart.product_count}" pattern="###,###,###"  />원</td>
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