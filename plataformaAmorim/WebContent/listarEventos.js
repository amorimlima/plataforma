var Limite;
$(document).ready(function() {
    $.ajax({
    	type: "GET",
    	crossDomain: true,
    	url: "http://177.55.99.90/plataformaAmorim/Eventos/"
        	
    }).then(function(data) {

    var HtmlContent = "";
   
    HtmlContent = "";
	HtmlContent += '<table border=1>';
	HtmlContent += '<tr>';
	HtmlContent += '<td>Tipo Evento</td>';
	HtmlContent += '<td>anoLetivo</td>';
	HtmlContent += '<td>Inicio Evento</td>';
	HtmlContent += '<td>Fim Evento</td>';
	HtmlContent += '<td>Nome do Evento</td>';
	HtmlContent += '<td>ideventos</td>';
	HtmlContent += '<td>edit</td>';
	HtmlContent += '<td>delete</td>';
	HtmlContent += '</tr>';

	
	
	
    for(var i = 0; i < data.length ; i++){
        
        HtmlContent += '<tr>';
        
        HtmlContent += '<td>'+ data[i].tipoEvento.evento+'</td>';
        HtmlContent += '<td>'+ data[i].anoLetivo.ano+'</td>';
    	HtmlContent += '<td>'+ data[i].dataInicio+'</td>';
    	HtmlContent += '<td>'+ data[i].dataFim+'</td>';
    	HtmlContent += '<td>'+ data[i].evento+'</td>';
    	HtmlContent += '<td>'+ data[i].ideventos+'</td>';
    	HtmlContent += '<td> <a href="editarEventos.html?id=' +data[i].ideventos + '"> <img src="img/edit.gif"/> </a> </td>';
    	HtmlContent += '<td> <a href="http://177.55.99.90/plataformaAmorim/Eventos/delete/' +data[i].ideventos + '"> <img src="img/delete.gif"/> </a> </td>';
        HtmlContent += '</tr>';
  
        
    }
    HtmlContent += '</table>';
    $('.conteudo').append(HtmlContent);



    	
    	
      
       
    });
});

