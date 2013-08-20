package com.tci.ventas.pasaje.domain.model;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_correo")
public class Correo extends JpaEntityBase implements java.io.Serializable {

	@Id
	@Column(name = "id_correo", unique = true, nullable = false)
	private int idCorreo;

	@Column(name = "de", nullable = false, length = 50)
	private String de;

	@Column(name = "para", nullable = false, length = 65535)
	private String para;

	@Column(name = "asunto", nullable = false, length = 250)
	private String asunto;

	@Column(name = "tipo_contenido", nullable = false, length = 20)
	private String tipoContenido;

	@Column(name = "contenido", nullable = false, length = 65535)
	private String contenido;

	@Column(name = "numero_intentos", nullable = false)
	private int numeroIntentos;

	@Column(name = "estado", nullable = false)
	private short estado;

	public int getIdCorreo() {
		return this.idCorreo;
	}

	public void setIdCorreo(int idCorreo) {
		this.idCorreo = idCorreo;
	}

	public String getDe() {
		return this.de;
	}

	public void setDe(String de) {
		this.de = de;
	}

	public String getPara() {
		return this.para;
	}

	public void setPara(String para) {
		this.para = para;
	}

	public String getAsunto() {
		return this.asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTipoContenido() {
		return this.tipoContenido;
	}

	public void setTipoContenido(String tipoContenido) {
		this.tipoContenido = tipoContenido;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public int getNumeroIntentos() {
		return this.numeroIntentos;
	}

	public void setNumeroIntentos(int numeroIntentos) {
		this.numeroIntentos = numeroIntentos;
	}

	public short getEstado() {
		return this.estado;
	}

	public void setEstado(short estado) {
		this.estado = estado;
	}

}
