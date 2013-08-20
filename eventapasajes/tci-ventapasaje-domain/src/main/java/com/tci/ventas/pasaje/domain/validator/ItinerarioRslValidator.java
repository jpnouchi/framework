package com.tci.ventas.pasaje.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tci.exception.TciException;
import com.tci.exception.TciValidationException;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ItinerarioVm;
import com.tci.ventas.pasaje.util.Constant;


/**
 * User: ralvarado
 * Date: 08/04/13
 */
@Component
public class ItinerarioRslValidator implements Validator {


    public boolean supports(Class<?> clazz) {
        return ItinerarioRsl.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
    	ItinerarioRsl itinerarioRsl = (ItinerarioRsl) target;

    	if(itinerarioRsl==null){
    		errors.reject("comprar.pasaje.itinerario.no.seleccionado");
			return;
    	}
    	
    }
}

