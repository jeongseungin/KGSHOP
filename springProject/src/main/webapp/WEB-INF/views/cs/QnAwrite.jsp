<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>글쓰기</h1>

<div>
	<form action="#" method="get">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title"></td>
			</tr>		
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" cols="100" 
					style="resize: none" name="content"></textarea>
				</td>
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