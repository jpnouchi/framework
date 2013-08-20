package com.tci.ventas.pasaje.domain.viewmodel.flt;

import java.util.ArrayList;
import java.util.List;

import com.tci.domain.viewmodel.FilterBase;
import com.tci.domain.viewmodel.FiltersBean;
import com.tci.domain.viewmodel.LabelValueBean;

public class ClienteFlt extends FilterBase {
	private Long idCliente;

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public FiltersBean getFiltersBean() {
		List<LabelValueBean> principal = new ArrayList<LabelValueBean>();
		List<LabelValueBean> advanced = new ArrayList<LabelValueBean>();
		
		principal.add(new LabelValueBean("label_descripcion_portal", idCliente.toString()));
		
		return new FiltersBean(principal, advanced);
	}
}
