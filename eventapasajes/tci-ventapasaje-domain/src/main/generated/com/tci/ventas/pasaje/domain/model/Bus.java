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
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_bus")
public class Bus extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_bus", unique = true, nullable = false)
	private Integer idBus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false)
	private Empresa empresa;

	@Column(name = "marca", length = 30)
	private String marca;

	@Column(name = "modelo", length = 30)
	private String modelo;

	@Column(name = "descripcion", length = 100)
	private String descripcion;

	@Column(name = "id_bus_legacy", nullable = false)
	private int idBusLegacy;

	@Column(name = "estado", nullable = false)
	private short estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bus")
	private Set<BusPiso> busPisos = new HashSet<BusPiso>(0);

	public Integer getIdBus() {
		return this.idBus;
	}

	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getMarca() {
		return this.marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return this.modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getIdBusLegacy() {
		return this.idBusLegacy;
	}

	public void setIdBusLegacy(int idBusLegacy) {
		this.idBusLegacy = idBusLegacy;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public Set<BusPiso> getBusPisos() {
		return this.busPisos;
	}

	public void setBusPisos(Set<BusPiso> busPisos) {
		this.busPisos = busPisos;
	}

}
