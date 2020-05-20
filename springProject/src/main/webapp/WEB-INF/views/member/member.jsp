<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원가입 페이지</h1>
<form action="chkRegister" method="post">
   <table>
      <tr>
         <td>아이디 입력</td><td><input type="text" name="id" id="id"></td><td><input type="button" value="아이디중복확인"></td>
      </tr>
      <tr>
         <td>비밀번호 입력</td><td><input type="text" name="pw" id="pw"></td>
      </tr>
      <tr>
         <td>비밀번호 확인</td><td><input type="text" name="pw1" id="pw1"></td><td><font>*필수항목</font></td>
      </tr>
   </table>
</form>
</body>
</html>