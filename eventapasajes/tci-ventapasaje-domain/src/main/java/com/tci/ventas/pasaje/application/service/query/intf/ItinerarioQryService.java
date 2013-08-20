package com.tci.ventas.pasaje.application.service.query.intf;

import java.util.List;

import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;

public interface ItinerarioQryService {
	List<ItinerarioRsl> find(ItinerarioFlt itinerarioFlt);
	List<ItinerarioRsl> findAll();
}
