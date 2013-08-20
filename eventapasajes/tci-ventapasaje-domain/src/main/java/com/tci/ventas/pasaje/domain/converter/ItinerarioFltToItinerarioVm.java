package com.tci.ventas.pasaje.domain.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ItinerarioVm;

@TypeConverter
public class ItinerarioFltToItinerarioVm implements Converter<ItinerarioFlt, ItinerarioVm>{

	@Override
	public ItinerarioVm convert(ItinerarioFlt source) {
		ItinerarioVm itinerarioVm = new ItinerarioVm();	
		BeanUtils.copyProperties(source, itinerarioVm);
		return itinerarioVm;
	}
	

}
