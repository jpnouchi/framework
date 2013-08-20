package com.tci.ventas.pasaje.domain.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.tci.ventas.pasaje.domain.viewmodel.vm.ItinerarioVm;
import com.tci.ventas.pasaje.util.Constant;


/**
 * User: ralvarado
 * Date: 08/04/13
 */
@Component
public class ItinerarioVmValidator implements Validator {


    public boolean supports(Class<?> clazz) {
        return ItinerarioVm.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
    	ItinerarioVm itinerarioVm = (ItinerarioVm) target;

    	if(itinerarioVm.getIdCiudadOrigenLegacy()==null || itinerarioVm.getIdCiudadOrigenLegacy().intValue()<=0){
			errors.reject("itinerario.origen.no.seleccionado");
			return;

    	}
    	if(itinerarioVm.getIdCiudadDestinoLegacy()==null || itinerarioVm.getIdCiudadDestinoLegacy().intValue()<=0){
			errors.reject("itinerario.destino.no.seleccionado");
			return;
    	}
    	if(itinerarioVm.getFechaSalida()==null){
			errors.reject("itinerario.fechasalida.no.seleccionada");
			return;
		}
    	
    	if(itinerarioVm.getOpcionViaje().equals(Constant.OPCION_IDA_RETORNO)){
    		
    		if(itinerarioVm.getFechaRetorno()==null){
    			errors.reject("itinerario.fecharetorno.no.seleccionada");
    			return;
    		}
    		else if (itinerarioVm.getFechaRetorno().compareTo(itinerarioVm.getFechaSalida()) <= 0) {
                errors.reject("itinerario.fecharetorno.menor.fechasalida");
                return;
            }
    	}
    	
    }
}

