<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>마이 페이지</h1>
	로그인 성공<br>
	${id }

	<form action="bootMemberModify" method="post">
	<input type="submit" value="회원정보 수정"><hr>
	</form>
	<input type="button" value="장바구니"><hr>
	<input type="button" value="내가 쓴글 보기"><hr>
	<input type="button" value="주문내역 조회"><hr>
	<input type="button" value="배송주소록 관리"><hr>
	
</body>
</html>