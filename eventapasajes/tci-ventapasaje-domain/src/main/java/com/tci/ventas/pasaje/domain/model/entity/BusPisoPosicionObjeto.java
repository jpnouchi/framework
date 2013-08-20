package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptr_bus_piso_posicion_objeto")
public class BusPisoPosicionObjeto extends JpaEntityBase implements
		java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idPosicion", column = @Column(name = "id_posicion", nullable = false)),
			@AttributeOverride(name = "idObjeto", column = @Column(name = "id_objeto", nullable = false)) })
	private BusPisoPosicionObjetoId id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_objeto", nullable = false, insertable = false, updatable = false)
	private Objeto objeto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_posicion", nullable = false, insertable = false, updatable = false)
	private BusPisoPosicion busPisoPosicion;

	@Column(name = "etiqueta", length = 10)
	private String etiqueta;

	@Column(name = "estado", nullable = false)
	private short estado;

	public BusPisoPosicionObjetoId getId() {
		return this.id;
	}

	public void setId(BusPisoPosicionObjetoId id) {
		this.id = id;
	}

	public Objeto getObjeto() {
		return this.objeto;
	}

	public void setObjeto(Objeto objeto) {
		this.objeto = objeto;
	}

	public BusPisoPosicion getBusPisoPosicion() {
		return this.busPisoPosicion;
	}

	public void setBusPisoPosicion(BusPisoPosicion busPisoPosicion) {
		this.busPisoPosicion = busPisoPosicion;
	}

	public String getEtiqueta() {
		return this.etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

}
