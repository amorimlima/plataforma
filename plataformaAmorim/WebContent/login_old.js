$(document).ready(function () {
        //event handler for submit button
        $("#btnSubmit").click(function () {
            //collect userName and password entered by users
            var userName = $("#userName").val();
            var password = $("#password").val();

            //call the authenticate function
            authenticate(userName, password);
        });
    });

    //authenticate function to make ajax call
    function authenticate(userName, password) {
    	
    	
    	$.ajax({
    		url: "http://localhost:8082/plataformaAmorim/auth",
    		type: "POST",
    		  data: $("#frmLogin").serialize()
    		}).done(function() {
    		  alert("done");
    		});
    	
    	
    }