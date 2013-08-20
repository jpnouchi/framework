package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Cliente;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ClienteVm;

@TypeConverter
public class ClienteToClienteVm implements Converter<Cliente, ClienteVm> {
	@Override
	public ClienteVm convert(Cliente source) {
		ClienteVm clienteVm = new ClienteVm();
		BeanUtils.copyProperties(source, clienteVm);
		
		return clienteVm;
	}
}
