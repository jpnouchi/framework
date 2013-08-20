jQuery(document).ready(function($) {
    $("div[id^='roles\\:']").css({'height':'5px','padding':'0'});

    $("#top > div").css({'overflow':'hidden'});

    $('a', $('#rolForm')).each(function(i) {
         $(this).click(function () {
            $("#rolForm\\:activeRol").attr("value", $(this).attr("href"));
            $("#rolForm\\:tabButton").click();
        });
    })

   $('a').mouseover(function(){window.status='';return true;})
    .mouseout(function(){window.status='';return true;});

});

