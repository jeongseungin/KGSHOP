<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
		function check(){ // 비밀번호 중복체크기능
			pw=document.getElementById("pw").value;
			pw1=document.getElementById("pw1").value;
			if(pw==pw1){
				document.getElementById("pw1_conform").innerHTML="확인!!";
				
			}
			else{
				document.getElementById("pw1_conform").innerHTML="불일치!!";
				document.getElementById("pw").value="";
				document.getElementById("pw1").value="";
				document.getElementById("pw").focus;
			}
		}
		function mouseCursor(textbox) { //마우스 커서 자동으로 옮기는 기능
			if(textbox.value.length==4){
				document.getElementById("code").focus();
			}
		}
		function popup() {
			window.open("popup","","width=400,height=400,top=500,left=500")
		}
</script>
</head>
<body>
<h1>회원가입 페이지</h1>

<form action="chkRegister" method="post" name="form">
   <table>
      <tr>
         <td>아이디 입력</td><td><input type="text" name="id" id="id"><input type="button" value="아이디중복확인" style="margin-left: 10px;"></td>
      </tr>
      <tr>
         <td>비밀번호 입력</td><td><input type="text" name="pw" id="pw"></td>
      </tr>
      <tr>
         <td>비밀번호 확인</td><td><input type="text" name="pw1" id="pw1" onchange="check()"><font style="margin-left: 10px;" id="pw1_conform" color="red">(*필수항목)</font></td>
      </tr>
      <tr>
      	<td>비밀번호 확인 질문</td>
      	<td>
      	<select size="1" name="conform" style="height: 23px;">
      		<option value="con1">기억에남는 추억의 장소는?
      		<option value="con2">자신의 인생 좌우명은?
      		<option value="con3">자신의 보물 제1호는?
      		<option value="con4">추억하고 싶은 날짜가 있다면?
      		<option value="con5">자신이 가장 존경하는 인물은?
      	</select></td>
      </tr>
      <tr>
      	<td>비밀번호 확인 답변</td><td><input type="text" style="width: 400px;" name="pw_answer"></td>
      </tr>
      <tr>
      	<td>이름</td><td><input type="text" name="name"></td>
      </tr>
      <tr>
      	<td rowspan="3" style="padding-bottom: 50px;">주소</td><td><input type="text" name="addr" style="width: 50px;"> - 
      	<input type="button" value="우편번호" onclick="popup()"><br>
      </tr>
      <tr>
      	<td><input type="text" style="width: 300px;" name="addr">기본주소<td>
      </tr>
      <tr>	
      	<td><input type="text" style="width: 300px;" name="addr">나머지주소</td>
	  </tr>
      <tr>
      	<td>휴대전화</td>
      	<td>
      	<select size="1" name="tel" style="height: 23px;">
      		<option value="tel1" name="tel">010
      		<option value="tel2" name="tel">011
      		<option value="tel3" name="tel">016
      		<option value="tel4" name="tel">018
      		<option value="tel5" name="tel">019
      	</select> - 
      	<input type="text" style="width: 70px;" id="birth" onkeyup="mouseCursor(this)" name="tel"> - 
      	<input type="text" style="width: 70px;" maxlength="4" id="code" name="tel">
      	</td>
      </tr>
      <tr>
      	<td>이메일</td><td><input type="text" style="width: 200px;" name="email">
      </tr>
   
   </table>
   <input type="submit" value="회원가입" style="margin-left: 150px;">
   <input type="button" value="취소" style="margin-left: 10px;" onclick="location.href='login'">
</form>
</body>
</html>