<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Callback</title>
<style>
  pre{
    overflow: scroll;
  }
</style>
</head>
<body>
  <h1>콜백 페이지</h1>
  <pre th:text="${res}"></pre>
  <a href="/naver">go to main page</a>
</body>
</html>