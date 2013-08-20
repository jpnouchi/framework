package com.tci.ventas.pasaje.domain.viewmodel.rsl;

import java.util.Date;


public class ItinerarioRsl {
	private Long idItinerario;
	private Long idItinerarioLegacy;
	private Long idBusLegacy;
	private String origen;
	private String destino;
	private String servicio;
	private Date fechaSalida;
	private Integer numeroAsientoLibre;
	private Double precioPiso1;
	private Double precioPiso2;
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdItinerario() {
		return idItinerario;
	}
	public void setIdItinerario(Long idItinerario) {
		this.idItinerario = idItinerario;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getServicio() {
		return servicio;
	}
	public void setServicio(String servicio) {
		this.servicio = servicio;
	}
	public Date getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public Integer getNumeroAsientoLibre() {
		return numeroAsientoLibre;
	}
	public void setNumeroAsientoLibre(Integer numeroAsientoLibre) {
		this.numeroAsientoLibre = numeroAsientoLibre;
	}
	public Double getPrecioPiso1() {
		return precioPiso1;
	}
	public void setPrecioPiso1(Double precioPiso1) {
		this.precioPiso1 = precioPiso1;
	}
	public Double getPrecioPiso2() {
		return precioPiso2;
	}
	public void setPrecioPiso2(Double precioPiso2) {
		this.precioPiso2 = precioPiso2;
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
	public Long getIdItinerarioLegacy() {
		return idItinerarioLegacy;
	}
	public void setIdItinerarioLegacy(Long idItinerarioLegacy) {
		this.idItinerarioLegacy = idItinerarioLegacy;
	}
	public Long getIdBusLegacy() {
		return idBusLegacy;
	}
	public void setIdBusLegacy(Long idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}
	
	

}
