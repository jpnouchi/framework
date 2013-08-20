package com.tci.ventas.pasaje.application.service.business.intf;

import com.tci.ventas.pasaje.domain.viewmodel.vm.PortalVm;

public interface PortalService {

	PortalVm getPortalVmForCreation();

	PortalVm getPortalVmForEdition(Long idPortal);

	void save(PortalVm portalVm);

	void delete(Long idPortal);
	
}
