<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<jsp:useBean id="dao" class="com.care.DAO.MemberDAO"/>
	<%
 	int result ;
 	String id = (String)request.getParameter("id");
	 result = dao.idcheck(id);
	%>
	<%
		if (result == 1) {
	%>
	<!--  <img src="image/idno.png" width="290" height="166">-->
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;중복된 아이디입니다<p>
	&nbsp;<input type="button" onclick="window.close()" value="확인" style="margin-left: 75px;">
	<!-- 아이디가 이미 존재할때 이미지 -->
	<%
		} else if(result==0){
	%>
	&nbsp;&nbsp;사용가능한 아이디입니다<p>
	<input type="button" onclick="window.close()" value="확인" style="margin-left: 75px;">
	<!--  <img src="image/idok.png" width="290" height="166">-->
	<!-- 아이디가 존재하지 않을 때 이미지 -->
	<%} %>
</body>
</html>