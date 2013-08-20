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
@Table(name = "vptd_empresa_configuracion")
public class EmpresaConfiguracion extends JpaEntityBase implements
		java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_configuracion", unique = true, nullable = false)
	private Integer idConfiguracion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(name = "nombre_tabla", nullable = false, length = 50)
	private String nombreTabla;

	@Column(name = "codigo", nullable = false, length = 10)
	private String codigo;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	@Column(name = "valor", nullable = false, length = 65535)
	private String valor;

	public Integer getIdConfiguracion() {
		return this.idConfiguracion;
	}

	public void setIdConfiguracion(Integer idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getNombreTabla() {
		return this.nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return this.valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

}
