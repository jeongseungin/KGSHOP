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
		location.href = "QnA?page=${scri.page}"
		+"&perPageNum=${scri.perPageNum}"
		+"&searchType=${scri.searchType}&keyword=${scri.keyword}";
		})
	})
</script>
<body>
<h1>게시글 조회</h1>
	
	<form name="readForm" role="form" method="post">
		<input type="hidden" id="qa_seq" name="qa_seq" value="${read.qa_seq}" />
		<input type="hidden" id="page" name="page" value="${scri.page}"> 
		<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
		<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
		<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
	</form>

	<table border="1">
			<tr>
				<td>
					<label for="qa_seq">글 번호</label>
				</td>
				<td>
					<input type="text" id="qa_seq" name="qa_seq" value="${read.qa_seq}" readonly="readonly"/>
				</td>
			</tr>	
			<tr>
				<td>
					<label for="qa_category">카테고리</label>
				</td>
				<td>
					<input type="text" id="qa_category" name="qa_category" value="${read.qa_category}" readonly="readonly"/>
				</td>
			</tr>	
			<tr>
				<td>
					<label for="qa_subject">제목</label>
				</td>
				<td>
					<input type="text" id="qa_subject" name="qa_subject" value="${read.qa_subject}" readonly="readonly"/>
				</td>
			</tr>	
			<tr>
				<td>
					<label for="qa_content">내용</label>
				</td>
				<td>
					<textarea id="qa_content" name="qa_content" readonly="readonly" 
					rows="10" cols="100" style="resize: none">
					<c:out value="${read.qa_content}" /></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<label for="user_id">작성자</label>
				</td>
				<td>
					<input type="text" id="user_id" name="user_id" value="${read.user_id}" readonly="readonly"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="qa_logtime">작성날짜</label>
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
	<!-- 댓글 -->
	    <c:forEach items="${replyList}" var="a" >
		    ${a.userid}
		    <fmt:formatDate value="${a.logtime}" pattern="yyyy-MM-dd" />
		    ${a.content}
	    </c:forEach>
 	-->
</body>
</html>