package com.tci.ventas.pasaje.application.service.business.intf;

import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ItinerarioVm;

public interface ItinerarioService {

	ItinerarioVm getItinerarioVmForValidation(ItinerarioFlt itinerarioFlt);
	
	void getItinerarioFltForQuery(ItinerarioFlt itinerarioFlt);
	
}
