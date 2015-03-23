var id = location.search.split('?id=')[1];
$('#action').val("create");





$(document).ready(function() {
    $.ajax({
    	type: "GET",
    	crossDomain: true,
    	url: "http://localhost:8082/plataformaAmorim/AnoLetivo"
        	
    }).then(function(data) {
    	//clear the current content of the select
        
        var $select = $('#anoLetivo');
        $select.html('');
    	for(var i = 0; i < data.length ; i++){

    	
    	    $select.append('<option value="' + data[i].idanoLetivo + '">' + data[i].ano+  '</option>');
    	    
    	  

    	}


    	
    	
      
       
    });
});


$(document).ready(function() {
    $.ajax({
    	type: "GET",
    	crossDomain: true,
    	url: "http://localhost:8082/plataformaAmorim/TipoEvento"
        	
    }).then(function(data) {
    	//clear the current content of the select
        
        var $select = $('#tipoEvento');
        $select.html('');
    	for(var i = 0; i < data.length ; i++){
    	
    	    $select.append('<option value="' + data[i].idtipoEvento + '">' + data[i].tipoEvento +  '</option>');
    	    
    	      	    
    	}


    	
    	
      
       
    });
});
    
    
// VALIDA EDICAO
if (id != null ){
	
	$(document).ready(function () {
		 
		$.ajax({
	    	type: "GET",
	    	crossDomain: true,
	    	
	    	url: "http://localhost:8082/plataformaAmorim/Eventos/"+id
	        	
	    }).then(function(data) {
	    	
	    	//alert(data.evento);
	    	$('#evento').val(data.evento);
	    	$('#dataInicio').val(data.dataInicio);
	    	$('#dataFim').val(data.dataFim);
	    	$('#dataFim').val(data.dataFim);
	    	
	    	
	    	$('#tipoEvento').append('<option value="' + data.tipoEvento.idtipoEvento + '"selected>' + data.tipoEvento.evento+  '</option>');
	    	
	    	$('#anoLetivo').append('<option value="' + data.anoLetivo.idanoLetivo + '"selected>' + data.anoLetivo.ano+  '</option>');
	    	
	    	$('#id').val(data.ideventos);
	    	$('#action').val("update");
	       
	    });	
	 });	
	
} else {
	$(document).ready(function () {
		
		$('#action').val("create");
	});
}


$(document).ready(function () {
        $("#btnSubmit").click(function () {
            cadastrar();
        });
    });

function cadastrar() {
	

        $("#frmEvento").on("submit", function(event) {
            event.preventDefault();

            $.ajax({
                url: "http://localhost:8082/plataformaAmorim/Eventos",
                type: "post",
                crossDomain: true,
                data: $(this).serialize(),
                success: function(d) {
                    alert(d);
    
                }
            });
        });

	
	
	//alert ("http://localhost:8082/plataformaAmorim/Eventos/");
	//$.ajax({
		
	//	url: "http://localhost:8082/plataformaAmorim/Eventos",
	//	type: "POST",
	//	data: $("#frmEvento").serialize()
	//	});	
	
}
