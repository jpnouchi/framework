package com.tci.ventas.pasaje.domain.viewmodel.flt;

import com.tci.domain.viewmodel.FilterBase;

public class EmpresaConfiguracionFlt extends FilterBase {

	private String ruc;
	private String nombreTabla;
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getNombreTabla() {
		return nombreTabla;
	}
	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}
	
	
	
}
