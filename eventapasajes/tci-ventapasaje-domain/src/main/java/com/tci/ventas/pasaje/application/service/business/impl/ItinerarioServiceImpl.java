package com.tci.ventas.pasaje.application.service.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.tci.ventas.pasaje.application.service.business.intf.ItinerarioService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ItinerarioVm;

@Service
public class ItinerarioServiceImpl implements ItinerarioService {

	@Autowired
	ConversionService conversionService;

	protected final Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	public ItinerarioVm getItinerarioVmForValidation(ItinerarioFlt itinerarioFlt) {
		ItinerarioVm itinerarioVm = conversionService.convert(itinerarioFlt, ItinerarioVm.class);
		return itinerarioVm;
	}

	@Override
	public void getItinerarioFltForQuery(ItinerarioFlt itinerarioFlt) {
		
		if(!(itinerarioFlt.getIdServicioLegacy()!=null && 
				itinerarioFlt.getIdServicioLegacy().intValue()>0)){
			itinerarioFlt.setIdServicioLegacy(null);
		}
	}

	


}
