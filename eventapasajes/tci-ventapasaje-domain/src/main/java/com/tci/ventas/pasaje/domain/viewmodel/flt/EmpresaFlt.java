package com.tci.ventas.pasaje.domain.viewmodel.flt;

import com.tci.domain.viewmodel.FilterBase;

public class EmpresaFlt extends FilterBase {
	
	private Long idEmpresa;
	private Long idEmpresaLegacy;
	private String numeroRuc;
	
	public Long getIdEmpresa() {
		return idEmpresa;
	}
	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	public Long getIdEmpresaLegacy() {
		return idEmpresaLegacy;
	}
	public void setIdEmpresaLegacy(Long idEmpresaLegacy) {
		this.idEmpresaLegacy = idEmpresaLegacy;
	}
	public String getNumeroRuc() {
		return numeroRuc;
	}
	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}
	
}
