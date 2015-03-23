$(document).ready(function() {
    
	 var id = location.search.split('?id=')[1];
		

	$.ajax({
    	type: "DELETE",
    	crossDomain: true,
    	url: "http://localhost:8082/plataformaAmorim/Eventos/"+id
    	
    
        	
    }).then(function(data) {
    	
    	
    });
});

