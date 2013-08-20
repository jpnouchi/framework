package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_pasajero")
public class Pasajero extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_pasajero", unique = true, nullable = false)
	private Long idPasajero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "estado")
	private Integer estado;

	@Column(name = "id_pasajero_legacy")
	private Long idPasajeroLegacy;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pasajero")
	private Set<VentaDetalle> ventaDetalles = new HashSet<VentaDetalle>(0);

	public Long getIdPasajero() {
		return this.idPasajero;
	}

	public void setIdPasajero(Long idPasajero) {
		this.idPasajero = idPasajero;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Long getIdPasajeroLegacy() {
		return this.idPasajeroLegacy;
	}

	public void setIdPasajeroLegacy(Long idPasajeroLegacy) {
		this.idPasajeroLegacy = idPasajeroLegacy;
	}

	public Set<VentaDetalle> getVentaDetalles() {
		return this.ventaDetalles;
	}

	public void setVentaDetalles(Set<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

}
