<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function close() {
		self.close();
	}
</script>
</head>
<body>중복확인 페이지
	<jsp:useBean id="dao" class="com.care.DAO.MemberDAO"/>
	<%
 	int result = 0;
 	String id = (String)request.getParameter("id");
	 result = dao.idcheck(id);
	%>
	<%
		if (result == 1) {
	%>
	<!--  <img src="image/idno.png" width="290" height="166">-->
	중복된 아이디<br>
	<input type="button" onclick="close()">
	<!-- 아이디가 이미 존재할때 이미지 -->
	<%
		} else {
	%>
	사용가능한 아이디
	<!--  <img src="image/idok.png" width="290" height="166">-->
	<!-- 아이디가 존재하지 않을 때 이미지 -->
	<%} %>
</body>
</html>