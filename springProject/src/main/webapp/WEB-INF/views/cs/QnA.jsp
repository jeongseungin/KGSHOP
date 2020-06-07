<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
		<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Q&A 게시판</h1>

<form role="form" method="get">
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
<div class="search">
    <select name="searchType">
      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>

    <button id="searchBtn" type="button">검색</button>
    <script>
      $(function(){
        $('#searchBtn').click(function() {
          self.location = "QnA" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
  </div>


  <ul>
    <c:if test="${pageMaker.prev}">
    	<li><a href="QnA${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
    	
    </c:if> 

    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
    	<li><a href="QnA${pageMaker.makeSearch(idx)}">${idx}</a></li>
    </c:forEach>

    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
    	<li><a href="QnA${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
    </c:if> 
  </ul>
</form>
<br>
<input type="button" value="글쓰기" onclick="location.href='QnAwrite'" >

</body>
</html>