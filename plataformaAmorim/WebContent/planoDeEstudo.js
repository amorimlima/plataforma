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
                url: "http://177.55.99.90/plataformaAmorim/PlanoEstudo",
                type: "post",
                crossDomain: true,
                data: $(this).serialize(),
                success: function(d) {
                    alert(d);
    
                }
            });
        });

	
}
