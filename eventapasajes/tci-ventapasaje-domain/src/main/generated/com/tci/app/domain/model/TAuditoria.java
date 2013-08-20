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
@Table(name = "t_auditoria")
public class TAuditoria extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "ACCION", length = 50)
	private String accion;

	@Column(name = "DESCRIPCION", length = 1000)
	private String descripcion;

	@Column(name = "ENTIDAD_ID")
	private Long entidadId;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccion() {
		return this.accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getEntidadId() {
		return this.entidadId;
	}

	public void setEntidadId(Long entidadId) {
		this.entidadId = entidadId;
	}

}
