<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script >
function product_write() {
	var product_name_no = document.getElementById("product_name_no");
	var	product_name_title =  document.getElementById("product_name_title");
	var	product_stock =  document.getElementById("product_stock");
	var	product_name_price =  document.getElementById("product_name_price");
	var product_name_detail =  document.getElementById("product_name_detail");
	var product_images =  document.getElementById("product_images");
    	
		if(product_name_title.value == "") {
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

<form name="productName" id="productName" action="ModifySaveProduct" method="post" enctype="multipart/form-data" onsubmit="return product_write()" > 
			<table >
			<tr>
				<th colspan="2">상품 등록 </th>
			</tr>
			  <tr>
				<td>상품 고유번호</td>
				<td><input type="text" name="product_name_no" id="product_name_no" value="${modifylist.product_name_no}" readonly></td>
			 </tr>
			<tr>
				<td>상품 카테고리</td>
				<td>
				<select name="product_category_no" id="product_category_no">
    			<option value="notebook">노트북</option>
    			<option value="computer">컴퓨터</option>
   				<option value="moniter">모니터</option>
   				<option value="mouse">마우스</option>
   				<option value="speaker">스피커</option>
   				<option value="graphiccard">그래픽카드</option>
   				<option value="cpu">CPU</option>
   				<option value="mainboard">메인보드</option>
   				<option value="hdd">하드디스크</option>
   				<option value="sdd">SDD</option>
   				<option value="ram">RAM</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>상품 명</td>
				<td><input type="text" name="product_name_title" id="product_name_title"></td>
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
			<td>이미지 미리보기</td>
			<td><div class="select_img"><img src="" /></div></td>
			 </tr>
			<script>
			  $("#product_name_image").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
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