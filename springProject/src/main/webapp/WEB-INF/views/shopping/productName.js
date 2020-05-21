function product_write() {
	product_name_title =  document.getElementById("product_name_title").value;
	product_stock =  document.getElementById("product_stock").value;
	product_name_price =  document.getElementById("product_name_price").value;
	product_name_price =  document.getElementById("product_name_price").value;
	product_name_detail =  document.getElementById("product_name_detail").value;
	product_images =  document.getElementById("product_images").value;
    	
		if(product_name_title == "") {
			alert("상품명을 입력하세요")
			product_name_title.focus();
		}else if (product_stock == ""){
			alert("재고량 을 입력하세요")
			product_stock.focus();
		}else if (product_name_price == ""){
			alert("상품 가격을 입력하세요")
			product_name_price.focus();
		}else if (product_name_detail == ""){
			alert("상품 설명을 입력하세요")
			product_name_detail.focus();
		}else if (product_images == ""){
			alert("상품 이미지을 입력하세요")
			product_images.focus();
		}else{document.productName.submit();}
    }