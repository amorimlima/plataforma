			
$(document).ready(function() {

			var Limite,
			HtmlContent,
			ListaTipoEventosHTML,
			ValorList,
			HtmlContentTable,
			IDselecionado,
			HTMLracionado,
			NumeroAntigo, 
			NumeroNovo;

			
	});








				function TrocarFrame(Objeto)
				{
					$('#CadastroTipoEventoFrame').css("display","none");
					$('#CadastroAnoLetivoFrame').css("display","none");
					$('#SelecionarFiltroFrame').css("display","none");
					$('#EdicaoTipoEventoFrame').css("display","none");
					$('#ListarFiltroFrame').css("display","none");
					$('#CadastroFrame').css("display","none");
					$('#EdicaoFrame').css("display","none");


					$('#'+Objeto+'').css("display","block");
				}


				function CadastroFrame()
				{

	    			$('#CadastroFrame #evento').val("");
	    			$('#CadastroFrame #dataInicio').val("");
	    			$('#CadastroFrame #dataFim').val("");
	    			$('#CadastroFrame #anoLetivo').val("");
	    			$('#CadastroFrame #tipoEvento').val("");


					TrocarFrame("CadastroFrame");
					GetOptionsEventos("CadastroFrame", null, null);

					loadEventoS();

					$('#CadastroFrame #id').val(null);
	    			$('#CadastroFrame #action').val("create");


					$('#TabelaPopUp').css("display","block");
					$('.total').css("display","none");
					$('.leftOrder').css("display","none");
					$('#SearchButton').css("display","none");
					$('#NewButton').css("display","none");
				}



				function FramesPopUp(Numero)
				{
					
					switch(Numero)
					{
						case 6:
						GetEventos();
						TrocarFrame("SelecionarFiltroFrame");
						break;
					}


					OpenPopUp();

					$('#SearchButton').css("display","block");
					$('#NewButton').css("display","block");
					$('#VisualizaSelecaoButton').css("display","none");
					$('#DeleteButton').css("display","none");
					$('#CancelButton').css("display","none");
					$('#SalvarButton').css("display","none");


				}

				function PopUpIdTabela()
				{

					TrocarFrame("EdicaoFrame");
					    $('#VisualizaSelecaoButton').css("display","none");
						$('#TabelaPopUp').css("display","block");
						$('.total').css("display","none");
						$('.leftOrder').css("display","none");
						$('#SearchButton').css("display","none");
						$('#DeleteButton').css("display","block");
						$('#CancelButton').css("display","block");
						$('#SalvarButton').css("display","block");

					setValorPopup(ValorList);
					$.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/Eventos/"+IDselecionado
				        
				    }).then(function(data) {

				    	$('#EdicaoFrame #evento').val(data.evento);
				    	$('#EdicaoFrame #dataInicio').val(data.dataInicio);
				    	$('#EdicaoFrame #dataFim').val(data.dataFim);

				    	GetOptionsEventos("EdicaoFrame", data.anoLetivo.idanoLetivo, data.tipoEvento.idtipoEvento);

				    	$('#EdicaoFrame #id').val(IDselecionado);
	    				$('#EdicaoFrame #action').val("update");

				        //$('.TabelaPopUpBody').html(HtmlContentTable);
				    });
				}

				function GetOptionsEventos(Objeto, NumeroLetivo, NumeroTipo)
				{

					$('#'+Objeto+' #anoLetivo').html('');
					$('#'+Objeto+' #tipoEvento').html('');

					/* Ano Letivo */

					$.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/AnoLetivo/"
				        
				    }).then(function(data) {

				    	for(var a=0; a< data.length; a++){
				    		if(NumeroLetivo == data[a].idanoLetivo){

								$('#'+Objeto+' #anoLetivo').append('<option value="'+data[a].idanoLetivo+'" selected>'+data[a].ano+'</option>');
				    		
				    		} else {

				    			$('#'+Objeto+' #anoLetivo').append('<option value="'+data[a].idanoLetivo+'">'+data[a].ano+'</option>');
				    		
				    		}
				    	}

				    });


				    /* Tipo Evento */

				    $.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/TipoEvento/"
				        
				    }).then(function(data) {

				    	for(var a=0; a< data.length; a++){

				    		if(NumeroTipo == data[a].idtipoEvento){

				    			$('#'+Objeto+' #tipoEvento').append('<option value="'+data[a].idtipoEvento+'" selected>'+data[a].evento+'</option>');

				    		} else {

				    			$('#'+Objeto+' #tipoEvento').append('<option value="'+data[a].idtipoEvento+'">'+data[a].evento+'</option>');
				    		
				    		}
				    	}

				    });


				}


				function OpenPopUp()
				{

					$('#TabelaPopUp').css("display","block");
					$('.total').css("display","none");
					$('.leftOrder').css("display","none");
				}

				function ClosePopUp()
				{
					document.getElementById("TabelaPopUp").style.display = "none";
					$('.total').css("display","block");
					$('.leftOrder').css("display","block");
					IDselecionado = null;
				}

				function NovoTipoEvento()
				{
					TrocarFrame("CadastroTipoEventoFrame");
					GetValoresTipoEvento();

				}



