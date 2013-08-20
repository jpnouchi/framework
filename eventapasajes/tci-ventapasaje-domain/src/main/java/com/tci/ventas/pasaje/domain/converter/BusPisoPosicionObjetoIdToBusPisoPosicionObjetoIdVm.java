package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.BusPisoPosicionObjetoId;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionObjetoIdVm;

@TypeConverter
public class BusPisoPosicionObjetoIdToBusPisoPosicionObjetoIdVm implements Converter<BusPisoPosicionObjetoId, BusPisoPosicionObjetoIdVm>{

	@Override
	public BusPisoPosicionObjetoIdVm convert(BusPisoPosicionObjetoId source) {
		BusPisoPosicionObjetoIdVm busPisoPosicionObjetoIdVm = new BusPisoPosicionObjetoIdVm();	
		BeanUtils.copyProperties(source, busPisoPosicionObjetoIdVm);
		return busPisoPosicionObjetoIdVm;
	}
	

}
