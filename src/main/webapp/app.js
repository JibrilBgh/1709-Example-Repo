/**
 * app.js
 */
window.onload = function(){
	console.log('Dom Ready');
	loadNavbar();
	loadRevatureHomeView();
}

var navbar = null;
function loadNavbar(){
	console.log('Loading Navbar');
	
	//Use AJAX to grab the navbar.html fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received navbar fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			navbar = xhr.responseText;
			document.getElementById("navbar").innerHTML = navbar;
			/*
			 * Once the navbar has loaded we want 
			 * to set Event Listeners for changing the views
			 */
			document.getElementById('revatureHome').addEventListener("click", loadRevatureHomeView, false);
			document.getElementById('tx').addEventListener("click", loadTxView, false);
		}
	}
	xhr.open("GET", "URL_is_ajaxNavbar", true);
	xhr.send();
	
}

function loadRevatureHomeView(){
	console.log('Loading RevatureHomeView');
	//Use AJAX to grab the dashboard fragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
			getBankUserInfo();
		}
	}
	xhr.open("GET", "URL_is_ajaxRevatureHomeView", true);
	xhr.send();
}

var bankUser = null;
function getBankUserInfo(){
	//Use AJAX to grab the JSON object from server that holds bank user data 
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log('received navbar fragment');
		if(xhr.readyState == 4 && xhr.status == 200){
			bankUser = JSON.parse(xhr.responseText); //BankUserDTO parsed into JS
			document.getElementById("bankuser").innerHTML = bankUser.username;
			document.getElementById("baNumber").innerHTML = bankUser.baId;
			document.getElementById("balance").innerHTML = bankUser.baBalance;
			
		}
	}
	xhr.open("GET", "URL_is_ajaxGetBankUserInfo", true);
	xhr.send();
}

function loadTxView(){
	console.log('Loading txView');
	//Use AJAX to grab the TXfragment
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			document.getElementById("view").innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "URL_is_ajaxTxView", true);
	xhr.send();
}