/*-----------------------Sem Retorno-----------------------*/


				function FiltrarEventos()
				{
					$.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/Eventos/"
				        
				    }).then(function(dataGet) {

				    	HtmlContent = "";
							
				        for(var a = 0; a < dataGet.length; a++){


				        	if((dataGet[a].tipoEvento.evento.indexOf(document.getElementById("tipoEvento").value) >= 0 || document.getElementById("tipoEvento").value == "Todos" || document.getElementById("tipoEvento").value == "") && 
				        		(dataGet[a].anoLetivo.ano.indexOf(document.getElementById("anoLetivo").value) >= 0 || document.getElementById("anoLetivo").value == "Todos" || document.getElementById("anoLetivo").value == "") && 
				        		(dataGet[a].evento.indexOf(document.getElementById("descricaoEvento").value) >= 0 || document.getElementById("descricaoEvento").value == "Todos" || document.getElementById("descricaoEvento").value == "") && 
				        		(dataGet[a].dataInicio.indexOf(document.getElementById("dataInicio").value) >= 0 || document.getElementById("dataInicio").value == "") && 
				        		(dataGet[a].dataFim.indexOf(document.getElementById("dataFim").value) >= 0 ||  document.getElementById("dataFim").value == "")){


							HtmlContent+='<div class="itemResultado"> '+dataGet[a].evento+' <input type="radio" name="result" onclick="SaveValueRadioListEvento(this.value);" value="'+dataGet[a].ideventos+'"> </div> <br>';
				
				        	}
				       	
				        }

				        TrocarFrame("ListarFiltroFrame");

				        $('#ContentResultadosFiltro').html(HtmlContent);
				        $('#SearchButton').css("display","none");
				        $('#NewButton').css("display","none");
						$('#VisualizaSelecaoButton').css("display","none");
				       

				    });
				}

				function NumeroOrdenacao(Numero){
					NumeroNovo = Numero;
					if(NumeroAntigo == NumeroNovo){document.getElementById('Ordem').checked = true;NumeroNovo = 0;}
					else{document.getElementById('Ordem2').checked = true;}
					NumeroAntigo = NumeroNovo;
					
				}


				function OrdenarPor(TString)
				{
					

					$('#tbConteudo').find('.OrdenaAtivo').sort(function(x,b){
						console.log(x,b);
							if(document.getElementById('Ordem').checked){
				        		return x.getElementsByClassName(TString)[0].innerHTML > b.getElementsByClassName(TString)[0].innerHTML;
				        		
							} else {
								return x.getElementsByClassName(TString)[0].innerHTML < b.getElementsByClassName(TString)[0].innerHTML;
								

							}
				       }).appendTo($('#tbConteudo'));
					$(".lastOne").insertAfter($("tr:last"));
				}




				function deleteEvent()
				{

					var R = confirm("Deseja mesmo excluir este evento?");
					
					if (R == true) {

					    	$.ajax({   
							url: "http://177.55.99.90/plataformaAmorim/Eventos/delete/"+IDselecionado,
							type: "POST",
							crossDomain: true,
							//data: $("#frmCadastro").serialize()
						}).done(function(){

						});
						//window.location="http://177.55.99.90/plataformaAmorim/Eventos/delete/"+IDselecionado;

						FramesPopUp(6);
					} 

				}


				function GetValoresTipoEvento()
				{
					$.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/TipoEvento"
				        
				    }).then(function(data) {

						ListaTipoEventosHTML = "";

						for(var a = 0; a < data.length; a++){
				    		ListaTipoEventosHTML +="<option value='"+data[a].idtipoEvento+"'>"+data[a].evento+"</option>";
				    	}

				    	$("#CadastroTipoEventoFrame #ContentResultadosTipoEvento").html(ListaTipoEventosHTML);
				    });
				}




/*-----------------------Set's-----------------------*/

				function SaveValueRadioListEvento(valor)
				{
					ValorList = valor;
					$('#VisualizaSelecaoButton').css("display","block");
				}

				function setValorPopup(Numero){
					IDselecionado = Numero;
				} 

