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
@Table(name = "vptd_bus_piso_posicion")
public class BusPisoPosicion extends JpaEntityBase implements
		java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_posicion", unique = true, nullable = false)
	private Integer idPosicion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_piso", nullable = false)
	private BusPiso busPiso;

	@Column(name = "numero_fila", nullable = false)
	private int numeroFila;

	@Column(name = "numero_columna", nullable = false)
	private int numeroColumna;

	@Column(name = "estado", nullable = false)
	private short estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "busPisoPosicion")
	private Set<BusPisoPosicionObjeto> busPisoPosicionObjetos = new HashSet<BusPisoPosicionObjeto>(
			0);

	public Integer getIdPosicion() {
		return this.idPosicion;
	}

	public void setIdPosicion(Integer idPosicion) {
		this.idPosicion = idPosicion;
	}

	public BusPiso getBusPiso() {
		return this.busPiso;
	}

	public void setBusPiso(BusPiso busPiso) {
		this.busPiso = busPiso;
	}

	public int getNumeroFila() {
		return this.numeroFila;
	}

	public void setNumeroFila(int numeroFila) {
		this.numeroFila = numeroFila;
	}

	public int getNumeroColumna() {
		return this.numeroColumna;
	}

	public void setNumeroColumna(int numeroColumna) {
		this.numeroColumna = numeroColumna;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

	public Set<BusPisoPosicionObjeto> getBusPisoPosicionObjetos() {
		return this.busPisoPosicionObjetos;
	}

	public void setBusPisoPosicionObjetos(
			Set<BusPisoPosicionObjeto> busPisoPosicionObjetos) {
		this.busPisoPosicionObjetos = busPisoPosicionObjetos;
	}

}
