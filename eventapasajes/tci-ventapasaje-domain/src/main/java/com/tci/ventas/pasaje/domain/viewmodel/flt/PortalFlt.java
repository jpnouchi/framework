package com.tci.ventas.pasaje.domain.viewmodel.flt;

import java.util.ArrayList;
import java.util.List;

import com.tci.domain.viewmodel.FilterBase;
import com.tci.domain.viewmodel.FiltersBean;
import com.tci.domain.viewmodel.LabelValueBean;

public class PortalFlt extends FilterBase {
	private String descripcion;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public FiltersBean getFiltersBean() {
		List<LabelValueBean> principal = new ArrayList<LabelValueBean>();
		List<LabelValueBean> advanced = new ArrayList<LabelValueBean>();

		principal.add(new LabelValueBean("label_descripcion_portal", descripcion));

		return new FiltersBean(principal, advanced);
	}
}
