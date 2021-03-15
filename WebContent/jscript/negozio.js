function addToCart(name, quantity, price){
	
	let product = document.querySelectorAll(".name_product");
	
	
	if(quantity>0 && controlDuplicates(name, product)){
		
		let notify = document.querySelector('.badge.bg-secondary');
		let cont  = parseInt(notify.textContent) + 1;
	
		notify.textContent = cont.toString();
		
		document.querySelector('#carts').innerHTML += 
		"<div class='d-flex justify-content-between'><p>Name: <span class='name_product'><strong>"+name+"</strong></span></p><p>Quantity: <span> <input class='quantity_product' type='number' min='1' max="+quantity+" value='1' onKeyDown='return false'> <span onclick='removeProduct(event, "+price+")' style='color:red; font-weight: bold; cursor: pointer; margin-left: 10px;'>X</span> </span></p></div>";
		
		let prices = document.getElementById('price_tot');
		cont = parseFloat(prices.textContent) + parseFloat(price);
		
		prices.textContent = cont.toFixed(2);
	}
}

function controlDuplicates(name, product){
	
	var check = true;
	let alert = document.getElementById('alert');
		product.forEach( o => {
			if(o.textContent == name){
				alert.innerHTML += '<div class="alert alert-warning alert-dismissible fade show" role="alert"><strong>Error!</strong> the product is already in the cart. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
				check = false;
			} 
		})
		
		return check;
}

function removeProduct(event, price){
	let remove = event.target.parentNode.parentNode.parentNode;
	remove.remove();
	let notify = document.querySelector('.badge.bg-secondary');
	let cont  = parseInt(notify.textContent) - 1;
	notify.textContent = cont.toString();
	let prices = document.getElementById('price_tot');
	cont = parseFloat(prices.textContent) - parseFloat(price);
		
	prices.textContent = cont.toFixed(2);
}


function buy(){
	let product = document.querySelectorAll(".name_product");
	let quantity = document.querySelectorAll(".quantity_product");
	let name = document.getElementById('name');
	
	if(product.length > 0){
		
		var request=new XMLHttpRequest();
		
		for (i = 0; i<product.length; i++){
			request.open("POST", "order?prodotto="+product[i].textContent+"&quantita="+quantity[i].value+"&utente="+name.textContent+"&max="+quantity[i].getAttribute("max"), true);
			request.send();
		}
		
		location.href = "page2.jsp";
		
	}else{
		let alert = document.getElementById('alert');
		alert.innerHTML += '<div class="alert alert-warning alert-dismissible fade show" role="alert"><strong>Error!</strong> there are no products in the car. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
	}
}
