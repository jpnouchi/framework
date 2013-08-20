package com.tci.ventas.pasaje.application.service.business.intf;

import com.tci.ventas.pasaje.domain.viewmodel.vm.ClienteVm;

public interface ClienteService {
	ClienteVm getClienteVmForCreation();

	ClienteVm getClienteVmForEdition(Long idCliente);

	void save(ClienteVm clienteVm);

	void delete(Long idCliente);
}
