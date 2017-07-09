$(document).ready(function(){
    $("input[type=text]").keyup(function(){

        var num = new RegExp("^[0-9]*\.?[0-9]+$");

        if(num.test($("#sum").val())){
            $("#sum-input").removeClass("glyphicon-remove");
            $("#sum-input").addClass("glyphicon-ok");
            $("#sum-input").css("color","#00A41E");
        }else{
            $("#sum-input").removeClass("glyphicon-ok");
            $("#sum-input").addClass("glyphicon-remove");
            $("#sum-input").css("color","#FF0004");
        }

        if(!(num.test($("#sum").val()))){
            document.getElementById("Button-balance").disabled = true;
        } else {
            document.getElementById("Button-balance").disabled = false;
        }
    });
});
