<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
 카카오톡 로그인 <br>
 
  <a href = "https://kauth.kakao.com/oauth/authorize?client_id=c2205973abf3d4bbd2283090a123e0db&redirect_uri=http://localhost:9090/controller/oauth&response_type=code">
        로그인
    </a>
  <br>  
<a href = "https://kauth.kakao.com/oauth/authorize?client_id=c2205973abf3d4bbd2283090a123e0db&redirect_uri=http://localhost:9090/controller/oauth&response_type=code">
<img src="resource/img/kakao.png">
  </a>

</body>
</html>