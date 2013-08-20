package com.tci.ventas.pasaje.domain.model;

// Generated 08/07/2013 06:32:39 PM by Hibernate Tools 4.0.0

import com.tci.domain.model.JpaEntityBase;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author TCI
 * @date   08/07/2013
 */
@Entity
@Table(name = "aetm_chofer")
public class Chofer extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_chofer", unique = true, nullable = false)
	private Long idChofer;

	@Column(name = "licencia", nullable = false, length = 9)
	private String licencia;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellido_paterno", nullable = false, length = 50)
	private String apellidoPaterno;

	@Column(name = "apellido_materno", nullable = false, length = 50)
	private String apellidoMaterno;

	@Column(name = "sexo", nullable = false, length = 1)
	private char sexo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_nacimiento", nullable = false, length = 19)
	private Date fechaNacimiento;

	@Column(name = "direccion", length = 50)
	private String direccion;

	@Column(name = "pais")
	private Integer pais;

	@Column(name = "ciudad")
	private Integer ciudad;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "email", length = 30)
	private String email;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_expiracion", length = 19)
	private Date fechaExpiracion;

	public Long getIdChofer() {
		return this.idChofer;
	}

	public void setIdChofer(Long idChofer) {
		this.idChofer = idChofer;
	}

	public String getLicencia() {
		return this.licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getPais() {
		return this.pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Integer getCiudad() {
		return this.ciudad;
	}

	public void setCiudad(Integer ciudad) {
		this.ciudad = ciudad;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaExpiracion() {
		return this.fechaExpiracion;
	}

	public void setFechaExpiracion(Date fechaExpiracion) {
		this.fechaExpiracion = fechaExpiracion;
	}

}
