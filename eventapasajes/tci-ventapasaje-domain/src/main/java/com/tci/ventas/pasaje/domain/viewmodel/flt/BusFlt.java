package com.tci.ventas.pasaje.domain.viewmodel.flt;

import com.tci.domain.viewmodel.FilterBase;

public class BusFlt extends FilterBase {

	private Long idBus;
	private Long idBusLegacy;
	
	public Long getIdBus() {
		return idBus;
	}
	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}
	public Long getIdBusLegacy() {
		return idBusLegacy;
	}
	public void setIdBusLegacy(Long idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}
	
}
