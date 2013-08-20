package com.tci.ventas.pasaje.domain.converter;

import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Bus;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusVm;

@TypeConverter
public class BusToBusVm implements Converter<Bus, BusVm>{

	@Override
	public BusVm convert(Bus source) {
		BusVm busVm = new BusVm();	
		//BeanUtils.copyProperties(source, busVm);
		busVm.setIdBus(source.getIdBus());
		busVm.setIdBusLegacy(source.getIdBusLegacy());
		busVm.setMarca(source.getMarca());
		busVm.setModelo(source.getModelo());
		
		return busVm;
	}
	

}
