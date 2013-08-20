package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

public class BusPisoPosicionObjetoVm implements Serializable {
	
	private BusPisoPosicionObjetoIdVm id;
	private ObjetoVm objeto;
	private String etiqueta;
	private short estado;

	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	
	public ObjetoVm getObjeto() {
		return objeto;
	}
	public void setObjeto(ObjetoVm objeto) {
		this.objeto = objeto;
	}
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public short getEstado() {
		return estado;
	}
	public void setEstado(short estado) {
		this.estado = estado;
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
	public BusPisoPosicionObjetoIdVm getId() {
		return id;
	}
	public void setId(BusPisoPosicionObjetoIdVm id) {
		this.id = id;
	}
	
	
	
}
