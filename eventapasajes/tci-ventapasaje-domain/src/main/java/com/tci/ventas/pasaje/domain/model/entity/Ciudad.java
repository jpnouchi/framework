package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_ciudad")
public class Ciudad extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ciudad", unique = true, nullable = false)
	private Long idCiudad;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(name = "id_ciudad_legacy", nullable = false)
	private Long idCiudadLegacy;

	@Column(name = "codigo", nullable = false, length = 20)
	private String codigo;

	@Column(name = "nombre", length = 50)
	private String nombre;

	public Long getIdCiudad() {
		return this.idCiudad;
	}

	public void setIdCiudad(Long idCiudad) {
		this.idCiudad = idCiudad;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Long getIdCiudadLegacy() {
		return this.idCiudadLegacy;
	}

	public void setIdCiudadLegacy(Long idCiudadLegacy) {
		this.idCiudadLegacy = idCiudadLegacy;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
