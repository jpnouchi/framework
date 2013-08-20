package com.tci.ventas.pasaje.application.service.business.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.tci.ventas.pasaje.application.service.business.intf.ClienteService;
import com.tci.ventas.pasaje.domain.model.entity.Cliente;
import com.tci.ventas.pasaje.domain.model.repository.ClienteRepository;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ClienteVm;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	ConversionService conversionService; 
	
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Override
	public ClienteVm getClienteVmForCreation() {
		return new ClienteVm();
	}

	@Override
	public ClienteVm getClienteVmForEdition(Long idCliente) {
//		Cliente cliente = clienteRepository.findOne(idCliente);
//		ClienteVm usuarioCesarVm = conversionService.convert(cliente, ClienteVm.class);
//		
//		return usuarioCesarVm;
		return null;
	}

	@Override
	public void save(ClienteVm clienteVm) {
		Cliente cliente = conversionService.convert(clienteVm, Cliente.class);
		//clienteRepository.save(cliente);		
	}

	@Override
	public void delete(Long idCliente) {
		//clienteRepository.delete(idCliente);
	}
}
