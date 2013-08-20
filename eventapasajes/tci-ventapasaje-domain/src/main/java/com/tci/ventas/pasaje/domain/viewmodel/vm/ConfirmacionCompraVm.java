package com.tci.ventas.pasaje.domain.viewmodel.vm;

import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 10:03 AM
 * To change this template use File | Settings | File Templates.
 */

public class ConfirmacionCompraVm implements java.io.Serializable {

    //fechaCreacion
    @NotEmpty
    private String fechaPedido;
    /***Datos Empresa***/
    @NotEmpty
    private String razonSocial;

    private String direccion;

    private String dominio;

    private String logo;
    @NotEmpty
    private String numeroRuc;

    private String telefono;

    /***Datos Pago***/
    private String numeroTarjeta;
    /***Datos VentaOnline***/
    @NotEmpty
    private String montoTotal;
    @NotEmpty
    private String moneda;
    @NotEmpty
    private String tipoComprobante;
    @NotEmpty
    private String numeroVoucher;
    @NotEmpty
    private String nombreApellidoCliente;
    @NotEmpty
    private String numeroDocumentoCliente;

    /***Datos Deatlles Venta***/
    private List<ConfirmacionCompraDetalleVm> confirmacionCompraDetalleVmList ;

    /*** Datos Pasajero ***/
    @NotEmpty
    private String nombreApellidoPasajero;
    @NotEmpty
    private String numeroDocumentoPasajero;


    /***Datos JpaEntityBase***/
    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    /***Datos Empresa***/
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDominio() {
        return dominio;
    }

    public void setDominio(String dominio) {
        this.dominio = dominio;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getNumeroRuc() {
        return numeroRuc;
    }

    public void setNumeroRuc(String numeroRuc) {
        this.numeroRuc = numeroRuc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /***Datos Empresa***/
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /***Datos VentaOnline***/
    public String getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(String montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getTipoComprobante() {
        return tipoComprobante;
    }

    public void setTipoComprobante(String tipoComprobante) {
        this.tipoComprobante = tipoComprobante;
    }

    public String getNumeroVoucher() {
        return numeroVoucher;
    }

    public void setNumeroVoucher(String numeroVoucher) {
        this.numeroVoucher = numeroVoucher;
    }

    public String getNombreApellidoCliente() {
        return nombreApellidoCliente;
    }

    public void setNombreApellidoCliente(String nombreApellidoCliente) {
        this.nombreApellidoCliente = nombreApellidoCliente;
    }

    public String getNumeroDocumentoCliente() {
        return numeroDocumentoCliente;
    }

    public void setNumeroDocumentoCliente(String numeroDocumentoCliente) {
        this.numeroDocumentoCliente = numeroDocumentoCliente;
    }

    /***Datos VentaDetalle***/
    public List<ConfirmacionCompraDetalleVm> getConfirmacionCompraDetalleVmList() {
        return confirmacionCompraDetalleVmList;
    }

    public void setConfirmacionCompraDetalleVmList(List<ConfirmacionCompraDetalleVm> confirmacionCompraDetalleVmList) {
        this.confirmacionCompraDetalleVmList = confirmacionCompraDetalleVmList;
    }

    /****Datos Pasajero***/
    public String getNombreApellidoPasajero() {
        return nombreApellidoPasajero;
    }

    public void setNombreApellidoPasajero(String nombreApellidoPasajero) {
        this.nombreApellidoPasajero = nombreApellidoPasajero;
    }

    public String getNumeroDocumentoPasajero() {
        return numeroDocumentoPasajero;
    }

    public void setNumeroDocumentoPasajero(String numeroDocumentoPasajero) {
        this.numeroDocumentoPasajero = numeroDocumentoPasajero;
    }
}
