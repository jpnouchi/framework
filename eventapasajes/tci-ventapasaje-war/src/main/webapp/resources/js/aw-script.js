function isAlphanumericSpace(event) {
    //var key = (document.all) ? event.keyCode : event.which;
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode; else if (event)
        key = event.which; else
        return true;

    keychar = String.fromCharCode(key);

    if ((key >= 48 && key <= 57) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || key == 209 || key == 241 || key == 32 || key == 0 || key == 8) {
        return true;
    }
    return false;
}

function isAlphanumeric(event) {
    //var key = (document.all) ? event.keyCode : event.which;
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode; else if (event)
        key = event.which; else
        return true;

    keychar = String.fromCharCode(key);


    if ((key >= 48 && key <= 57) || (key >= 65 && key <= 90) || (key >= 97 && key <= 122) || key == 209 || key == 241 || key == 0 || key == 8) {
        return true;
    }

    if (keychar == "." || keychar == "," || keychar == "@") {
        return true;
    }
    return false;
}


function isPositiveIntegerNumberAndZero(myfield, e) {
    return isPositiveNumericAndZero(myfield,e,false,false);
}

function isPositiveIntegerNumber(myfield, e) {
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode; else if (e)
        key = e.which; else
        return true;
    keychar = String.fromCharCode(key);
    if(myfield.value.toString()=='' && keychar== '0'){
        return false;
    }
    return isPositiveNumericAndZero(myfield,e,false,false);
}

function isPositiveNumericAndZero(myfield, e, dec, frac) {
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode; else if (e)
        key = e.which; else
        return true;
    keychar = String.fromCharCode(key);
    if ((key == null) || (key == 0) || (key == 8) || (key == 9) || (key == 27))
        return true; else if ((("0123456789").indexOf(keychar) > -1))
        return true; else if (keychar == ",") {
        return false;
    }
    else if (dec && (keychar == ".")) {
        return true;
    }
    else if (frac && keychar == "/") {
        return true;
    }else if (key == 13) {
        return false;
    } else return false;
}
function numericFormat(myfield, dec) {
    if(myfield.length>0){
        myfield.value=eval(myfield.value).toFixed(dec);
    }
}
function isNumeric(myfield, e, dec, frac) {
    var key;
    var keychar;
    if (window.event)
        key = window.event.keyCode; else if (e)
        key = e.which; else
        return true;
    keychar = String.fromCharCode(key);
    if ((key == null) || (key == 0) || (key == 8) || (key == 9) || (key == 27))
        return true; else if ((("0123456789").indexOf(keychar) > -1))
        return true; else if (keychar == ",") {
        return false;
    }
    else if (keychar == "-") {
        return  myfield.value.toString()=='';
    }
    else if (keychar == "+") {
        return  myfield.value.toString()=='';
    }
    else if (dec && (keychar == ".")) {
        return true;
    }
    else if (frac && keychar == "/") {
        return true;
    }else if (key == 13) {
        return false;
    } else return false;
}

function textObjectUpperCase(textObject) {
    textObject.value = textObject.value.toUpperCase() ;
}


function loadPrimefacesLocales() {
    PrimeFaces.locales['es'] = {
        closeText: 'Cerrar',
        prevText: 'Anterior',
        nextText: 'Siguiente',
        monthNames: ['Enero','Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene', 'Feb', 'Mar', 'Abr', 'May', 'Jun','Jul','Ago','Sep','Oct','Nov','Dic'],
        dayNames: ['Domingo','Lunes','Martes','Miércoles','Jueves','Viernes','Sábado'],
        dayNamesShort: ['Dom','Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
        dayNamesMin: ['D','L','M','X','J','V','S'],
        weekHeader: 'Semana',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: '',
        timeOnlyTitle: 'Sólo hora',
        timeText: 'Tiempo',
        hourText: 'Hora',
        minuteText: 'Minuto',
        secondText: 'Segundo',
        currentText: 'Fecha actual',
        ampm: false,
        month: 'Mes',
        week: 'Semana',
        day: 'Día',
        allDayText : 'Todo el día'
    };
}

