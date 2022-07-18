/**
 * 
 */


let id=document.body.querySelector("#name");
let phone=document.body.querySelector("#phone");
let address=document.body.querySelector("#address");
let city=document.body.querySelector("#city");

function boxCheck(form){
	
	if(id!==null && phone!==null && address!==null && city !==null){
		form.submit();
	}
	else{
		location.href="join.jsp";
	}
	
}