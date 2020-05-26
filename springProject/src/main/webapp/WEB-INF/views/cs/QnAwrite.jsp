<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		
	</script>
	
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기</h1>

<div>
	<form action="#" method="get">
		<table border="1">
			<tr>
				<td>
					<input type="hidden" name="user_id" value="${sessionScope.id}">
					카테고리 분류
				</td>
				<td> 
					<select name="qa_category">
						<option value="상품문의">상품문의
						<option value="배송문의">배송문의
						<option value="교환/환불문의">교환/환불문의
						<option value="취소문의">취소문의
					</select> 
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="qa_subject"></td>
			</tr>		
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="100" 
					style="resize: none" name="qa_content"></textarea>
				</td>
			</tr>
			<tr>
				<td>비공개 여부 </td>
				<td> 
					공개<input type="radio" name="qa_state" id="public" value="0" 
						onClick="this.form.qapw.disabled=true">
					비공개<input type="radio" name="qa_state" id="private" checked="checked" value="1"
					    onClick="this.form.qapw.disabled=false">
				</td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td> <input type="password" name="qa_pwd"> </td>
			</tr>
			<tr>
				<td><input type="submit" value="확인"></td>
				<td><input type="button" value="취소" onclick="location.href='QnA'"></td>
				
			</tr>
		</table>
	</form>
</div>
</body>
</html>