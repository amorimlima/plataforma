
$(document).ready(function () {
        //event handler for submit button
        $("#btnSubmit").click(function () {
            //collect userName and password entered by users
           /* var userName = $("#userName").val();
            var password = $("#password").val();*/
            var userName = 1
            var password = 1

            //call the authenticate function
            authenticate(userName, password);
        });
    });

    //authenticate function to make ajax call
    function authenticate(userName, password) {
    /*http://localhost:8082/plataformaAmorim/auth*/
    $.ajax({
    url: "http://177.55.99.90/plataformaAmorim/CadastarAluno",
    type: "POST",
      data: $("#frmLogin").serialize()
    }).done(function() {
      alert("done");
    });
    
    
    }