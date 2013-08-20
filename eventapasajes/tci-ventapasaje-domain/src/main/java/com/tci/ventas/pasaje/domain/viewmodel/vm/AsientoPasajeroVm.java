package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;

import com.tci.ventas.pasaje.util.Constant;

public class AsientoPasajeroVm implements Serializable {
	
	private BusVm busVmIda;
	private BusVm busVmRetorno;
	private PasajeroVm pasajeroVm;
	private String formaPago;
	private String tipoTarjeta;
	private Double montoTotal;
	private boolean terminosCondiciones;
	private Integer preferenciaViaje;
	private Integer asientoSeleccionadoBusIdaFila;
	private Integer asientoSeleccionadoBusIdaColumna;
	private Integer asientoSeleccionadoBusRetornoFila;
	private Integer asientoSeleccionadoBusRetornoColumna;
	
	public AsientoPasajeroVm(){
		busVmIda=new BusVm();
		busVmRetorno=new BusVm();
		pasajeroVm=new PasajeroVm();
		montoTotal=new Double(00.0);
		formaPago=Constant.TARJETA_CREDITO_DEBITO;
		tipoTarjeta=Constant.VISA;
	}
	
	
	
	public BusVm getBusVmIda() {
		return busVmIda;
	}
	public void setBusVmIda(BusVm busVmIda) {
		this.busVmIda = busVmIda;
	}
	public BusVm getBusVmRetorno() {
		return busVmRetorno;
	}
	public void setBusVmRetorno(BusVm busVmRetorno) {
		this.busVmRetorno = busVmRetorno;
	}
	public PasajeroVm getPasajeroVm() {
		return pasajeroVm;
	}
	public void setPasajeroVm(PasajeroVm pasajeroVm) {
		this.pasajeroVm = pasajeroVm;
	}
	public String getFormaPago() {
		return formaPago;
	}
	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public Double getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	public boolean isTerminosCondiciones() {
		return terminosCondiciones;
	}
	public void setTerminosCondiciones(boolean terminosCondiciones) {
		this.terminosCondiciones = terminosCondiciones;
	}

	public Integer getPreferenciaViaje() {
		return preferenciaViaje;
	}

	public void setPreferenciaViaje(Integer preferenciaViaje) {
		this.preferenciaViaje = preferenciaViaje;
	}



	public Integer getAsientoSeleccionadoBusIdaFila() {
		return asientoSeleccionadoBusIdaFila;
	}



	public void setAsientoSeleccionadoBusIdaFila(
			Integer asientoSeleccionadoBusIdaFila) {
		this.asientoSeleccionadoBusIdaFila = asientoSeleccionadoBusIdaFila;
	}



	public Integer getAsientoSeleccionadoBusIdaColumna() {
		return asientoSeleccionadoBusIdaColumna;
	}



	public void setAsientoSeleccionadoBusIdaColumna(
			Integer asientoSeleccionadoBusIdaColumna) {
		this.asientoSeleccionadoBusIdaColumna = asientoSeleccionadoBusIdaColumna;
	}



	public Integer getAsientoSeleccionadoBusRetornoFila() {
		return asientoSeleccionadoBusRetornoFila;
	}



	public void setAsientoSeleccionadoBusRetornoFila(
			Integer asientoSeleccionadoBusRetornoFila) {
		this.asientoSeleccionadoBusRetornoFila = asientoSeleccionadoBusRetornoFila;
	}



	public Integer getAsientoSeleccionadoBusRetornoColumna() {
		return asientoSeleccionadoBusRetornoColumna;
	}



	public void setAsientoSeleccionadoBusRetornoColumna(
			Integer asientoSeleccionadoBusRetornoColumna) {
		this.asientoSeleccionadoBusRetornoColumna = asientoSeleccionadoBusRetornoColumna;
	}
	
	
	

}
