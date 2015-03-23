/*var Limite;
var HtmlContent;

$(document).ready(function() {
    $.ajax({
    	type: "GET",
    	crossDomain: true,
    	url: "http://177.55.99.90/plataformaAmorim/Alunos/"
        	
    }).then(function(data) {

        Limite = data.aluno.length;
       
    	HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro"></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+data.aluno[a].nome+'<br />'+data.aluno[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });
});


var Limite;
var HtmlContent;

$(document).ready(function() {
    $.ajax({
    type: "GET",
    crossDomain: true,
    url: "http://177.55.99.90/plataformaAmorim/Alunos/"
        
    }).then(function(data) {

        Limite = data.aluno.length;
       
    HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro" id="images" > <img src="data:image/png;base64,' + 
            data.aluno[a].fotoAluno + ' "  height="86px" width="86px" /></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+ data.aluno[a].nome+'<br />'+data.aluno[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });
});
*/

/*Cadastro*/

/*var Limite;
var HtmlContent;

$(document).ready(function() {
    $.ajax({
        type: "GET",
        crossDomain: true,
        url: "http://177.55.99.90/plataformaAmorim/Alunos/"
            
    }).then(function(data) {

        Limite = data.aluno.length;
       
        HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro"></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+data.aluno[a].nome+'<br />'+data.aluno[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });
});


var Limite;
var HtmlContent;

$(document).ready(function() {
    $.ajax({
    type: "GET",
    crossDomain: true,
    url: "http://177.55.99.90/plataformaAmorim/Alunos/"
        
    }).then(function(data) {

        Limite = data.aluno.length;
       
    HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro" id="images" > <img src="data:image/png;base64,' + 
            data.aluno[a].fotoAluno + ' "  height="86px" width="86px" /></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+ data.aluno[a].nome+'<br />'+data.aluno[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });
});
*/

/* Listar Alunos */

 /*var Limite;
var HtmlContent;

$(document).ready(function() {
    $.ajax({
        type: "GET",
        crossDomain: true,
        url: "http://177.55.99.90/plataformaAmorim/Alunos/"
            
    }).then(function(data) {

        Limite = data.aluno.length;
       
        HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro"></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+data.aluno[a].nome+'<br />'+data.aluno[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });
});
*/


/*

$(document).ready(function() {

var Limite;
var HtmlContent;

    $.ajax({
    type: "GET",
    crossDomain: true,
    url: "http://177.55.99.90/plataformaAmorim/Alunos/"
        
    }).then(function(data) {

        Limite = data.length;
       
    HtmlContent = "";

        for(var a = 0; a < Limite; a++){
            
            HtmlContent += '<div class="Conteudo_Coluna2_Aluno">';

            HtmlContent += '<div class="FotoAlunoCadastro" id="images" > <img src="data:image/png;base64,' + 
            data[a].fotoAluno + ' "  height="86px" width="86px" /></div>';

            //HtmlContent += '<div class="Botao_Aviso"></div>';

            HtmlContent += '<div class="Nome_do_Aluno">'+ data[a].nome+'<br />'+data[a].idAluno+'</div>';

            HtmlContent += "</div>";

        }

        $('.total').append(HtmlContent);
       
    });



http://177.55.99.90/plataformaAmorim/Eventos/
    
});*/