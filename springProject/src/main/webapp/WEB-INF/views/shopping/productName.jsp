<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
h1>상품 등록</h1>

<form name="inputproduct" action="inputproductsave" enctype="multipart/form-data" method="post">
			<table border="1">
			<tr>
				<th colspan="2">상품 등록 </th>
			</tr>
			<tr>
				<td>등록 상품번호</td>
				<td><input type="text" name="product_name_no" value=product_name_title+색상+사이즈></td>
			</tr>
			<tr>
				<td>상품 분류번호</td>
				<td><input type="text" name="product_category_no"></td>
			</tr>
			<tr>
				<td>상품 명</td>
				<td><input type="text" name="product_name_title"></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" name="product_name_price"></td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td><textarea name="product_name_detail rows="3" cols="30"></textarea></td>
			</tr>
			<tr>
				<td>상품 이미지</td>
				<td>
					<img name="preview" src="../images/product/noimage.jpg" style="width:100%"><br/>
					<input type="file" name="image" size="30" onchange="filePreview()">
				</td>
			</tr>
			<tr>
				<td>상품 재고</td>
				<td><input type="text" name="stock"></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<br/>
					<input type="submit" value="상품 등록">
					<input type="reset" value="새로 입력" onclick="resetInsertData()">
				</td>
			</tr>
	</table>
	</form>
</body>
</html>