package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Objeto;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ObjetoVm;

@TypeConverter
public class ObjetoToObjetoVm implements Converter<Objeto, ObjetoVm>{

	@Override
	public ObjetoVm convert(Objeto source) {
		ObjetoVm objetoVm = new ObjetoVm();	
		BeanUtils.copyProperties(source, objetoVm);
		return objetoVm;
	}
	

}
