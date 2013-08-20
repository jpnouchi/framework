package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_control")
public class Control extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_control", unique = true, nullable = false)
	private Long idControl;

	@Column(name = "usuario", nullable = false, length = 50)
	private String usuario;

	@Column(name = "sesion_id", nullable = false, length = 100)
	private String sesionId;

	@Column(name = "direccion_ip", nullable = false, length = 20)
	private String direccionIp;

	public Long getIdControl() {
		return this.idControl;
	}

	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSesionId() {
		return this.sesionId;
	}

	public void setSesionId(String sesionId) {
		this.sesionId = sesionId;
	}

	public String getDireccionIp() {
		return this.direccionIp;
	}

	public void setDireccionIp(String direccionIp) {
		this.direccionIp = direccionIp;
	}

}
