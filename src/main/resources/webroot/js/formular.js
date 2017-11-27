$(document).ready(function () {
    
    $("body").html('<h1>Shop17</h1>Name: <input type="text" id="eingabeName"/>\n\
<br>Passwort: <input type="text" id="eingabePasswort"/><br>\n\
<input type="button" id="eingabeKnopf" value="OK" />');
    
    
    
    $("#eingabeKnopf").click(function () {
        $.ajax({url:"../anfrage", data:
                {
                    typ: "namenKnopf",
                    name: $("#eingabeName").val(),
                    passwort: $("#eingabePasswort").val()
                },
                success: function (data) {
                    $("body").html("<div>" + data.text+"</div>");
                }
            });
    });
});                     