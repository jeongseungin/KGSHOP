<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
		<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Q&A 게시판</h1>

<script type="text/javascript">
	
</script>

<div>
	<table border="1">
		<tr>
			<td>no</td><td>제목(답변완료여부)</td><td>제목</td><td>유저아이디</td><td>날짜</td>
		</tr>
		<tr>
		</tr>
	</table>
</div>
					<table>
						<tr><th>카테고리</th><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
						<c:forEach items="${list}" var = "list">
							<tr>
								<td><c:out value="${list.qa_category}" /></td>
								<td><c:out value="${list.qa_seq}" /></td>
								<td>
									<a href="QnAreadView?qa_seq=${list.qa_seq}"><c:out value="${list.qa_subject}" /></a>
								</td>
								<td><c:out value="${list.user_id}" /></td>
								<td><fmt:formatDate value="${list.qa_logtime}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</table>
<div>
  <ul>
    <c:if test="${pageMaker.prev}">
    	<li><a href="QnA${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
    	
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li><a href="QnA${pageMaker.makeQuery(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li><a href="QnA${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  </ul>
</div>
<br>
<input type="button" value="글쓰기" onclick="location.href='QnAwrite'" >

</body>
</html>