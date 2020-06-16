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

<form action="Savebanner?banner_no=${banner_no}" enctype="multipart/form-data" method="post">
   카테고리 : 
      <select name="banner_category" id="banner_category" >
             <option value="notebook">노트북</option>
             <option value="computer">컴퓨터</option>
               <option value="moniter">모니터</option>
               <option value="mouse">마우스</option>
               <option value="speaker">스피커</option>
               <option value="graphiccard">그래픽카드</option>
               <option value="cpu">CPU</option>
               <option value="mainboard">메인보드</option>
               <option value="hdd">하드디스크</option>
               <option value="ram">램</option>
               <option value="sdd">SDD</option>
               <option value="ram">RAM</option>
      </select><br>
			상품 이미지 등록
				<input type="file" name="file" id="banner_image"> <br>
			이미지 미리보기
			<div class="select_img"><img src="" /></div>
			<script>
			  $("#banner_image").change(function(){
			   if(this.files && this.files[0]) {
			    var reader = new FileReader;
			    reader.onload = function(data) {
			     $(".select_img img").attr("src", data.target.result).width(500);        
			    }
			    reader.readAsDataURL(this.files[0]);
			   }
			  });
 				</script>  
   <input type="submit" value="수 정">
   
</form> 


</body>
</html>