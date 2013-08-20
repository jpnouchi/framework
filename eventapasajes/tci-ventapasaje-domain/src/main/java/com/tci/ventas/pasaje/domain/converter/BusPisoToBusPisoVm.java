package com.tci.ventas.pasaje.domain.converter;

import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.BusPiso;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoVm;

@TypeConverter
public class BusPisoToBusPisoVm implements Converter<BusPiso, BusPisoVm>{

	@Override
	public BusPisoVm convert(BusPiso source) {
		BusPisoVm busPisoVm = new BusPisoVm();	
		//BeanUtils.copyProperties(source, busPisoVm);
		busPisoVm.setTotalNumeroColumna(source.getTotalNumeroColumna());
		busPisoVm.setTotalNumeroFila(source.getTotalNumeroFila());
		busPisoVm.setIdPiso(source.getIdPiso());
		
		return busPisoVm;
	}
	

}
