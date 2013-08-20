package com.tci.ventas.pasaje.domain.model;

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
@Table(name = "vptd_cliente_ruta_deseada")
public class ClienteRutaDeseada extends JpaEntityBase implements
		java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_ruta_deseada", unique = true, nullable = false)
	private Integer idRutaDeseada;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Column(name = "origen", nullable = false, length = 50)
	private String origen;

	@Column(name = "destino", nullable = false, length = 50)
	private String destino;

	@Column(name = "servicio", nullable = false)
	private int servicio;

	@Column(name = "estado")
	private Integer estado;

	public Integer getIdRutaDeseada() {
		return this.idRutaDeseada;
	}

	public void setIdRutaDeseada(Integer idRutaDeseada) {
		this.idRutaDeseada = idRutaDeseada;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getOrigen() {
		return this.origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return this.destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public int getServicio() {
		return this.servicio;
	}

	public void setServicio(int servicio) {
		this.servicio = servicio;
	}

	public Integer getEstado() {
		return this.estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

}
