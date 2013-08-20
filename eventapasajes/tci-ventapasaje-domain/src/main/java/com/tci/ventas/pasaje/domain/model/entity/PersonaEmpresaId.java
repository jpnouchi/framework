package com.tci.ventas.pasaje.domain.model.entity;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonaEmpresaId generated by hbm2java
 */
@Embeddable
public class PersonaEmpresaId implements java.io.Serializable {

	@Column(name = "id_persona", nullable = false)
	private Long idPersona;

	@Column(name = "id_empresa", nullable = false)
	private Long idEmpresa;

	public Long getIdPersona() {
		return this.idPersona;
	}

	public void setIdPersona(Long idPersona) {
		this.idPersona = idPersona;
	}

	public Long getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof PersonaEmpresaId))
			return false;
		PersonaEmpresaId castOther = (PersonaEmpresaId) other;

		return (this.getIdPersona() == castOther.getIdPersona())
				&& (this.getIdEmpresa() == castOther.getIdEmpresa());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getIdPersona().intValue();
		result = 37 * result + this.getIdEmpresa().intValue();
		return result;
	}

}
