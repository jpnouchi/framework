package com.tci.ventas.pasaje.domain.viewmodel.vo;

import java.io.Serializable;

public class PersonaVO implements Serializable {
	
	private Long idPersona;
	private String nombres;
	
	public Long getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	
}
