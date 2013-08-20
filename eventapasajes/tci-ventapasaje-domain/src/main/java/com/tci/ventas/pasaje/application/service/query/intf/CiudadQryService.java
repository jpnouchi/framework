package com.tci.ventas.pasaje.application.service.query.intf;

import java.util.List;

import com.tci.ventas.pasaje.domain.viewmodel.vm.CiudadVm;

public interface CiudadQryService {
	List<CiudadVm> findAll();
	
}
