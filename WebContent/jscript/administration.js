let names = document.getElementById('names_products');
let img = document.getElementById('img_update');
let quantity = document.getElementById('quantity_update');
let price = document.getElementById('price_update');


function changeProduct(){
	
	img.value = names.value;
	quantity.value = names.value;
	price.value = names.value;
	
	document.getElementById('img_choice').value = img.options[img.selectedIndex].textContent;
	document.getElementById('quantity_choice').value = quantity.options[quantity.selectedIndex].textContent; 
	document.getElementById('price_choice').value = price.options[price.selectedIndex].textContent;  
	
}

function updateProduct(){
	
	var img_choice = document.getElementById('img_choice').value;
	var quantity_choice = document.getElementById('quantity_choice').value;
	var price_choice = document.getElementById('price_choice').value;
	
	fetch("updateProduct?name_product="+names.value+"&img="+img_choice+
	"&quantita="+quantity_choice+"&price_product="+price_choice, 
	{
		method: "POST"
	}                         
	).then(resp =>{           
		document.querySelector('#alert').innerHTML = '<div class="alert alert-success alert-dismissible fade show" role="alert"><strong>Good!</strong> Updated product. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>'; 
	}).catch(err =>{
		document.querySelector('#alert').innerHTML = '<div class="alert alert-warning alert-dismissible fade show" role="alert"><strong>Warning!</strong> Something went wrong. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
	})
	
//	var request=new XMLHttpRequest();
//	request.open("POST", "updateProduct?name_product="+names.value+"&img="+img_choice+
//	"&quantita="+quantity_choice+"&price_product="+price_choice, true);
	
//	request.send();
}

function deleteProduct(){
	
	fetch("deleteProduct?name_product="+names.value, 
	{
		method: "POST"
	}                         
	).then(resp =>{           
		document.querySelector('#alert').innerHTML = '<div class="alert alert-success alert-dismissible fade show" role="alert"><strong>Good!</strong> Deleted product. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>'; 
	}).catch(err =>{
		document.querySelector('#alert').innerHTML = '<div class="alert alert-warning alert-dismissible fade show" role="alert"><strong>Warning!</strong> Something went wrong. <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
	})
}