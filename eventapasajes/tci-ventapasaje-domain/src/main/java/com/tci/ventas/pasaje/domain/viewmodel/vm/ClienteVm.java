package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class ClienteVm implements Serializable {
	private static final long serialVersionUID = 7526472295622776147L; // unique id
	
	@NotEmpty
	private Long idCliente;
	
	@NotEmpty
	private PersonaVm personaVm;
	
	@NotEmpty
	private String usuario;
	
	@NotEmpty
	private Long idClienteLegacy;
	
	@NotEmpty
	private short activo;
	
	@NotEmpty
	private short estado;

	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;
	
	public Long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}
	public PersonaVm getPersonaVm() {
		return personaVm;
	}
	public void setPersonaVm(PersonaVm personaVm) {
		this.personaVm = personaVm;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Long getIdClienteLegacy() {
		return idClienteLegacy;
	}
	public void setIdClienteLegacy(Long idClienteLegacy) {
		this.idClienteLegacy = idClienteLegacy;
	}
	public short getActivo() {
		return activo;
	}
	public void setActivo(short activo) {
		this.activo = activo;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
