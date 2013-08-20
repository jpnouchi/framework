package com.tci.ventas.pasaje.application.service.query.intf;

import java.util.List;

import com.tci.ventas.pasaje.domain.viewmodel.flt.PortalFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.PortalRsl;

public interface PortalQryService {
	List<PortalRsl> find(PortalFlt portalFlt);
	List<PortalRsl> findAll();
}
