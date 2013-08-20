package com.tci.ventas.pasaje.domain.viewmodel.flt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.tci.domain.viewmodel.FilterBase;
import com.tci.domain.viewmodel.FiltersBean;
import com.tci.domain.viewmodel.LabelValueBean;

public class ItinerarioFlt extends FilterBase 
{
	
	private Long idEmpresaLegacy;
	private Long idCiudadOrigenLegacy;
	private Long idCiudadDestinoLegacy;
	private Long idServicioLegacy;
	private Date fechaSalida;
	private Date fechaRetorno;
	private String opcionViaje;

//	
//	public ItinerarioFlt (Long idEmpresaLegacy){
//		this.idEmpresaLegacy=idEmpresaLegacy;
//	}

	public Long getIdCiudadOrigenLegacy() {
		return idCiudadOrigenLegacy;
	}



	public void setIdCiudadOrigenLegacy(Long idCiudadOrigenLegacy) {
		this.idCiudadOrigenLegacy = idCiudadOrigenLegacy;
	}



	public Long getIdCiudadDestinoLegacy() {
		return idCiudadDestinoLegacy;
	}



	public void setIdCiudadDestinoLegacy(Long idCiudadDestinoLegacy) {
		this.idCiudadDestinoLegacy = idCiudadDestinoLegacy;
	}



	public Long getIdServicioLegacy() {
		return idServicioLegacy;
	}



	public void setIdServicioLegacy(Long idServicioLegacy) {
		this.idServicioLegacy = idServicioLegacy;
	}



	public Date getFechaSalida() {
		return fechaSalida;
	}



	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}



	public Date getFechaRetorno() {
		return fechaRetorno;
	}



	public void setFechaRetorno(Date fechaRetorno) {
		this.fechaRetorno = fechaRetorno;
	}



	public String getOpcionViaje() {
		return opcionViaje;
	}



	public void setOpcionViaje(String opcionViaje) {
		this.opcionViaje = opcionViaje;
	}


	public Long getIdEmpresaLegacy() {
		return idEmpresaLegacy;
	}



	public void setIdEmpresaLegacy(Long idEmpresaLegacy) {
		this.idEmpresaLegacy = idEmpresaLegacy;
	}



	@Override
	public FiltersBean getFiltersBean() {
		List<LabelValueBean> principal = new ArrayList<LabelValueBean>();
		List<LabelValueBean> advanced = new ArrayList<LabelValueBean>();

		principal.add(new LabelValueBean("label_origen_itinerario", String.valueOf(idCiudadOrigenLegacy)));
		principal.add(new LabelValueBean("label_destino_itinerario", String.valueOf(idCiudadDestinoLegacy)));
		principal.add(new LabelValueBean("label_fechaSalida_itinerario", String.valueOf(fechaSalida)));
		principal.add(new LabelValueBean("label_fechaRetorno_itinerario", String.valueOf(fechaRetorno)));
		principal.add(new LabelValueBean("label_servicio_itinerario", String.valueOf(idServicioLegacy)));
		principal.add(new LabelValueBean("label_opcionViaje_itinerario", opcionViaje));
		

		return new FiltersBean(principal, advanced);
	}
}
