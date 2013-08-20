package com.tci.ventas.pasaje.application.service.business.impl;
/**
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.tci.ventas.pasaje.application.service.business.intf.PortalService;
import com.tci.ventas.pasaje.domain.model.entity.Portal;
import com.tci.ventas.pasaje.domain.model.repository.PortalRepository;
import com.tci.ventas.pasaje.domain.viewmodel.vm.PortalVm;

@Service
public class PortalServiceImpl implements PortalService {

	@Autowired
	PortalRepository portalRepository;

	@Autowired
	ConversionService conversionService;

	protected final Logger LOG = LoggerFactory.getLogger(getClass());

	public PortalVm getPortalVmForCreation() {
		return new PortalVm();
	}

	public PortalVm getPortalVmForEdition(Long idPortal) {
		return getPortalVm(idPortal);
	}

	private PortalVm getPortalVm(Long idPortal) {
		Portal portal = portalRepository.findOne(idPortal);
		PortalVm portalVm = conversionService.convert(portal, PortalVm.class);
		return portalVm;
	}

	public void save(PortalVm portalVm) {
		Portal portal = conversionService.convert(portalVm, Portal.class);
		portalRepository.save(portal);
	}

	public void delete(Long idPortal) {
		portalRepository.deletePortal(idPortal);
	}

}
**/