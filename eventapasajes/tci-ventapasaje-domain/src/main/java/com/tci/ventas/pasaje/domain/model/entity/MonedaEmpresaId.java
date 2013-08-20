package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MonedaEmpresaId generated by hbm2java
 */
@Embeddable
public class MonedaEmpresaId implements java.io.Serializable {

	@Column(name = "id_empresa", nullable = false)
	private Long idEmpresa;

	@Column(name = "id_moneda", nullable = false)
	private Long idMoneda;

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Long getIdMoneda() {
		return this.idMoneda;
	}

	public void setIdMoneda(Long idMoneda) {
		this.idMoneda = idMoneda;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MonedaEmpresaId))
			return false;
		MonedaEmpresaId castOther = (MonedaEmpresaId) other;

		return (this.getIdEmpresa() == castOther.getIdEmpresa())
				&& (this.getIdMoneda() == castOther.getIdMoneda());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdEmpresa().intValue();
		result = 37 * result + this.getIdMoneda().intValue();
		return result;
	}

}
