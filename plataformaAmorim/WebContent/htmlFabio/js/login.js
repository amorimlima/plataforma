$(document).ready(function () {
        //event handler for submit button
        $("#btnSubmit").click(function () {
            //collect userName and password entered by users
            var userName = $("#login").val();
            var password = $("#senha").val();

            //call the authenticate function
            authenticate(userName, password);
        });
    });

function authenticate(userName, password) {
 
$.ajax({
 
url: "http://localhost:8082/plataformaAmorim/Usuario/" + userName + "/" + password,
type: "GET",
async: false,
success: function(data) {
if ( data.perfil =="admin") {
    alert ("Pagina admin ainda nao criada") ;
}else  if ( data.perfil =="aluno") {
alert ("Pagina aluno ainda nao criada") ;

}else  if ( data.perfil =="professor") {
alert ("Pagina professor ainda nao criada") ;
}else  if ( data.perfil =="tutor") {
alert ("Pagina tutor ainda nao criada") ;
} else {
alert ("Perfil nao previsto") ;
}
       
}
    });
}