<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script >
function product_write() {
	var product_name_no = document.getElementById("product_name_no");
	var	product_name_title =  document.getElementById("product_name_title");
	var	product_stock =  document.getElementById("product_stock");
	var	product_name_price =  document.getElementById("product_name_price");
	var product_name_price =  document.getElementById("product_name_price");
	var product_name_detail =  document.getElementById("product_name_detail");
	var product_images =  document.getElementById("product_images");
    	
		if(product_name_no.value == ""){
			alert("상품고유번호 을 입력하세요")
			productName.product_name_no.focus();
			return false;
		}
		else if(product_name_title.value == "") {
			alert("상품명을 입력하세요")
			productName.product_name_title.focus();
			return false;
		}else if (product_stock.value == ""){
			alert("재고량 을 입력하세요")
			productName.product_stock.focus();
			return false;
		}else if (product_name_price.value == ""){
			alert("상품 가격을 입력하세요")
			productName.product_name_price.focus();
			return false;
		}else if (product_name_detail.value == ""){
			alert("상품 설명을 입력하세요")
			productName.product_name_detail.focus();
			return false;
		}else if (product_images.value == ""){
			alert("상품 이미지을 입력하세요")
			productName.product_images.focus();
			return false;
		}else{
			return true;
		}
    }
</script>

</head>
<body>
<h1>상품 등록</h1>

<form name="productName" id="productName" action="SaveProduct" method="post" enctype="multipart/form-data" onsubmit="return product_write()" > 
			<table >
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
				<td><label for="product_name_image">상품 이미지</label></td>
				<td><input type="file" name="file" id="product_name_image"></td>
			</tr>
			<tr>
				<td>파일 저장 주소</td>
				<td><%=request.getRealPath("/") %></td>
			</tr>
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