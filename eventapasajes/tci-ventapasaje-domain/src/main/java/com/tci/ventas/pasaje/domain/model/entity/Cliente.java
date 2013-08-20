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
@Table(name = "vptm_cliente")
public class Cliente extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_cliente", unique = true, nullable = false)
	private Long idCliente;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false)
	private Persona persona;

	@Column(name = "usuario", nullable = false, length = 50)
	private String usuario;

	@Column(name = "id_cliente_legacy")
	private Long idClienteLegacy;

	@Column(name = "activo")
	private Short activo;

	@Column(name = "estado")
	private Short estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<ClienteRutaDeseada> clienteRutaDeseadas = new HashSet<ClienteRutaDeseada>(
			0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<VentaOnline> ventaOnlines = new HashSet<VentaOnline>(0);

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getIdClienteLegacy() {
		return this.idClienteLegacy;
	}

	public void setIdClienteLegacy(Long idClienteLegacy) {
		this.idClienteLegacy = idClienteLegacy;
	}

	public Short getActivo() {
		return this.activo;
	}

	public void setActivo(Short activo) {
		this.activo = activo;
	}

	public Short getEstado() {
		return this.estado;
	}

	public void setEstado(Short estado) {
		this.estado = estado;
	}

	public Set<ClienteRutaDeseada> getClienteRutaDeseadas() {
		return this.clienteRutaDeseadas;
	}

	public void setClienteRutaDeseadas(
			Set<ClienteRutaDeseada> clienteRutaDeseadas) {
		this.clienteRutaDeseadas = clienteRutaDeseadas;
	}

	public Set<VentaOnline> getVentaOnlines() {
		return this.ventaOnlines;
	}

	public void setVentaOnlines(Set<VentaOnline> ventaOnlines) {
		this.ventaOnlines = ventaOnlines;
	}

}
