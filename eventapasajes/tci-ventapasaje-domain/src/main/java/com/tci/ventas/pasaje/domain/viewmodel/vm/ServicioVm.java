package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

public class ServicioVm implements Serializable {
	
	private Long idServicio;
	private Long idServicioLegacy;
	private String nombreServicio;
	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	public Long getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(Long idServicio) {
		this.idServicio = idServicio;
	}
	public Long getIdServicioLegacy() {
		return idServicioLegacy;
	}
	public void setIdServicioLegacy(Long idServicioLegacy) {
		this.idServicioLegacy = idServicioLegacy;
	}
	public String getNombreServicio() {
		return nombreServicio;
	}
	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}
	public String getCreadoPor() {
		return creadoPor;
	}
	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idServicio == null) ? 0 : idServicio.hashCode());
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
		ServicioVm other = (ServicioVm) obj;
		if (idServicio == null) {
			if (other.idServicio != null)
				return false;
		} else if (!idServicio.equals(other.idServicio))
			return false;
		return true;
	}


}
