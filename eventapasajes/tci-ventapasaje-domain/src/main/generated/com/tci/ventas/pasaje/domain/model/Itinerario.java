package com.tci.ventas.pasaje.domain.model;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

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
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptr_itinerario")
public class Itinerario extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_itinerario", unique = true, nullable = false)
	private Integer idItinerario;

	@Column(name = "id_bus_legacy", nullable = false)
	private int idBusLegacy;

	@Column(name = "id_empresa_legacy", nullable = false)
	private int idEmpresaLegacy;

	@Column(name = "id_itinerario_legacy", nullable = false)
	private int idItinerarioLegacy;

	@Column(name = "id_servicio_legacy", nullable = false)
	private int idServicioLegacy;

	@Column(name = "id_tramo_legacy", nullable = false)
	private int idTramoLegacy;

	@Column(name = "id_ciudad_origen_legacy", nullable = false)
	private int idCiudadOrigenLegacy;

	@Column(name = "id_ciudad_destino_legacy", nullable = false)
	private int idCiudadDestinoLegacy;

	@Column(name = "origen", nullable = false, length = 50)
	private String origen;

	@Column(name = "destino", nullable = false, length = 50)
	private String destino;

	@Column(name = "servicio", nullable = false, length = 20)
	private String servicio;

	@Column(name = "numero_asiento_libre", nullable = false)
	private int numeroAsientoLibre;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_salida", nullable = false, length = 19)
	private Date fechaSalida;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_llegada", nullable = false, length = 19)
	private Date fechaLlegada;

	@Column(name = "precio_piso1", nullable = false, precision = 5)
	private double precioPiso1;

	@Column(name = "precio_piso2", nullable = false, precision = 5)
	private double precioPiso2;

	public Integer getIdItinerario() {
		return this.idItinerario;
	}

	public void setIdItinerario(Integer idItinerario) {
		this.idItinerario = idItinerario;
	}

	public int getIdBusLegacy() {
		return this.idBusLegacy;
	}

	public void setIdBusLegacy(int idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}

	public int getIdEmpresaLegacy() {
		return this.idEmpresaLegacy;
	}

	public void setIdEmpresaLegacy(int idEmpresaLegacy) {
		this.idEmpresaLegacy = idEmpresaLegacy;
	}

	public int getIdItinerarioLegacy() {
		return this.idItinerarioLegacy;
	}

	public void setIdItinerarioLegacy(int idItinerarioLegacy) {
		this.idItinerarioLegacy = idItinerarioLegacy;
	}

	public int getIdServicioLegacy() {
		return this.idServicioLegacy;
	}

	public void setIdServicioLegacy(int idServicioLegacy) {
		this.idServicioLegacy = idServicioLegacy;
	}

	public int getIdTramoLegacy() {
		return this.idTramoLegacy;
	}

	public void setIdTramoLegacy(int idTramoLegacy) {
		this.idTramoLegacy = idTramoLegacy;
	}

	public int getIdCiudadOrigenLegacy() {
		return this.idCiudadOrigenLegacy;
	}

	public void setIdCiudadOrigenLegacy(int idCiudadOrigenLegacy) {
		this.idCiudadOrigenLegacy = idCiudadOrigenLegacy;
	}

	public int getIdCiudadDestinoLegacy() {
		return this.idCiudadDestinoLegacy;
	}

	public void setIdCiudadDestinoLegacy(int idCiudadDestinoLegacy) {
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

	public int getNumeroAsientoLibre() {
		return this.numeroAsientoLibre;
	}

	public void setNumeroAsientoLibre(int numeroAsientoLibre) {
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

	public double getPrecioPiso1() {
		return this.precioPiso1;
	}

	public void setPrecioPiso1(double precioPiso1) {
		this.precioPiso1 = precioPiso1;
	}

	public double getPrecioPiso2() {
		return this.precioPiso2;
	}

	public void setPrecioPiso2(double precioPiso2) {
		this.precioPiso2 = precioPiso2;
	}

}
