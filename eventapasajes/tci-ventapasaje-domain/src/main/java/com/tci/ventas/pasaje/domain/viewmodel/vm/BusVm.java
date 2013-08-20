package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class BusVm implements Serializable {
	
	private Long idBus;
	private String marca;
	private String modelo;
	private String descripcion;
	private Long idBusLegacy;
	private short estado;
	//private Set<BusPisoVm> busPisos = new HashSet<BusPisoVm>(0);
	private List<BusPisoVm> busPisos = new ArrayList<BusPisoVm>(0);
	
	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdBus() {
		return idBus;
	}
	public void setIdBus(Long idBus) {
		this.idBus = idBus;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Long getIdBusLegacy() {
		return idBusLegacy;
	}
	public void setIdBusLegacy(Long idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}
	public short getEstado() {
		return estado;
	}
	public void setEstado(short estado) {
		this.estado = estado;
	}
//	public Set<BusPisoVm> getBusPisos() {
//		return busPisos;
//	}
//	public void setBusPisos(Set<BusPisoVm> busPisos) {
//		this.busPisos = busPisos;
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
	public List<BusPisoVm> getBusPisos() {
		return busPisos;
	}
	public void setBusPisos(List<BusPisoVm> busPisos) {
		this.busPisos = busPisos;
	}


}
