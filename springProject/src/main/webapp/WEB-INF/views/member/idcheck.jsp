<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>중복확인 페이지
	<jsp:useBean id="check" class="com.care.DAO.MemberDAO"/>
	<jsp:useBean id="dto" class="com.care.DTO.MemberDTO"/>
	<jsp:setProperty property="*" name="dto"/>
	<table>
		<tr>
			<td >
				<c:if test="${dto.getId eq param.id}">
					
				</c:if>
			</td>
		</tr>
	</table>
</body>
</html>