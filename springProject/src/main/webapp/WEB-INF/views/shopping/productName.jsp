<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
<h1>상품 등록</h1>

<form name="productName" id="productName" action="SaveProduct" method="post" enctype="multipart/form-data" > 
			<table border="1">
			<tr>
				<th colspan="2">상품 등록 </th>
			</tr>
			  <tr>
				<td>상품 고유번호</td>
				<td><input type="text" name="product_name_no" id="product_name_no" ></td>
			 </tr>
			<tr>
				<td>상품 카테고리</td>
				<td>
				<select name="product_category_no" id="product_category_no">
    			<option value="outer">아우터</option>
    			<option value="top">상의</option>
   				<option value="bottom">하의</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>상품 명</td>
				<td><input type="text" name="product_name_title" id="product_name_title"></td>
			</tr>
			<tr>
				<td>상품 색상</td>
				<td>
				<select name="product_name_color" id="product_name_color">
    			<option value="white">화이트</option>
    			<option value="block">블랙</option>
   				<option value="ivoyy">아이보리</option>
    			<option value="navy">네이비</option>
    			<option value="beige">베이지</option>
    			<option value="brown">브라운</option>
    			<option value="khaki">카키</option>
    			<option value="skyblue">스카이블루</option>
    			<option value="pink">핑크</option>
    			<option value="mustard">머스타드</option>
				</select>
				</td>
				
			</tr>
			<tr>
				<td>상품 사이즈</td>
				<td>
				<select name="product_name_size" id="product_name_size">
    			<option value="S">S[90]</option>
    			<option value="M">M[95]</option>
   				<option value="L">L[100]</option>
    			<option value="XL">XL[105]</option>
    			<option value="XXL">XXL[110]</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>상품 재고</td>
				<td><input type="text" name="product_stock" id="product_stock"></td>
			</tr>
			<tr>
				<td>상품 가격</td>
				<td><input type="text" name="product_name_price" id="product_name_price"></td>
			</tr>
			<tr>
				<td>상품 설명</td>
				<td><textarea rows="5" cols="50" style="resize: none;" name="product_name_detail" id="product_name_detail">
				</textarea></td>
			</tr>
			<tr>
				<td>상품 해쉬태그</td>
				<td><textarea rows="5" cols="50" style="resize: none;" name="product_hashtag" id="product_hashtag">
				</textarea></td>
			</tr>
			 <tr>
				<td>상품 이미지</td>
				<td><input type="file" name="product_name_image" id="product_name_image"></td>
			</tr>
			<script>
			$("#product_name_image").change(function){
				if(this.files && this.files[0]){
					var reader = new FileReader;
					reader.onload = function(data) {
						${".select_img img"}.attr("src", data.target.result).width(500);
					}
					reader.readAsDataURL(this.files[0]);
				}
			});
			</script>
			
			
			<tr>
				<td colspan="2">
					<input type="submit" value="상품 등록" >
 					<input type="button" value="취소" onclick="location.href='mypage'">				
 				</td>
			</tr>
	</table>
	</form>
</body>
</html>