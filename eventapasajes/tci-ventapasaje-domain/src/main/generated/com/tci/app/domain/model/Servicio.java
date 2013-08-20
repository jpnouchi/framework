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
@Table(name = "aetm_servicio")
public class Servicio extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_servicio", unique = true, nullable = false)
	private Integer idServicio;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	public Integer getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
