package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tci.ventas.pasaje.domain.model.entity.BusPiso;

public class BusPisoPosicionVm implements Serializable {
	
	private Long idPosicion;
	private BusPiso busPiso;
	private Integer numeroFila;
	private Integer numeroColumna;
	private short estado;
	//private Set<BusPisoPosicionObjetoVm> busPisoPosicionObjetos = new HashSet<BusPisoPosicionObjetoVm>(0);
	private List<BusPisoPosicionObjetoVm> busPisoPosicionObjetos = new ArrayList<BusPisoPosicionObjetoVm>(0);
	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdPosicion() {
		return idPosicion;
	}
	public void setIdPosicion(Long idPosicion) {
		this.idPosicion = idPosicion;
	}
	public BusPiso getBusPiso() {
		return busPiso;
	}
	public void setBusPiso(BusPiso busPiso) {
		this.busPiso = busPiso;
	}
	public Integer getNumeroFila() {
		return numeroFila;
	}
	public void setNumeroFila(Integer numeroFila) {
		this.numeroFila = numeroFila;
	}
	public Integer getNumeroColumna() {
		return numeroColumna;
	}
	public void setNumeroColumna(Integer numeroColumna) {
		this.numeroColumna = numeroColumna;
	}
	public short getEstado() {
		return estado;
	}
	public void setEstado(short estado) {
		this.estado = estado;
	}
//	public Set<BusPisoPosicionObjetoVm> getBusPisoPosicionObjetos() {
//		return busPisoPosicionObjetos;
//	}
//	public void setBusPisoPosicionObjetos(
//			Set<BusPisoPosicionObjetoVm> busPisoPosicionObjetos) {
//		this.busPisoPosicionObjetos = busPisoPosicionObjetos;
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
	public List<BusPisoPosicionObjetoVm> getBusPisoPosicionObjetos() {
		return busPisoPosicionObjetos;
	}
	public void setBusPisoPosicionObjetos(
			List<BusPisoPosicionObjetoVm> busPisoPosicionObjetos) {
		this.busPisoPosicionObjetos = busPisoPosicionObjetos;
	}
	


}
