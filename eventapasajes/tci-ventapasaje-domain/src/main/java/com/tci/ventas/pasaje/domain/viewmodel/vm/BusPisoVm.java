package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusPisoVm implements Serializable {
	
	private Long idPiso;
	private Integer totalNumeroFila;
	private Integer totalNumeroColumna;
	private short estado;
	//private Set<BusPisoPosicionVm> busPisoPosicions = new HashSet<BusPisoPosicionVm>(0);
	private List<BusPisoPosicionVm> busPisoPosicions = new ArrayList<BusPisoPosicionVm>(0);
	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	public Long getIdPiso() {
		return idPiso;
	}
	public void setIdPiso(Long idPiso) {
		this.idPiso = idPiso;
	}
	public Integer getTotalNumeroFila() {
		return totalNumeroFila;
	}
	public void setTotalNumeroFila(Integer totalNumeroFila) {
		this.totalNumeroFila = totalNumeroFila;
	}
	public Integer getTotalNumeroColumna() {
		return totalNumeroColumna;
	}
	public void setTotalNumeroColumna(Integer totalNumeroColumna) {
		this.totalNumeroColumna = totalNumeroColumna;
	}
	public short getEstado() {
		return estado;
	}
	public void setEstado(short estado) {
		this.estado = estado;
	}
//	public Set<BusPisoPosicionVm> getBusPisoPosicions() {
//		return busPisoPosicions;
//	}
//	public void setBusPisoPosicions(Set<BusPisoPosicionVm> busPisoPosicions) {
//		this.busPisoPosicions = busPisoPosicions;
//	}
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
	
	public List<BusPisoPosicionVm> getBusPisoPosicions() {
		return busPisoPosicions;
	}
	public void setBusPisoPosicions(List<BusPisoPosicionVm> busPisoPosicions) {
		this.busPisoPosicions = busPisoPosicions;
	}
		

}
