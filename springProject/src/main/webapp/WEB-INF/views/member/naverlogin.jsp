<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="https://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>네이버 아이디로 로그인</title>
<style>
  pre{
    overflow: scroll;
  }
</style>
</head>
<body>
  <div th:if="${session.currentUser eq null}">
    <h3>네이버 로그인</h3>
    <a th:href="${apiURL}"><img height="50" src="http://static.nid.naver.com/oauth/small_g_in.PNG"/></a>
  </div>
  
  <div th:if="${session.currentUser ne null}">
    <h3>이 부분은 로그인한 사용자한테만 보임</h3>
    <pre th:text="${session.currentUser}"></pre>
    <a th:href="${'/naver/getProfile?accessToken=' + session.currentAT}">Get User's Profile</a>
    <a th:href="${'/naver/refreshToken?refreshToken=' + session.currentRT}">Refresh Token</a>
    <a th:href="${'/naver/deleteToken?accessToken=' + session.currentAT}">Delete Token</a>
    <a href="/naver/invalidate">로그아웃 (Invalidate Session)</a>
  </div>
  
</body>
</html>