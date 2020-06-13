<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>

<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

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
		
		$(".replyWriteBtn").on("click", function(){
		   var formObj = $("form[name='replyForm']");
		   formObj.attr("action", "replyWrite");
		   formObj.submit();
		});
		
		//수정 버튼을 클릭했을 때 url주소가 게시판
		//qa_seq, page, perPageNum, searchType, keyword 그리고 댓글번호인 rno가 들어가 있는것이 보입니다. 
		//여기서 $(this).attr("data-qa_reply_seq")는 클릭 이벤트가 발생한 수정 버튼의 data-qa_reply_seq값을 가져오겠다는 말이에요.
		
		//댓글 수정 View
		$(".replyUpdateBtn").on("click", function(){
			location.href = "replyUpdateView?qa_seq=${read.qa_seq}"
							+ "&page=${scri.page}"
							+ "&perPageNum=${scri.perPageNum}"
							+ "&searchType=${scri.searchType}"
							+ "&keyword=${scri.keyword}"
							+ "&qa_reply_seq="+$(this).attr("data-qa_reply_seq");
		});
				
		//댓글 삭제 View
		$(".replyDeleteBtn").on("click", function(){
			location.href = "replyDeleteView?qa_seq=${read.qa_seq}"
				+ "&page=${scri.page}"
				+ "&perPageNum=${scri.perPageNum}"
				+ "&searchType=${scri.searchType}"
				+ "&keyword=${scri.keyword}"
				+ "&qa_reply_seq="+$(this).attr("data-qa_reply_seq");
		});
		
	})
</script>
<body>
		<div class="form-horizontal">
		
		<h1>게시글 조회</h1>
		<form name="readForm" role="form" method="post">
			<input type="hidden" id="qa_seq" name="qa_seq" value="${read.qa_seq}" />
			<input type="hidden" id="page" name="page" value="${scri.page}"> 
			<input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
			<input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
			<input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
		</form>
			
				<div class="form-group">
					<label for="qa_seq" class="col-sm-4 control-label">글 번호</label>
					<div class="col-sm-8">
						<input type="text" id="qa_seq" name="qa_seq" value="${read.qa_seq}" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="qa_category" class="col-sm-4 control-label">카테고리</label>
					<div class="col-sm-8">
						<input type="text" id="qa_category" name="qa_category" value="${read.qa_category}" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="qa_subject" class="col-sm-4 control-label">제목</label>
					<div class="col-sm-8">
						<input type="text" id="qa_subject" name="qa_subject" value="${read.qa_subject}" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="qa_content" class="col-sm-4 control-label">내용</label>
					<div class="col-sm-8">
						<textarea id="qa_content" name="qa_content" readonly="readonly" 
						rows="10" cols="100" style="resize: none">
						<c:out value="${read.qa_content}" /></textarea>
					</div>
				</div>
				
				
				<div class="form-group">
					<label for="user_id" class="col-sm-4 control-label">작성자</label>
					<div class="col-sm-8">
						<input type="text" id="user_id" name="user_id" value="${read.user_id}" readonly="readonly"/>
					</div>
				</div>
				
				<div class="form-group">
					<label for="qa_logtime" class="col-sm-4 control-label">작성날짜</label>
					<div class="col-sm-8">
						<fmt:formatDate value="${read.qa_logtime}" pattern="yyyy-MM-dd" />
					</div>
				</div>
				
				
				<div class="form-group">
					<div class="col-sm-offset-4 col-sm-8">
						<button type="submit" class="update_btn btn btn-default">수정</button>
						<button type="submit" class="list_btn btn btn-default">목록</button>	
						<button type="submit" class="delete_btn btn btn-warning">삭제</button>
					</div>
				</div>
			</div>
				
				
				<!-- 댓글 -->
				<div class="form-horizontal">
				    <c:forEach items="${replyList}" var="replyList">
				    	<div id="reply" class="form-group">
					    	<h4 class="col-sm-offset-4 col-sm-8">댓글</h4>
					    </div>
					    
					    <div id="reply" class="form-group">
				    		<label class="col-sm-4 control-label">작성자</label>
				    		<div class="col-sm-8">
				    		<input type="text" value="${replyList.qa_reply_user_id}" readonly="readonly">
						        작성 날짜 :  <fmt:formatDate value="${replyList.qa_reply_logtime}" pattern="yyyy-MM-dd" />
						   	</div>
					   	</div>
					   	<div id="reply" class="form-group">
					        <label class="col-sm-4 control-label">내용</label>
					        <div class="col-sm-8">
						        <textarea readonly="readonly" 
								rows="10" cols="100" style="resize: none">
								${replyList.qa_reply_content}
							</textarea>
							</div>
						</div>
					        
					         <div>
								<button type="button" class="replyUpdateBtn btn btn-default" data-qa_reply_seq="${replyList.qa_reply_seq}">수정</button>
							    <button type="button" class="replyDeleteBtn btn btn-warning" data-qa_reply_seq="${replyList.qa_reply_seq}">삭제</button>
					  	 	 </div>
				    </c:forEach>   
				</div>
				<!-- 댓글작성폼 -->
				<form name="replyForm" method="post">
				  <input type="hidden" id="qa_seq" name="qa_seq" value="${read.qa_seq}" />
				  <input type="hidden" id="page" name="page" value="${scri.page}"> 
				  <input type="hidden" id="perPageNum" name="perPageNum" value="${scri.perPageNum}"> 
				  <input type="hidden" id="searchType" name="searchType" value="${scri.searchType}"> 
				  <input type="hidden" id="keyword" name="keyword" value="${scri.keyword}"> 
				
				  <div>
				    <label for="qa_reply_user_id">댓글 작성자</label><input type="text" id="qa_reply_user_id" name="qa_reply_user_id" />
				    <br/>
				    <label for="qa_reply_content">댓글 내용</label><input type="text" id="qa_reply_content" name="qa_reply_content" />
				  </div>
				  <div>
				 	 <button type="button" class="replyWriteBtn">작성</button>
				  </div>
				</form>
			
</body>
</html>