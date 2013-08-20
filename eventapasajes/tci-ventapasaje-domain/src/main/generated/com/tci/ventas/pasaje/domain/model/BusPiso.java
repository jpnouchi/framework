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
@Table(name = "vptd_bus_piso")
public class BusPiso extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_piso", unique = true, nullable = false)
	private Integer idPiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_bus", nullable = false)
	private Bus bus;

	@Column(name = "total_numero_fila")
	private Integer totalNumeroFila;

	@Column(name = "total_numero_columna")
	private Integer totalNumeroColumna;

	@Column(name = "estado", nullable = false)
	private short estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "busPiso")
	private Set<BusPisoPosicion> busPisoPosicions = new HashSet<BusPisoPosicion>(
			0);

	public Integer getIdPiso() {
		return this.idPiso;
	}

	public void setIdPiso(Integer idPiso) {
		this.idPiso = idPiso;
	}

	public Bus getBus() {
		return this.bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Integer getTotalNumeroFila() {
		return this.totalNumeroFila;
	}

	public void setTotalNumeroFila(Integer totalNumeroFila) {
		this.totalNumeroFila = totalNumeroFila;
	}

	public Integer getTotalNumeroColumna() {
		return this.totalNumeroColumna;
	}

	public void setTotalNumeroColumna(Integer totalNumeroColumna) {
		this.totalNumeroColumna = totalNumeroColumna;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public Set<BusPisoPosicion> getBusPisoPosicions() {
		return this.busPisoPosicions;
	}

	public void setBusPisoPosicions(Set<BusPisoPosicion> busPisoPosicions) {
		this.busPisoPosicions = busPisoPosicions;
	}

}
