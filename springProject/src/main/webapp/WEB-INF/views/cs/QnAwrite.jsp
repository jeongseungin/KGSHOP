<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		
		function publicRadioChk(){
			var password = document.getElementById("qa_pwd");
			password.value='';
			var x = document.getElementsByName("qa_state");
			console.log(x[0].value);		
		}
		nction writeChk(){
			var subject = document.getElementById("qa_subject");
			var password = document.getElementById("qa_pwd");
			
			if(!subject.value){
				alert('제목은 필수사항입니다.');
				subject.focus();
				
			}
			else if(!password.value){
				alert('비밀번호는 필수사항입니다.');
				password.focus();
			}
			else{
				document.getElementById("savedata").submit();
			}
		}
		
		
	</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기</h1>

<div>
	<form action="savedata" method="get" id="savedata">
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
				<td><input type="text" name="qa_subject" id="qa_subject"></td>
			</tr>		
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="100" style="resize: none" name="qa_content">
					☆ 문의내용
					</textarea>
				</td>
			</tr>
			<tr>
				<td>비공개 여부 </td>
				<td> 
					공개<input type="radio" name="qa_state" id="public" value="0" 
						onClick="this.form.qa_pwd.disabled=true; publicRadioChk();">
					비공개<input type="radio" name="qa_state" id="private" checked="checked" value="1"
					    onClick="this.form.qa_pwd.disabled=false">
				</td>
			</tr>		
			<tr>
				<td>비밀번호</td>
				<td> <input type="password" name="qa_pwd" id="qa_pwd"> </td>
			</tr>
			<tr>
				<td><input type="button" value="확인" onclick="writeChk()"></td>
				<td><input type="button" value="취소" onclick="location.href='QnA'"></td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>