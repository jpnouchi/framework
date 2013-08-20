package com.tci.ventas.pasaje.domain.model;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_venta_online")
public class VentaOnline extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_venta_online", unique = true, nullable = false)
	private Integer idVentaOnline;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente", nullable = false)
	private Cliente cliente;

	@Column(name = "numero_voucher", nullable = false, length = 20)
	private String numeroVoucher;

	@Column(name = "tipo_tarjeta", nullable = false, length = 20)
	private String tipoTarjeta;

	@Column(name = "forma_pago", nullable = false)
	private int formaPago;

	@Column(name = "tipo_comprobante", nullable = false)
	private int tipoComprobante;

	@Column(name = "monto_total", nullable = false, precision = 5)
	private double montoTotal;

	@Column(name = "nombre_apellido_cliente", nullable = false, length = 100)
	private String nombreApellidoCliente;

	@Column(name = "numero_documento_cliente", nullable = false, length = 50)
	private String numeroDocumentoCliente;

	@Column(name = "tipo_documento_cliente", nullable = false, length = 50)
	private String tipoDocumentoCliente;

	@Column(name = "moneda", nullable = false, length = 20)
	private String moneda;

	@Column(name = "canal_venta", nullable = false, length = 50)
	private String canalVenta;

	@Column(name = "numero_impresion", nullable = false)
	private int numeroImpresion;

	@Column(name = "estado", nullable = false)
	private int estado;

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "ventaOnline")
	private Pago pago;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ventaOnline")
	private Set<VentaDetalle> ventaDetalles = new HashSet<VentaDetalle>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ventaOnline")
	private Set<VentaIntegracion> ventaIntegracions = new HashSet<VentaIntegracion>(
			0);

	public Integer getIdVentaOnline() {
		return this.idVentaOnline;
	}

	public void setIdVentaOnline(Integer idVentaOnline) {
		this.idVentaOnline = idVentaOnline;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getNumeroVoucher() {
		return this.numeroVoucher;
	}

	public void setNumeroVoucher(String numeroVoucher) {
		this.numeroVoucher = numeroVoucher;
	}

	public String getTipoTarjeta() {
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public int getFormaPago() {
		return this.formaPago;
	}

	public void setFormaPago(int formaPago) {
		this.formaPago = formaPago;
	}

	public int getTipoComprobante() {
		return this.tipoComprobante;
	}

	public void setTipoComprobante(int tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public double getMontoTotal() {
		return this.montoTotal;
	}

	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}

	public String getNombreApellidoCliente() {
		return this.nombreApellidoCliente;
	}

	public void setNombreApellidoCliente(String nombreApellidoCliente) {
		this.nombreApellidoCliente = nombreApellidoCliente;
	}

	public String getNumeroDocumentoCliente() {
		return this.numeroDocumentoCliente;
	}

	public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
		this.numeroDocumentoCliente = numeroDocumentoCliente;
	}

	public String getTipoDocumentoCliente() {
		return this.tipoDocumentoCliente;
	}

	public void setTipoDocumentoCliente(String tipoDocumentoCliente) {
		this.tipoDocumentoCliente = tipoDocumentoCliente;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getCanalVenta() {
		return this.canalVenta;
	}

	public void setCanalVenta(String canalVenta) {
		this.canalVenta = canalVenta;
	}

	public int getNumeroImpresion() {
		return this.numeroImpresion;
	}

	public void setNumeroImpresion(int numeroImpresion) {
		this.numeroImpresion = numeroImpresion;
	}

	public int getEstado() {
		return this.estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Pago getPago() {
		return this.pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public Set<VentaDetalle> getVentaDetalles() {
		return this.ventaDetalles;
	}

	public void setVentaDetalles(Set<VentaDetalle> ventaDetalles) {
		this.ventaDetalles = ventaDetalles;
	}

	public Set<VentaIntegracion> getVentaIntegracions() {
		return this.ventaIntegracions;
	}

	public void setVentaIntegracions(Set<VentaIntegracion> ventaIntegracions) {
		this.ventaIntegracions = ventaIntegracions;
	}

}
