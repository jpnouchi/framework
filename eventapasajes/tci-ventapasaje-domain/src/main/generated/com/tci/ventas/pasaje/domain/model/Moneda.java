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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_moneda")
public class Moneda extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_moneda", unique = true, nullable = false)
	private Integer idMoneda;

	@Column(name = "iso_moneda", nullable = false, length = 10)
	private String isoMoneda;

	@Column(name = "nombre_moneda", length = 20)
	private String nombreMoneda;

	@Column(name = "simbolo", nullable = false, length = 5)
	private String simbolo;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "moneda")
	private Set<MonedaEmpresa> monedaEmpresas = new HashSet<MonedaEmpresa>(0);

	public Integer getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(Integer idMoneda) {
		this.idMoneda = idMoneda;
	}

	public String getIsoMoneda() {
		return this.isoMoneda;
	}

	public void setIsoMoneda(String isoMoneda) {
		this.isoMoneda = isoMoneda;
	}

	public String getNombreMoneda() {
		return this.nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}

	public Set<MonedaEmpresa> getMonedaEmpresas() {
		return this.monedaEmpresas;
	}

	public void setMonedaEmpresas(Set<MonedaEmpresa> monedaEmpresas) {
		this.monedaEmpresas = monedaEmpresas;
	}

}
