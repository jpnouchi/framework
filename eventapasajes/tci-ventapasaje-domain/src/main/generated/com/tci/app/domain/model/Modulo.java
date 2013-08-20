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
@Table(name = "aetm_modulo")
public class Modulo extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_modulo", unique = true, nullable = false)
	private Long idModulo;

	@Column(name = "nombre", length = 100)
	private String nombre;

	@Column(name = "descripcion", length = 200)
	private String descripcion;

	@Column(name = "estado", length = 1)
	private Character estado;

	@Column(name = "id_modulo_padre")
	private Long idModuloPadre;

	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Character getEstado() {
		return this.estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public Long getIdModuloPadre() {
		return this.idModuloPadre;
	}

	public void setIdModuloPadre(Long idModuloPadre) {
		this.idModuloPadre = idModuloPadre;
	}

}
