$(document).ready(function () {
    $("#eingabeKnopf").click(function () {
        $.ajax({url:"../anfrage", data:
                {
                    typ: "namenKnopf",
                    name: $("#eingabeName").val(),
                    passwort: $("#eingabePasswort").val()
                },
                success: function (data) {
                    $("body").append("<div>Daten: " + data.text+"</div>");
                }
            });
    });
});                     