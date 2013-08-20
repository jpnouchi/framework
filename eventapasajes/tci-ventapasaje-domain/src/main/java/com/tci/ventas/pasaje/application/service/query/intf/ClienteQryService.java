package com.tci.ventas.pasaje.application.service.query.intf;

import java.util.List;

import com.tci.ventas.pasaje.domain.viewmodel.flt.ClienteFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ClienteRsl;

public interface ClienteQryService {
	List<ClienteRsl> find(ClienteFlt clienteFlt);
	List<ClienteRsl> findAll();
}
