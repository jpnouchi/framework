package com.tci.ventas.pasaje.domain.model;

// Generated 08/07/2013 06:32:39 PM by Hibernate Tools 4.0.0

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TCI
 * @date   08/07/2013
 */
@Entity
@Table(name = "aetm_pasaje")
public class Pasaje extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_pasaje", unique = true, nullable = false)
	private Long idPasaje;

	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	@Column(name = "apellido_paterno", nullable = false, length = 25)
	private String apellidoPaterno;

	@Column(name = "apellido_materno", nullable = false, length = 25)
	private String apellidoMaterno;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Column(name = "asiento_num", nullable = false)
	private int asientoNum;

	@Column(name = "id_menu", nullable = false, length = 2)
	private String idMenu;

	@Column(name = "id_servicio", nullable = false, length = 2)
	private String idServicio;

	@Column(name = "id_viaje", nullable = false)
	private long idViaje;

	@Column(name = "sexo", length = 1)
	private Character sexo;

	@Column(name = "edad", nullable = false)
	private int edad;

	public Long getIdPasaje() {
		return this.idPasaje;
	}

	public void setIdPasaje(Long idPasaje) {
		this.idPasaje = idPasaje;
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

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getAsientoNum() {
		return this.asientoNum;
	}

	public void setAsientoNum(int asientoNum) {
		this.asientoNum = asientoNum;
	}

	public String getIdMenu() {
		return this.idMenu;
	}

	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
	}

	public String getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public long getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(long idViaje) {
		this.idViaje = idViaje;
	}

	public Character getSexo() {
		return this.sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}
