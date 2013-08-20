package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;

public class BusPisoPosicionObjetoIdVm implements Serializable {
	
	private Long idPosicion;
	private Long idObjeto;
	
	public Long getIdPosicion() {
		return idPosicion;
	}
	public void setIdPosicion(Long idPosicion) {
		this.idPosicion = idPosicion;
	}
	public Long getIdObjeto() {
		return idObjeto;
	}
	public void setIdObjeto(Long idObjeto) {
		this.idObjeto = idObjeto;
	}
	
	
}
