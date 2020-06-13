<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
유저 아이디 : ${orders.id}
상품 명 : ${orders.product_title}
가 격 : ${orders.product_price}
수 량 :${orders.product_count}
총 가격 : (${orders.product_price} * ${orders.product_count})
</body>
</html>