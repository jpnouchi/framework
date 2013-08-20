package com.tci.ventas.pasaje.domain.viewmodel.vo;

import java.io.Serializable;

public class PortalVO implements Serializable{

	private Long idPortal;
	private String descripcion;
	
	public PortalVO(){
		
	}
	
	public PortalVO(Long idPortal) {
		this.idPortal = idPortal;
	}
	public Long getIdPortal() {
		return idPortal;
	}
	public void setIdPortal(Long idPortal) {
		this.idPortal = idPortal;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPortal == null) ? 0 : idPortal.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PortalVO other = (PortalVO) obj;
		if (idPortal == null) {
			if (other.idPortal != null)
				return false;
		} else if (!idPortal.equals(other.idPortal))
			return false;
		return true;
	}
	
	
	
}
