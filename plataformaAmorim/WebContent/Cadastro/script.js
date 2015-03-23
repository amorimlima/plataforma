$(document).ready(function(){
	$('#Confirma_Cadastro').click(function(){

		$.ajax({
			url: "http://localhost:8082/resource/plataformaAmorim/auth",
			type: "POST",
			data: $("#frmCadastro").serialize()
		}).done(function(){
			alert("done");
		});

	});
});

function authenticate(Nome, Serie){

	

}
