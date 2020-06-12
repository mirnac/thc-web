var months = ["Ene","Feb", "Mar", "Abr", "May", "Jun", "Jul", "Ago", "Set","Oct","Nov", "Dic"];

function getBaseUrl() {
    return window.location.href.match(/^.*\//);
}

$(document).ready(function () {

    $("#logout-lnk").on("click", function (e) {
        $('#logout_form').submit();
    });

});
