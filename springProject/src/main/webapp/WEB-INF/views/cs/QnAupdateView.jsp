<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
	<head>
		<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		
	 	<title>게시판</title>
	</head>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".cancel_btn").on("click", function(){
				event.preventDefault();
				location.href = "QnAreadView?qa_seq=${update.qa_seq}"
					   + "&page=${scri.page}"
					   + "&perPageNum=${scri.perPageNum}"
					   + "&searchType=${scri.searchType}"
					   + "&keyword=${scri.keyword}";
			})
		})
		
	</script>
	<body>
		<div id="root">
			<header>
				<h1> 게시판</h1>
			</header>
			<hr />
			 
			<nav>
			  홈 - 글 작성
			</nav>
			<hr />
			
			<section id="container">
				<form name="updateForm" role="form" method="post" action="update">
					<input type="hidden" name="qa_seq" value="${update.qa_seq}" readonly="readonly"/>
					<table>
						<tbody>
							<tr>
								<td>
									<label for="qa_category">카테고리</label><input type="text" id="qa_category" name="qa_category" value="${update.qa_category}"/>
								</td>
							</tr>	
							<tr>
								<td>
									<label for="qa_subject">제목</label><input type="text" id="qa_subject" name="qa_subject" value="${update.qa_subject}">
								</td>
							</tr>	
							<tr>
								<td>
									<label for="qa_content">내용</label><textarea id="qa_content" name=qa_content rows="10" cols="100" style="resize: none"><c:out value="${update.qa_content}"/></textarea>
								</td>
							</tr>
							<tr>
								<td>
									<label for="user_id">작성자</label><input type="text" id="user_id" name="user_id" value="${update.user_id}" readonly="readonly"/>
								</td>
							</tr>
							<tr>
								<td>
									<label for="qa_pwd">비밀번호</label><input type="text" id="qa_pwd" name="qa_pwd" value="${update.qa_pwd}" />
								</td>
							</tr>
							<tr>
								<td>
									<label for="regdate">작성날짜</label>
									<fmt:formatDate value="${update.qa_logtime}" pattern="yyyy-MM-dd"/>					
								</td>
							</tr>		
						</tbody>			
					</table>
					<div>
						<button type="submit" class="update_btn">저장</button>
						<button type="submit" class="cancel_btn">취소</button>
					</div>
				</form>
			</section>
			<hr />
		</div>
	</body>
</html>