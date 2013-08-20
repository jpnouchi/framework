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
@Table(name = "aetm_ventana")
public class Ventana extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ventana", unique = true, nullable = false)
	private Long idVentana;

	@Column(name = "nombre", length = 100)
	private String nombre;

	@Column(name = "estado", length = 1)
	private Character estado;

	@Column(name = "url", length = 100)
	private String url;

	@Column(name = "orden")
	private Long orden;

	@Column(name = "descripcion", length = 200)
	private String descripcion;

	@Column(name = "id_modulo")
	private Long idModulo;

	public Long getIdVentana() {
		return this.idVentana;
	}

	public void setIdVentana(Long idVentana) {
		this.idVentana = idVentana;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Character getEstado() {
		return this.estado;
	}

	public void setEstado(Character estado) {
		this.estado = estado;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getOrden() {
		return this.orden;
	}

	public void setOrden(Long orden) {
		this.orden = orden;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdModulo() {
		return this.idModulo;
	}

	public void setIdModulo(Long idModulo) {
		this.idModulo = idModulo;
	}

}
