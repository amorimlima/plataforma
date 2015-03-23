$(document).ready(function () {
        $("#btnSubmit").click(function () {
            cadastrar();
        });
    });

function cadastrar() {
	

        $("#frm").on("submit", function(event) {
            event.preventDefault();
alert("oi");
            $.ajax({
                url: "http://localhost:8082/plataformaAmorim/Alunos",
                type: "post",
                crossDomain: true,
                data: $(this).serialize(),
                success: function(d) {
                    alert(d);
    
                }
            });
        });

	
}
