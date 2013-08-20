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
@Table(name = "vptm_objeto")
public class Objeto extends JpaEntityBase implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_objeto", unique = true, nullable = false)
	private Integer idObjeto;

	@Column(name = "codigo", nullable = false, length = 20)
	private String codigo;

	@Column(name = "descripcion", length = 50)
	private String descripcion;

	@Column(name = "imagen", length = 50)
	private String imagen;

	@Column(name = "estado", nullable = false)
	private short estado;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "objeto")
	private Set<BusPisoPosicionObjeto> busPisoPosicionObjetos = new HashSet<BusPisoPosicionObjeto>(
			0);

	public Integer getIdObjeto() {
		return this.idObjeto;
	}

	public void setIdObjeto(Integer idObjeto) {
		this.idObjeto = idObjeto;
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

	public String getImagen() {
		return this.imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
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
