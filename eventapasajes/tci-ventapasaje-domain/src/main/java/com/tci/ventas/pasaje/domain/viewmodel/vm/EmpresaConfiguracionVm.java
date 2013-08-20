package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;

public class EmpresaConfiguracionVm implements Serializable {

	private Long idConfiguracion;

	private String nombreTabla;

	private String codigo;

	private String descripcion;

	private String valor;

	public Long getIdConfiguracion() {
		return idConfiguracion;
	}

	public void setIdConfiguracion(Long idConfiguracion) {
		this.idConfiguracion = idConfiguracion;
	}

	public String getNombreTabla() {
		return nombreTabla;
	}

	public void setNombreTabla(String nombreTabla) {
		this.nombreTabla = nombreTabla;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((idConfiguracion == null) ? 0 : idConfiguracion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmpresaConfiguracionVm other = (EmpresaConfiguracionVm) obj;
		if (idConfiguracion == null) {
			if (other.idConfiguracion != null)
				return false;
		} else if (!idConfiguracion.equals(other.idConfiguracion))
			return false;
		return true;
	}

	
	
	
}
