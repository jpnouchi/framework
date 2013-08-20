package com.tci.ventas.pasaje.domain.model.entity;

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
@Table(name = "vptd_venta_integracion")
public class VentaIntegracion extends JpaEntityBase implements
		java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_integracion", unique = true, nullable = false)
	private Long idIntegracion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_venta", nullable = false)
	private VentaOnline ventaOnline;

	@Column(name = "xml", nullable = false, length = 65535)
	private String xml;

	@Column(name = "tipo_solicitud", length = 1, columnDefinition = "char")
	private String tipoSolicitud;

	public Long getIdIntegracion() {
		return this.idIntegracion;
	}

	public void setIdIntegracion(Long idIntegracion) {
		this.idIntegracion = idIntegracion;
	}

	public VentaOnline getVentaOnline() {
		return this.ventaOnline;
	}

	public void setVentaOnline(VentaOnline ventaOnline) {
		this.ventaOnline = ventaOnline;
	}

	public String getXml() {
		return this.xml;
	}

	public void setXml(String xml) {
		this.xml = xml;
	}

	public String getTipoSolicitud() {
		return this.tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

}
