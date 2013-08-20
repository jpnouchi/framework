package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.BusPisoPosicionObjeto;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionObjetoVm;

@TypeConverter
public class BusPisoPosicionObjetoToBusPisoPosicionObjetoVm implements Converter<BusPisoPosicionObjeto, BusPisoPosicionObjetoVm>{

	@Override
	public BusPisoPosicionObjetoVm convert(BusPisoPosicionObjeto source) {
		BusPisoPosicionObjetoVm busPisoPosicionObjetoVm = new BusPisoPosicionObjetoVm();	
		BeanUtils.copyProperties(source, busPisoPosicionObjetoVm);
		return busPisoPosicionObjetoVm;
	}
	

}
