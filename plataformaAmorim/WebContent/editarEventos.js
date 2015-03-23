
var id = location.search.split('?id=')[1];	
$(document).ready(function () {
	 
	$.ajax({
    	type: "GET",
    	crossDomain: true,
    	
    	url: "http://localhost:8082/plataformaAmorim/Eventos/"+id
        	
    }).then(function(data) {
    	
    	alert(data.evento);
    	$('#evento').val(data.evento);
    	$('#dia').val(data.dia);
    	$('#mes').val(data.mes);
    	$('#anoLetivo').val(data.anoLetivo);
    	$('#ideventos').val(data.ideventos);
       
    });	
	

	
	
        //event handler for submit button
        $("#btnSubmit").click(function () {
            //collect userName and password entered by users
           
            //call the authenticate function
            cadastrar();
        });
    });

    //authenticate function to make ajax call
    function cadastrar() {
    	
    	
    	$.ajax({
    		url: "http://localhost:8082/plataformaAmorim/Eventos/"+id,
    		type: "POST",
    		crossDomain: true,
    		  data: $("#frmEvento").serialize()
    		});
    	
    	
    }
    
    
