package com.tci.ventas.pasaje.domain.model;

// Generated 09/07/2013 10:54:38 AM by Hibernate Tools 4.0.0

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author TCI
 * @date   09/07/2013
 */
@Entity
@Table(name = "t_auditor")
public class TAuditor extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "APMATERNO", length = 50)
	private String apmaterno;

	@Column(name = "APPATERNO", length = 50)
	private String appaterno;

	@Column(name = "LOGIN", length = 100)
	private String login;

	@Column(name = "NOMBRES", length = 50)
	private String nombres;

	@Column(name = "ORDEN")
	private Integer orden;

	@Column(name = "ENTIDAD_ID")
	private Long entidadId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApmaterno() {
		return this.apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}

	public String getAppaterno() {
		return this.appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Long getEntidadId() {
		return this.entidadId;
	}

	public void setEntidadId(Long entidadId) {
		this.entidadId = entidadId;
	}

}
