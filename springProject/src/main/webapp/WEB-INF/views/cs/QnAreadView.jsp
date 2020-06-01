<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 조회</h1>
					<table border="1">
							<tr>
								<td>
									<label for="bno">글 번호</label>
								</td>
								<td>
									<input type="text" id="qa_seq" name="qa_seq" value="${read.qa_seq}" readonly="readonly"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="title">제목</label>
								</td>
								<td>
									<input type="text" id="qa_subject" name="qa_subject" value="${read.qa_subject}" readonly="readonly"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="content">내용</label>
								</td>
								<td>
									<textarea id="qa_content" name="qa_content" readonly="readonly" 
									rows="10" cols="100" style="resize: none">
									<c:out value="${read.qa_content}" /></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="writer">작성자</label>
								</td>
								<td>
									<input type="text" id="user_id" name="user_id" value="${read.user_id}" readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성날짜</label>
								</td>
								<td>
									<fmt:formatDate value="${read.qa_logtime}" pattern="yyyy-MM-dd" />					
								</td>
							</tr>		
					</table>
					<jsp:useBean id="now" class="java.util.Date" />
					<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today" />
					오늘 날짜 : <c:out value="${today}"/>


</body>
</html>