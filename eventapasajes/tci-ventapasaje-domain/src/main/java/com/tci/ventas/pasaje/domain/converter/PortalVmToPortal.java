package com.tci.ventas.pasaje.domain.converter;
/**
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

import com.tci.domain.stereotype.TypeConverter;
import com.tci.ventas.pasaje.domain.model.entity.Portal;
import com.tci.ventas.pasaje.domain.viewmodel.vm.PortalVm;

@TypeConverter
public class PortalVmToPortal implements Converter<PortalVm, Portal> {

	@Override
	public Portal convert(PortalVm source) {
		Portal portal = new Portal();
		BeanUtils.copyProperties(source, portal);
		return portal;
	}

}
**/