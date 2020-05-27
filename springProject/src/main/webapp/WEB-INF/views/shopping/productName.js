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
