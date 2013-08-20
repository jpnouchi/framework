package com.tci.ventas.pasaje.domain.model;

// Generated 08/07/2013 06:32:39 PM by Hibernate Tools 4.0.0

import com.tci.domain.model.JpaEntityBase;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author TCI
 * @date   08/07/2013
 */
@Entity
@Table(name = "aetm_viaje")
public class Viaje extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_viaje", unique = true, nullable = false)
	private Integer idViaje;

	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_hora", nullable = false, length = 19)
	private Date fechaHora;

	@Column(name = "id_servicio")
	private Integer idServicio;

	@Column(name = "asientos_nbr")
	private Integer asientosNbr;

	@Column(name = "origen", nullable = false, length = 20)
	private String origen;

	@Column(name = "destino", nullable = false, length = 20)
	private String destino;

	public Integer getIdViaje() {
		return this.idViaje;
	}

	public void setIdViaje(Integer idViaje) {
		this.idViaje = idViaje;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaHora() {
		return this.fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public Integer getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(Integer idServicio) {
		this.idServicio = idServicio;
	}

	public Integer getAsientosNbr() {
		return this.asientosNbr;
	}

	public void setAsientosNbr(Integer asientosNbr) {
		this.asientosNbr = asientosNbr;
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

}