/*-----------------------Get's-----------------------*/

				function getValorPopup(){
					return IDselecionado;
				}


				function GetTipoEvento()
				{
					$.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/TipoEvento"
				        
				    }).then(function(data) {

						ListaTipoEventosHTML = "";

						ListaTipoEventosHTML +="<option value=''></option>";

						for(var a = 0; a < data.length; a++){
				    		ListaTipoEventosHTML +="<option value='"+data[a].evento+"'>"+data[a].evento+"</option>";
				    	}

				    	ListaTipoEventosHTML +="<option value='Todos'>Todos</option>";

				    	document.getElementById("tipoEvento").innerHTML = ListaTipoEventosHTML;
				    });

				}


				function GetAnoLetivo()
				{

				    $.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/AnoLetivo"
				        
				    }).then(function(data) {

						ListaLetivoEventosHTML = "";

						ListaLetivoEventosHTML +="<option value=''></option>";

						for(var a = 0; a < data.length; a++){
				    		ListaLetivoEventosHTML +="<option value='"+data[a].ano+"'>"+data[a].ano+"</option>";
				    	}

				    	ListaLetivoEventosHTML +="<option value='Todos'>Todos</option>";

				    	document.getElementById("anoLetivo").innerHTML = ListaLetivoEventosHTML;
				    });

				}


				function GetNomeEvento()
				{

				    $.ajax({
				    type: "GET",
				    crossDomain: true,
				    url: "http://177.55.99.90/plataformaAmorim/Eventos/"
				        
				    }).then(function(data) {

						NomeLetivoEventosHTML = "";

						NomeLetivoEventosHTML +="<option value=''></option>";

						for(var a = 0; a < data.length; a++){
				    		NomeLetivoEventosHTML +="<option value='"+data[a].evento+"'>"+data[a].evento+"</option>";
				    	}

				    	NomeLetivoEventosHTML +="<option value='Todos'>Todos</option>";

				    	document.getElementById("descricaoEvento").innerHTML = NomeLetivoEventosHTML;
				    });

				}


				function GetEventos()
				{

					GetTipoEvento();
					GetAnoLetivo();
					GetNomeEvento();

				}



				function GetData()
				{
					 /*Pegar Data Atual*/

					var today = new Date();
					var dd = today.getDate();
					var mm = today.getMonth()+1; //January is 0!
					var yyyy = today.getFullYear();

					if(dd<10) {
					    dd='0'+dd
					} 

					if(mm<10) {
					    mm='0'+mm
					} 

					return (yyyy+"-"+mm+"-"+dd);
				}






/*IDNKWTFIT*/

/*var id = location.search.split('?id=')[1];*/
//$('#action').val("create");






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
});*/

/*
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
}
*/

$(document).ready(function () {
		
		$('#CadastroFrame #action').val("create");
	});


$(document).ready(function () {
		
		$('#EdicaoTipoEventoFrame #action').val("update");
	});

$(document).ready(function () {
        $("#CadastroFrame #btnSubmit").click(function () {
            cadastrar();
        });
    });

function cadastrar() {
	
        $("#CadastroFrame #frmEvento").unbind('submit').on("submit", function(event) {
        	
            event.preventDefault();

           

            //if(GetData() <= $("#CadastroFrame #dataInicio").val() &&
            	//$("#CadastroFrame #dataFim").val() >= $("#CadastroFrame #dataInicio").val()){
	            $.ajax({
	                url: "http://177.55.99.90/plataformaAmorim/Eventos",
	                type: "post",
	                data: $(this).serialize(),
	                success: function(d) {
	                    alert("Dados inseridos com sucesso!");
	    				FramesPopUp(6);
	    				
	                }
	            });
        	//} else {
    		//	alert("Verifique a Data inserida");
    		//}
        });
	
}


$(document).ready(function () {
    $("#EdicaoFrame #btnSubmit").click(function () {
        editar();
    });
});

function editar() {
	
        $("#EdicaoFrame #frmEvento").on("submit", function(event) {
        	
            event.preventDefault();


           
	            $.ajax({
	                url: "http://177.55.99.90/plataformaAmorim/Eventos/",
	                type: "post",
	                data: $(this).serialize(),
	                success: function(d) {
	                    alert("Dados alterados com sucesso!");
	    				FramesPopUp(6);
	                }
	            });
    		
        });


	
}


$(document).ready(function () {
 $('#PesquisaResultado_TipoCadastro #action').val("create");
 });

$(document).ready(function () {
    $("#PesquisaResultado_TipoCadastro #NovoTipoButton").click(function () {
       
        CriarTipoEventoF();
    });
});

function CriarTipoEventoF() {
	
        $("#PesquisaResultado_TipoCadastro #frmEvento").on("submit", function(event) {
        	
            event.preventDefault();
           
	            $.ajax({
	                url: "http://177.55.99.90/plataformaAmorim/TipoEvento/",
	                type: "post",
	                data: $(this).serialize(),
	                success: function(d) {
	                    alert("Dados inseridos com sucesso!");
	    				TrocarFrame("CadastroFrame");
	                }
	            });
    		
        });


	
}





$(document).ready(function () {
    $("#EdicaoTipoEventoFrame #btnSubmit").click(function () {
        editarTipoEvento();
    });
});

function editarTipoEvento() {
	
        $("#EdicaoTipoEventoFrame #frmEvento").on("submit", function(event) {
        	
            event.preventDefault();


           
	            $.ajax({
	                url: "http://177.55.99.90/plataformaAmorim/TipoEvento/",
	                type: "post",
	                data: $(this).serialize(),
	                success: function(d) {
	                    alert("Dados alterados com sucesso!");
	    				FramesPopUp(6);
	                }
	            });
    		
        });


	
}