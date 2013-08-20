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
@Table(name = "vptr_persona_empresa")
public class PersonaEmpresa extends JpaEntityBase implements
		java.io.Serializable {

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idPersona", column = @Column(name = "id_persona", nullable = false)),
			@AttributeOverride(name = "idEmpresa", column = @Column(name = "id_empresa", nullable = false)) })
	private PersonaEmpresaId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_empresa", nullable = false, insertable = false, updatable = false)
	private Empresa empresa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_persona", nullable = false, insertable = false, updatable = false)
	private Persona persona;

	public PersonaEmpresaId getId() {
		return this.id;
	}

	public void setId(PersonaEmpresaId id) {
		this.id = id;
	}

	public Empresa getEmpresa() {
		return this.empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Persona getPersona() {
		return this.persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

}
