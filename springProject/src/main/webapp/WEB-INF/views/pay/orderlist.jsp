<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${orderlist}" var="orderlist">
아이디 : ${orderlist.id }
이메일 : ${orderlist.email }
주소 : ${orderlist.addr }
번 호 : ${orderlist.tel }
상품명 : ${orderlist.product_name_title }
가 격 : ${orderlist.product_name_price }
수 량 : ${orderlist.product_count }
총 가 격 :${orderlist.product_sumprice }
</c:forEach>
</body>
</html>