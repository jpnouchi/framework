package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class PersonaVm implements Serializable{
	private static final long serialVersionUID = 7526472295622776148L; // unique id
	
	@NotEmpty
	private Integer idPersona;
	
	@NotEmpty
	private String numeroDocumento;
	
	@NotEmpty
	private char sexo;
	
	@NotEmpty
	private char tipoDocumento;
	
	private char estadoCivil;
	
	@NotEmpty
	private String nombres;
	
	@NotEmpty
	private String apellidoPaterno;
	
	@NotEmpty
	private String apellidoMaterno;
	
	private String direccion;
	private Date fechaNacimiento;
	
	private String telefono;
	private String creadopor;
	private String modificadoPor;
	private Date fechaCreacion;
	private Date fechaModificacion;
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public char getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(char tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public char getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(char estadoCivil) {
		this.estadoCivil = estadoCivil;
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
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCreadopor() {
		return creadopor;
	}
	public void setCreadopor(String creadopor) {
		this.creadopor = creadopor;
	}
	public String getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(String modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaModificacion() {
		return fechaModificacion;
	}
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	
	
}
