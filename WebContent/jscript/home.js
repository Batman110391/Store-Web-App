document.querySelector('#btn_login').addEventListener('click', () =>{
	document.querySelector('form.sign-in.mt-3').classList.add("d-none");
	document.querySelector('form.login.mt-3').classList.remove("d-none");
});
	
document.querySelector('#btn_sign').addEventListener('click', () =>{
	document.querySelector('form.sign-in.mt-3').classList.remove("d-none");
	document.querySelector('form.login.mt-3').classList.add("d-none");
});

