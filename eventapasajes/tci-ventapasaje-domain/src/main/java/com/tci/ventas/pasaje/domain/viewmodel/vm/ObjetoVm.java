package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

public class ObjetoVm implements Serializable {
	
	private Long idObjeto;
	private String codigo;
	private String descripcion;
	private String imagen;
	private short estado;

	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Long idObjeto) {
		this.idObjeto = idObjeto;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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

}
