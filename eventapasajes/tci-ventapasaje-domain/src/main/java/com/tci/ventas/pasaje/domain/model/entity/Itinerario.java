package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.tci.domain.model.JpaEntityBase;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptr_itinerario")
public class Itinerario extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_itinerario", unique = true, nullable = false)
	private Long idItinerario;

	@Column(name = "id_bus_legacy", nullable = false)
	private Long idBusLegacy;

	@Column(name = "id_empresa_legacy", nullable = false)
	private Long idEmpresaLegacy;

	@Column(name = "id_itinerario_legacy", nullable = false)
	private Long idItinerarioLegacy;

	@Column(name = "id_servicio_legacy", nullable = false)
	private Long idServicioLegacy;

	@Column(name = "id_tramo_legacy", nullable = false)
	private Long idTramoLegacy;

	@Column(name = "id_ciudad_origen_legacy", nullable = false)
	private Long idCiudadOrigenLegacy;

	@Column(name = "id_ciudad_destino_legacy", nullable = false)
	private Long idCiudadDestinoLegacy;

	@Column(name = "origen", nullable = false, length = 50)
	private String origen;

	@Column(name = "destino", nullable = false, length = 50)
	private String destino;

	@Column(name = "servicio", nullable = false, length = 20)
	private String servicio;

	@Column(name = "numero_asiento_libre", nullable = false)
	private Integer numeroAsientoLibre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_salida", nullable = false, length = 19)
	private Date fechaSalida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_llegada", nullable = false, length = 19)
	private Date fechaLlegada;

	@Column(name = "precio_piso1", nullable = false, precision = 5)
	private Double precioPiso1;

	@Column(name = "precio_piso2", nullable = false, precision = 5)
	private Double precioPiso2;

	public Long getIdItinerario() {
		return this.idItinerario;
	}

	public void setIdItinerario(Long idItinerario) {
		this.idItinerario = idItinerario;
	}

	public Long getIdBusLegacy() {
		return this.idBusLegacy;
	}

	public void setIdBusLegacy(Long idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}

	public Long getIdEmpresaLegacy() {
		return this.idEmpresaLegacy;
	}

	public void setIdEmpresaLegacy(Long idEmpresaLegacy) {
		this.idEmpresaLegacy = idEmpresaLegacy;
	}

	public Long getIdItinerarioLegacy() {
		return this.idItinerarioLegacy;
	}

	public void setIdItinerarioLegacy(Long idItinerarioLegacy) {
		this.idItinerarioLegacy = idItinerarioLegacy;
	}

	public Long getIdServicioLegacy() {
		return this.idServicioLegacy;
	}

	public void setIdServicioLegacy(Long idServicioLegacy) {
		this.idServicioLegacy = idServicioLegacy;
	}

	public Long getIdTramoLegacy() {
		return this.idTramoLegacy;
	}

	public void setIdTramoLegacy(Long idTramoLegacy) {
		this.idTramoLegacy = idTramoLegacy;
	}

	public Long getIdCiudadOrigenLegacy() {
		return this.idCiudadOrigenLegacy;
	}

	public void setIdCiudadOrigenLegacy(Long idCiudadOrigenLegacy) {
		this.idCiudadOrigenLegacy = idCiudadOrigenLegacy;
	}

	public Long getIdCiudadDestinoLegacy() {
		return this.idCiudadDestinoLegacy;
	}

	public void setIdCiudadDestinoLegacy(Long idCiudadDestinoLegacy) {
		this.idCiudadDestinoLegacy = idCiudadDestinoLegacy;
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

	public String getServicio() {
		return this.servicio;
	}

	public void setServicio(String servicio) {
		this.servicio = servicio;
	}

	public Integer getNumeroAsientoLibre() {
		return this.numeroAsientoLibre;
	}

	public void setNumeroAsientoLibre(Integer numeroAsientoLibre) {
		this.numeroAsientoLibre = numeroAsientoLibre;
	}

	public Date getFechaSalida() {
		return this.fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return this.fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public Double getPrecioPiso1() {
		return this.precioPiso1;
	}

	public void setPrecioPiso1(Double precioPiso1) {
		this.precioPiso1 = precioPiso1;
	}

	public Double getPrecioPiso2() {
		return this.precioPiso2;
	}

	public void setPrecioPiso2(Double precioPiso2) {
		this.precioPiso2 = precioPiso2;
	}

}
