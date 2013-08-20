package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_pago")
public class Pago extends JpaEntityBase implements java.io.Serializable {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "ventaOnline"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id_venta", unique = true, nullable = false)
	private Long idVenta;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private VentaOnline ventaOnline;

	@Column(name = "eticket", length = 30)
	private String eticket;

	@Column(name = "respuesta", length = 1, columnDefinition = "char")
	private String respuesta;

	@Column(name = "codigo_accion", length = 3, columnDefinition = "char")
	private String codigoAccion;

	@Column(name = "numero_tarjeta", length = 19)
	private String numeroTarjeta;

	@Column(name = "eci", length = 2, columnDefinition = "char")
	private String eci;

	@Column(name = "codigo_autorizacion", length = 6, columnDefinition = "char")
	private String codigoAutorizacion;

	@Column(name = "origen_tarjeta", length = 1, columnDefinition = "char")
	private String origenTarjeta;

	@Column(name = "nombre_banco", length = 50)
	private String nombreBanco;

	@Column(name = "descripcion_eci", length = 50)
	private String descripcionEci;

	@Column(name = "resultado_cvv2", length = 1, columnDefinition = "char")
	private String resultadoCvv2;

	@Column(name = "importe_autorizado", precision = 10)
	private BigDecimal importeAutorizado;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_transaccion", length = 19)
	private Date fechaTransaccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_deposito", length = 19)
	private Date fechaDeposito;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_anulacion", length = 19)
	private Date fechaAnulacion;

	public Long getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(Long idVenta) {
		this.idVenta = idVenta;
	}

	public VentaOnline getVentaOnline() {
		return this.ventaOnline;
	}

	public void setVentaOnline(VentaOnline ventaOnline) {
		this.ventaOnline = ventaOnline;
	}

	public String getEticket() {
		return this.eticket;
	}

	public void setEticket(String eticket) {
		this.eticket = eticket;
	}

	public String getRespuesta() {
		return this.respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public String getCodigoAccion() {
		return this.codigoAccion;
	}

	public void setCodigoAccion(String codigoAccion) {
		this.codigoAccion = codigoAccion;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getEci() {
		return this.eci;
	}

	public void setEci(String eci) {
		this.eci = eci;
	}

	public String getCodigoAutorizacion() {
		return this.codigoAutorizacion;
	}

	public void setCodigoAutorizacion(String codigoAutorizacion) {
		this.codigoAutorizacion = codigoAutorizacion;
	}

	public String getOrigenTarjeta() {
		return this.origenTarjeta;
	}

	public void setOrigenTarjeta(String origenTarjeta) {
		this.origenTarjeta = origenTarjeta;
	}

	public String getNombreBanco() {
		return this.nombreBanco;
	}

	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}

	public String getDescripcionEci() {
		return this.descripcionEci;
	}

	public void setDescripcionEci(String descripcionEci) {
		this.descripcionEci = descripcionEci;
	}

	public String getResultadoCvv2() {
		return this.resultadoCvv2;
	}

	public void setResultadoCvv2(String resultadoCvv2) {
		this.resultadoCvv2 = resultadoCvv2;
	}

	public BigDecimal getImporteAutorizado() {
		return this.importeAutorizado;
	}

	public void setImporteAutorizado(BigDecimal importeAutorizado) {
		this.importeAutorizado = importeAutorizado;
	}

	public Date getFechaTransaccion() {
		return this.fechaTransaccion;
	}

	public void setFechaTransaccion(Date fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public Date getFechaDeposito() {
		return this.fechaDeposito;
	}

	public void setFechaDeposito(Date fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

	public Date getFechaAnulacion() {
		return this.fechaAnulacion;
	}

	public void setFechaAnulacion(Date fechaAnulacion) {
		this.fechaAnulacion = fechaAnulacion;
	}

}
