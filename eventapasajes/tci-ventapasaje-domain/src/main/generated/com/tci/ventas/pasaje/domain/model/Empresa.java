package com.tci.ventas.pasaje.domain.model;

// Generated 23/07/2013 06:09:34 PM by Hibernate Tools 3.4.0.CR1

import com.tci.domain.model.JpaEntityBase;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author gcruz
 * @date   23/07/2013
 */
@Entity
@Table(name = "vptm_empresa")
public class Empresa extends JpaEntityBase implements java.io.Serializable {

	@Id
	@Column(name = "id_empresa", unique = true, nullable = false)
	private int idEmpresa;

	@Column(name = "id_empresa_legacy", nullable = false)
	private int idEmpresaLegacy;

	@Column(name = "numero_ruc", nullable = false, length = 20)
	private String numeroRuc;

	@Column(name = "razon_social", nullable = false, length = 100)
	private String razonSocial;

	@Column(name = "logo", length = 20)
	private String logo;

	@Column(name = "telefono", length = 20)
	private String telefono;

	@Column(name = "direccion", length = 100)
	private String direccion;

	@Column(name = "dominio", length = 50)
	private String dominio;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<MonedaEmpresa> monedaEmpresas = new HashSet<MonedaEmpresa>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<Servicio> servicios = new HashSet<Servicio>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<PersonaEmpresa> personaEmpresas = new HashSet<PersonaEmpresa>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<Agencia> agencias = new HashSet<Agencia>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<EmpresaConfiguracion> empresaConfiguracions = new HashSet<EmpresaConfiguracion>(
			0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<Ciudad> ciudads = new HashSet<Ciudad>(0);

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empresa")
	private Set<Bus> buses = new HashSet<Bus>(0);

	public int getIdEmpresa() {
		return this.idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdEmpresaLegacy() {
		return this.idEmpresaLegacy;
	}

	public void setIdEmpresaLegacy(int idEmpresaLegacy) {
		this.idEmpresaLegacy = idEmpresaLegacy;
	}

	public String getNumeroRuc() {
		return this.numeroRuc;
	}

	public void setNumeroRuc(String numeroRuc) {
		this.numeroRuc = numeroRuc;
	}

	public String getRazonSocial() {
		return this.razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDominio() {
		return this.dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Set<MonedaEmpresa> getMonedaEmpresas() {
		return this.monedaEmpresas;
	}

	public void setMonedaEmpresas(Set<MonedaEmpresa> monedaEmpresas) {
		this.monedaEmpresas = monedaEmpresas;
	}

	public Set<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(Set<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Set<PersonaEmpresa> getPersonaEmpresas() {
		return this.personaEmpresas;
	}

	public void setPersonaEmpresas(Set<PersonaEmpresa> personaEmpresas) {
		this.personaEmpresas = personaEmpresas;
	}

	public Set<Agencia> getAgencias() {
		return this.agencias;
	}

	public void setAgencias(Set<Agencia> agencias) {
		this.agencias = agencias;
	}

	public Set<EmpresaConfiguracion> getEmpresaConfiguracions() {
		return this.empresaConfiguracions;
	}

	public void setEmpresaConfiguracions(
			Set<EmpresaConfiguracion> empresaConfiguracions) {
		this.empresaConfiguracions = empresaConfiguracions;
	}

	public Set<Ciudad> getCiudads() {
		return this.ciudads;
	}

	public void setCiudads(Set<Ciudad> ciudads) {
		this.ciudads = ciudads;
	}

	public Set<Bus> getBuses() {
		return this.buses;
	}

	public void setBuses(Set<Bus> buses) {
		this.buses = buses;
	}

}
