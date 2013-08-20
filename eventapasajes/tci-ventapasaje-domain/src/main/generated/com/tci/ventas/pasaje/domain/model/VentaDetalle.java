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
@Table(name = "vptd_venta_detalle")
public class VentaDetalle extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_venta_detalle", unique = true, nullable = false)
	private Integer idVentaDetalle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_pasajero", nullable = false)
	private Pasajero pasajero;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta", nullable = false)
	private VentaOnline ventaOnline;

	@Column(name = "id_venta_legacy")
	private Integer idVentaLegacy;

	@Column(name = "numero_boleto", length = 20)
	private String numeroBoleto;

	@Column(name = "asiento_fila", nullable = false)
	private int asientoFila;

	@Column(name = "asiento_columna", nullable = false)
	private int asientoColumna;

	@Column(name = "asiento_etiqueta", nullable = false, length = 10)
	private String asientoEtiqueta;

	@Column(name = "preferencia_viaje", nullable = false)
	private int preferenciaViaje;

	@Column(name = "id_itinerario", nullable = false)
	private int idItinerario;

	@Column(name = "id_pasajero_legacy", nullable = false)
	private int idPasajeroLegacy;

	@Column(name = "nombre_apellido_pasajero", nullable = false, length = 100)
	private String nombreApellidoPasajero;

	@Column(name = "tipo_documento_pasajero", nullable = false, length = 50)
	private String tipoDocumentoPasajero;

	@Column(name = "numero_documento_pasajero", nullable = false, length = 50)
	private String numeroDocumentoPasajero;

	@Column(name = "origen", nullable = false, length = 50)
	private String origen;

	@Column(name = "destino", nullable = false, length = 50)
	private String destino;

	@Column(name = "servicio", nullable = false, length = 20)
	private String servicio;

	@Column(name = "precio_pasaje", nullable = false, precision = 5)
	private double precioPasaje;

	public Integer getIdVentaDetalle() {
		return this.idVentaDetalle;
	}

	public void setIdVentaDetalle(Integer idVentaDetalle) {
		this.idVentaDetalle = idVentaDetalle;
	}

	public Pasajero getPasajero() {
		return this.pasajero;
	}

	public void setPasajero(Pasajero pasajero) {
		this.pasajero = pasajero;
	}

	public VentaOnline getVentaOnline() {
		return this.ventaOnline;
	}

	public void setVentaOnline(VentaOnline ventaOnline) {
		this.ventaOnline = ventaOnline;
	}

	public Integer getIdVentaLegacy() {
		return this.idVentaLegacy;
	}

	public void setIdVentaLegacy(Integer idVentaLegacy) {
		this.idVentaLegacy = idVentaLegacy;
	}

	public String getNumeroBoleto() {
		return this.numeroBoleto;
	}

	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}

	public int getAsientoFila() {
		return this.asientoFila;
	}

	public void setAsientoFila(int asientoFila) {
		this.asientoFila = asientoFila;
	}

	public int getAsientoColumna() {
		return this.asientoColumna;
	}

	public void setAsientoColumna(int asientoColumna) {
		this.asientoColumna = asientoColumna;
	}

	public String getAsientoEtiqueta() {
		return this.asientoEtiqueta;
	}

	public void setAsientoEtiqueta(String asientoEtiqueta) {
		this.asientoEtiqueta = asientoEtiqueta;
	}

	public int getPreferenciaViaje() {
		return this.preferenciaViaje;
	}

	public void setPreferenciaViaje(int preferenciaViaje) {
		this.preferenciaViaje = preferenciaViaje;
	}

	public int getIdItinerario() {
		return this.idItinerario;
	}

	public void setIdItinerario(int idItinerario) {
		this.idItinerario = idItinerario;
	}

	public int getIdPasajeroLegacy() {
		return this.idPasajeroLegacy;
	}

	public void setIdPasajeroLegacy(int idPasajeroLegacy) {
		this.idPasajeroLegacy = idPasajeroLegacy;
	}

	public String getNombreApellidoPasajero() {
		return this.nombreApellidoPasajero;
	}

	public void setNombreApellidoPasajero(String nombreApellidoPasajero) {
		this.nombreApellidoPasajero = nombreApellidoPasajero;
	}

	public String getTipoDocumentoPasajero() {
		return this.tipoDocumentoPasajero;
	}

	public void setTipoDocumentoPasajero(String tipoDocumentoPasajero) {
		this.tipoDocumentoPasajero = tipoDocumentoPasajero;
	}

	public String getNumeroDocumentoPasajero() {
		return this.numeroDocumentoPasajero;
	}

	public void setNumeroDocumentoPasajero(String numeroDocumentoPasajero) {
		this.numeroDocumentoPasajero = numeroDocumentoPasajero;
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

	public double getPrecioPasaje() {
		return this.precioPasaje;
	}

	public void setPrecioPasaje(double precioPasaje) {
		this.precioPasaje = precioPasaje;
	}

}
