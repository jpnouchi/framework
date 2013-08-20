package com.tci.ventas.pasaje.domain.converter;

import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.BusPisoPosicion;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionVm;

@TypeConverter
public class BusPisoPosicionToBusPisoPosicionVm implements Converter<BusPisoPosicion, BusPisoPosicionVm>{

	@Override
	public BusPisoPosicionVm convert(BusPisoPosicion source) {
		BusPisoPosicionVm busPisoPosicionVm = new BusPisoPosicionVm();	
		//BeanUtils.copyProperties(source, busPisoPosicionVm);
		busPisoPosicionVm.setNumeroFila(source.getNumeroFila());
		busPisoPosicionVm.setNumeroColumna(source.getNumeroColumna());
		busPisoPosicionVm.setIdPosicion(source.getIdPosicion());
		return busPisoPosicionVm;
	}
	

}
