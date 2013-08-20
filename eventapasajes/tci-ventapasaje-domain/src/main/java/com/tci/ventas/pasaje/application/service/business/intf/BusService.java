package com.tci.ventas.pasaje.application.service.business.intf;

import com.tci.ventas.pasaje.domain.viewmodel.flt.BusFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusVm;

public interface BusService {

	BusVm getBusVmToShow(BusFlt busFlt);
	
	
}
