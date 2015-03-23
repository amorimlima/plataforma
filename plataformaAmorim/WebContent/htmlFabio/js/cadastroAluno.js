/*$(document).ready(function(){
	$('#Confirma_Cadastro').click(function(){

		

		//authenticate(Cadastro_Nome, Cadastro_Serie);
		authenticate();

	});


});


function authenticate(){


	$.ajax({
		url: "../cadastrarEventos.html",
		type: "POST",
		crossDomain: true,
		data: $("#frmCadastroLetivo").serialize()
	}).done(function(){
		

		$.ajax({
			url: "../cadastrarEventos.html",
			type: "POST",
			crossDomain: true,
			data: $("#frmCadastroTipo").serialize()
		}).done(function(){
			

			$.ajax({
				url: "../cadastrarEventos.html",
				type: "POST",
				crossDomain: true,
				data: $("#frmCadastroEvento").serialize()
			}).done(function(){
				alert("done");
			});


			
		});

	});



	





}*/


var id = location.search.split('?id=')[1];
$('#action').val("create");





/*$(document).ready(function() {
    $.ajax({
    	type: "GET",
    	crossDomain: true,
    	url: "http://177.55.99.90/plataformaAmorim/AnoLetivo"
        	
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
    	url: "http://177.55.99.90/plataformaAmorim/TipoEvento"
        	
    }).then(function(data) {
    	//clear the current content of the select
        
        var $select = $('#tipoEvento');
        $select.html('');
    	for(var i = 0; i < data.length ; i++){

    	
    	    $select.append('<option value="' + data[i].idtipoEvento + '">' + data[i].evento+  '</option>');
    	    
    	  

    	}


    	
    	
      
       
    });
});*/
    
    
// VALIDA EDICAO
/*if (id != null ){
	
	$(document).ready(function () {
		 
		$.ajax({
	    	type: "GET",
	    	crossDomain: true,
	    	
	    	url: "http://177.55.99.90/plataformaAmorim/Eventos/"+id
	        	
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
}*/


$(document).ready(function () {
        $("#btnSubmit").click(function () {
            cadastrar();
        });
    });

function cadastrar() {
	

        $("#frmEvento").on("submit", function(event) {
            event.preventDefault();

            $.ajax({
                url: "http://177.55.99.90/plataformaAmorim/Eventos",
                type: "post",
                data: $(this).serialize(),
                success: function(d) {
                    alert(d);
    
                }
            });
        });

	
	
	//alert ("http://177.55.99.90/plataformaAmorim/Eventos/");
	//$.ajax({
		
	//	url: "http://177.55.99.90/plataformaAmorim/Eventos",
	//	type: "POST",
	//	data: $("#frmEvento").serialize()
	//	});	
	
}
