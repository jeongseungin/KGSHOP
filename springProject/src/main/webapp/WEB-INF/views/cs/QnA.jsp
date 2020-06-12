<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js">
	
</script>

		<style type="text/css">
			li {list-style: none; float: left; padding: 6px;}
		</style>
		
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Q&A 게시판</h1>
		
		<section class="container">
		<form role="form" method="get">
			<table class="table table-hover">
				<tr><th>카테고리</th><th>번호</th><th>제목</th><th>작성자</th><th>등록일</th></tr>
				<c:forEach items="${list}" var = "list">
					<tr>
						<td><c:out value="${list.qa_category}" /></td>
						<td><c:out value="${list.qa_seq}" /></td>
						<td>
							<a href="QnAreadView?qa_seq=${list.qa_seq}
							&page=${scri.page}
							&perPageNum=${scri.perPageNum}
							&searchType=${scri.searchType}
							&keyword=${scri.keyword}">
							<c:out value="${list.qa_subject}" /></a>
						</td>
						<td><c:out value="${list.user_id}" /></td>
						<td><fmt:formatDate value="${list.qa_logtime}" pattern="yyyy-MM-dd"/></td>
					</tr>
				</c:forEach>
			</table>
			<div class="search row">
				<div class="col-xs-2 col-sm-2">
				    <select name="searchType" class="form-control">
				      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>-----</option>
				      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
				      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
				      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
				      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
				    </select>
				</div>
				<div class="col-xs-3 col-sm-3">
					<div class="input-group">
				    	<input class="form-control" type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
				    	<span class="input-group-btn">
				    		<button class="btn btn-default" id="searchBtn" type="button">검색</button>
				    	</span>
					</div>
				</div>
				    	
			    <script>
			      $(function(){
			        $('#searchBtn').click(function() {
			          self.location = "QnA" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
			        });
			      });   
			    </script>
			 </div>
		
		<div class="col-md-offset-3"></div>
		  <ul class="pagination">
		    <c:if test="${pageMaker.prev}">
		    	<li><a href="QnA${pageMaker.makeSearch(pageMaker.startPage - 1)}">이전</a></li>
		    </c:if> 
			
		    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
		    	<li <c:out value="${pageMaker.cri.page == idx ? 'class=info' : ''}"/>>
		    	<a href="QnA${pageMaker.makeSearch(idx)}">${idx}</a></li>
		    </c:forEach>
		
		    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		    	<li><a href="QnA${pageMaker.makeSearch(pageMaker.endPage + 1)}">다음</a></li>
		    </c:if> 
		  </ul>
		</form>
		<br>
		<input type="button" value="글쓰기" onclick="location.href='QnAwrite'" >
 </section>
</div>

</body>
</html>