package com.tci.ventas.pasaje.domain.enums;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 04:12 PM
 * To change this template use File | Settings | File Templates.
 */
public enum TipoComprobanteEnum {
    NN(0,"NN"),
    VOUCHER(1,"VOUCHER");

    private final Integer codigo;
    private final String descripcion;

    TipoComprobanteEnum(Integer codigo, String descripcion){
        this.codigo=codigo;
        this.descripcion=descripcion;
    }


    public String getDescripcion() { return descripcion; }
    public Integer getcodigo() { return codigo; }
    public static TipoComprobanteEnum obtenerComprobante(int codigo){
        switch (codigo)   {
            case 1:
                  return VOUCHER;
            default:
                   return NN;
        }
    }
}
