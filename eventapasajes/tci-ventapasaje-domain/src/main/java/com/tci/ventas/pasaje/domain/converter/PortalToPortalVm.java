package com.tci.ventas.pasaje.domain.converter;
/**
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Portal;
import com.tci.ventas.pasaje.domain.viewmodel.vm.PortalVm;

@TypeConverter
public class PortalToPortalVm implements Converter<Portal, PortalVm>{

	@Override
	public PortalVm convert(Portal source) {
		PortalVm portalVm = new PortalVm();	
		BeanUtils.copyProperties(source, portalVm);
		return portalVm;
	}
	

}
**/