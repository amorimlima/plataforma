$(document).ready(function() {
    
	 var id = location.search.split('?id=')[1];

	$.ajax({
    	type: "GET",
    	crossDomain: true,
    	
    	url: "http://localhost:8082/plataformaAmorim/Eventos/"+id
        	
    }).then(function(data) {
    	
       $('.id').append(data.evento);
       $('.nome').append(data.evento);
       
    });
});

z

