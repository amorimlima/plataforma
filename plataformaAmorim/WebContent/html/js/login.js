$(document).ready(function () {
        $("#btnSubmit").click(function () {
        
        	 var userName = $("#login").val();
             var password = $("#senha").val();

             //call the authenticate function
             authenticate(userName, password);
            
        });
    });

function authenticate() {
	
	$.ajax({
		
		url: "http://localhost:8082/plataformaAmorim/Usuario/"+login+"/"+senha,
		type: "GET",
		crossDomain: true
		 // data: $("#frmLogin").serialize()
	 }).then(function(data) {
	    	
	      alert(data);
	       
	    });
	
	
}