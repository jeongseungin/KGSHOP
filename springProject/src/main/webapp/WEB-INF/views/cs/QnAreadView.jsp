<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
<meta charset="UTF-8">
<title>게시판</title>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		var formObj = $("form[name='readForm']");
		
		// 수정 
		$(".update_btn").on("click", function(){
			formObj.attr("action", "updateView");
			formObj.attr("method", "get");
			formObj.submit();				
		})
		
		// 삭제
		$(".delete_btn").on("click", function(){
			formObj.attr("action", "delete");
			formObj.attr("method", "post");
			formObj.submit();
		})
		
		// 취소
		$(".list_btn").on("click", function(){
			
			location.href = "QnA";
		})
	})
</script>
<body>
<h1>게시글 조회</h1>
	
	<form name="readForm" role="form" method="post">
		<input type="hidden" id="qa_seq" name="qa_seq" value="${read.qa_seq}" />
	</form>

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
	<div>
		<button type="submit" class="update_btn">수정</button>
		<button type="submit" class="delete_btn">삭제</button>
		<button type="submit" class="list_btn">목록</button>	
	</div>
	
	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm:ss" var="today" />
	오늘 날짜 : <c:out value="${today}"/>


</body>
</html>