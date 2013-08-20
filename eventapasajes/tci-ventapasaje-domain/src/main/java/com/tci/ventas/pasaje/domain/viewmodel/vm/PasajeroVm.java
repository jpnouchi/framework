package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class PasajeroVm implements Serializable {
	
	private Long idPasajero;
	@NotEmpty
	private String tipoDocumento;
	@NotEmpty
	private String numeroDocumento;
	@NotEmpty
	private String email;
	@NotEmpty
	private String nombres;
	@NotEmpty
	private String apellidoPaterno;
	@NotEmpty
	private String apellidoMaterno;
	
	private boolean pasajeroMismoCliente;
	
	private String creadoPor;
	
	private Date fechaCreacion;
	
	private String modificadoPor;
	
	private Date fechaModificacion;
	

	public Long getIdPasajero() {
		return idPasajero;
	}
	public void setIdPasajero(Long idPasajero) {
		this.idPasajero = idPasajero;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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
	

	public boolean isPasajeroMismoCliente() {
		return pasajeroMismoCliente;
	}
	public void setPasajeroMismoCliente(boolean pasajeroMismoCliente) {
		this.pasajeroMismoCliente = pasajeroMismoCliente;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idPasajero == null) ? 0 : idPasajero.hashCode());
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
		PasajeroVm other = (PasajeroVm) obj;
		if (idPasajero == null) {
			if (other.idPasajero != null)
				return false;
		} else if (!idPasajero.equals(other.idPasajero))
			return false;
		return true;
	}

	
	

}
