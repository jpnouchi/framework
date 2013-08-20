package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

public class ItinerarioVm implements Serializable {


	private Long idCiudadOrigenLegacy;

	private Long idCiudadDestinoLegacy;
	
	private Long idServicioLegacy;
	
	private Date fechaSalida;
	
	private Date fechaRetorno;
	private String opcionViaje;

	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdCiudadOrigenLegacy() {
		return idCiudadOrigenLegacy;
	}
	public void setIdCiudadOrigenLegacy(Long idCiudadOrigenLegacy) {
		this.idCiudadOrigenLegacy = idCiudadOrigenLegacy;
	}
	public Long getIdCiudadDestinoLegacy() {
		return idCiudadDestinoLegacy;
	}
	public void setIdCiudadDestinoLegacy(Long idCiudadDestinoLegacy) {
		this.idCiudadDestinoLegacy = idCiudadDestinoLegacy;
	}
	public Long getIdServicioLegacy() {
		return idServicioLegacy;
	}
	public void setIdServicioLegacy(Long idServicioLegacy) {
		this.idServicioLegacy = idServicioLegacy;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Date getFechaRetorno() {
		return fechaRetorno;
	}
	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}
	public String getOpcionViaje() {
		return opcionViaje;
	}
	public void setOpcionViaje(String opcionViaje) {
		this.opcionViaje = opcionViaje;
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

	
	


}
