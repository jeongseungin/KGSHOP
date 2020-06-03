<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function pwdchk(){
		var qa_pwd = document.getElementById('qa_pwd').value;
		var form = document.form;
		console.log(${read.qa_pwd})
		if(qa_pwd==${read.qa_pwd}){
			form.submit();
		}else{
			document.getElementById('qa_pwd').focus;
			document.getElementById('qa_pwd').value = '';
			alert('비밀번호가 일치하지 않습니다.');
		}
	}
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>패스워드 입력칸</h1>

<hr>

<div>
	<form action="QnApassWord" method="post" name="form">
		이 글은 비밀 글입니다.<br>
		비밀번호를 입력하여 주세요.<br>
		<input type="text" id="qa_pwd"><c:out value="비밀번호는${read.qa_pwd }" /><br>
		<input type="button" value="목록" onclick="location.href='QnA'"> <input type="button" value="확인" onclick="pwdchk()">
		<input type="hidden" name="qa_seq" value="${read.qa_seq}">
	</form>
</div>


</body>
</html>