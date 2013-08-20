package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_persona")
public class Persona extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_persona", unique = true, nullable = false)
	private Long idPersona;

	@Column(name = "numero_documento", nullable = false, length = 20)
	private String numeroDocumento;

	@Column(name = "sexo", nullable = false, length = 2, columnDefinition = "char")
	private String sexo;

	@Column(name = "tipo_documento", nullable = false, length = 5, columnDefinition = "char")
	private String tipoDocumento;

	@Column(name = "estado_civil", nullable = false, length = 2, columnDefinition = "char")
	private String estadoCivil;

	@Column(name = "nombres", nullable = false, length = 50)
	private String nombres;

	@Column(name = "apellido_paterno", nullable = false, length = 50)
	private String apellidoPaterno;

	@Column(name = "apellido_materno", nullable = false, length = 50)
	private String apellidoMaterno;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento", length = 19)
	private Date fechaNacimiento;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private Set<PersonaEmpresa> personaEmpresas = new HashSet<PersonaEmpresa>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private Set<Pasajero> pasajeros = new HashSet<Pasajero>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
	private Set<Cliente> clientes = new HashSet<Cliente>(0);

	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public String getNumeroDocumento() {
		return this.numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return this.apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return this.apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Set<PersonaEmpresa> getPersonaEmpresas() {
		return this.personaEmpresas;
	}

	public void setPersonaEmpresas(Set<PersonaEmpresa> personaEmpresas) {
		this.personaEmpresas = personaEmpresas;
	}

	public Set<Pasajero> getPasajeros() {
		return this.pasajeros;
	}

	public void setPasajeros(Set<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}

	public Set<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}

}
