package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Cliente;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ClienteVm;

@TypeConverter
public class ClienteVmToCliente implements Converter<ClienteVm, Cliente>  {
	@Override
	public Cliente convert(ClienteVm source) {
		Cliente cliente = new Cliente();
		BeanUtils.copyProperties(source, cliente);
		
		return cliente;
	}
}
