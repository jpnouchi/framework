package com.tci.ventas.pasaje.domain.viewmodel.vm;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 10:58 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConfirmacionCompraDetalleVm implements Serializable{

    @NotEmpty
    private String origenDestino;
    @NotEmpty
    private String asientoEtiqueta;
    @NotEmpty
    private String servicio;
    @NotEmpty
    private String precioPasaje;
    @NotEmpty
    private String fechaSalida;


    public ConfirmacionCompraDetalleVm(String origenDestino, String asientoEtiqueta, String servicio, String precioPasaje, String fechaSalida) {
        this.origenDestino = origenDestino;
        this.asientoEtiqueta = asientoEtiqueta;
        this.servicio = servicio;
        this.precioPasaje = precioPasaje;
        this.fechaSalida = fechaSalida;
    }

    public String getOrigenDestino() {
        return origenDestino;
    }

    public void setOrigenDestino(String origenDestino) {
        this.origenDestino = origenDestino;
    }

    public String getAsientoEtiqueta() {
        return asientoEtiqueta;
    }

    public void setAsientoEtiqueta(String asientoEtiqueta) {
        this.asientoEtiqueta = asientoEtiqueta;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getPrecioPasaje() {
        return precioPasaje;
    }

    public void setPrecioPasaje(String precioPasaje) {
        this.precioPasaje = precioPasaje;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
