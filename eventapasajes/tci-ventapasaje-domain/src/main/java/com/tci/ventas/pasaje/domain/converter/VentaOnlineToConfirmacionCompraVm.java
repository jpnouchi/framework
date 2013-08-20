package com.tci.ventas.pasaje.domain.converter;

import com.tci.ventas.pasaje.domain.enums.TipoComprobanteEnum;
import com.tci.ventas.pasaje.domain.model.entity.VentaDetalle;
import com.tci.ventas.pasaje.domain.model.entity.VentaOnline;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ConfirmacionCompraDetalleVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ConfirmacionCompraVm;
import com.tci.ventas.pasaje.util.format.DateFormatter;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 02:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class VentaOnlineToConfirmacionCompraVm implements Converter<VentaOnline,ConfirmacionCompraVm> {


    @Override
    public ConfirmacionCompraVm convert(VentaOnline ventaOnline) {
        ConfirmacionCompraVm confirmacionCompraVm = new ConfirmacionCompraVm();
        copiarPropiedades(ventaOnline,confirmacionCompraVm);
        return confirmacionCompraVm;  //To change body of implemented methods use File | Settings | File Templates.
    }

    private void copiarPropiedades(VentaOnline ventaOnline,ConfirmacionCompraVm confirmacionCompraVm){

        confirmacionCompraVm.setFechaPedido(DateFormatter.DATE_TIME_FORMAT.print(ventaOnline.getFechaCreacion()));
        confirmacionCompraVm.setNumeroTarjeta(ventaOnline.getPago().getNumeroTarjeta());
        confirmacionCompraVm.setMontoTotal(ventaOnline.getMontoTotal().toString());
        confirmacionCompraVm.setMoneda(ventaOnline.getMoneda());
        confirmacionCompraVm.setTipoComprobante(TipoComprobanteEnum.obtenerComprobante(ventaOnline.getTipoComprobante()).getDescripcion());
        confirmacionCompraVm.setNumeroVoucher(ventaOnline.getNumeroVoucher());
        confirmacionCompraVm.setNombreApellidoCliente(ventaOnline.getNombreApellidoCliente());
        confirmacionCompraVm.setNumeroDocumentoCliente(ventaOnline.getNumeroDocumentoCliente());

        List<ConfirmacionCompraDetalleVm> confirmacionCompraDetalleVmList = new ArrayList<ConfirmacionCompraDetalleVm>();
        int i=0;
        for(VentaDetalle ventaDetalle: ventaOnline.getVentaDetalles()){
            if(i==0){
                confirmacionCompraVm.setNombreApellidoPasajero(ventaDetalle.getNombreApellidoPasajero());
                confirmacionCompraVm.setNumeroDocumentoPasajero(ventaDetalle.getNumeroDocumentoPasajero());
            }
            confirmacionCompraDetalleVmList.add(ventaDetalleToCompraDetalleVm(ventaDetalle));
            i++;
        }
        confirmacionCompraVm.setConfirmacionCompraDetalleVmList(confirmacionCompraDetalleVmList);


    }

    private ConfirmacionCompraDetalleVm ventaDetalleToCompraDetalleVm(VentaDetalle ventaDetalle){

         return new ConfirmacionCompraDetalleVm(
                 ventaDetalle.getOrigen()+" - "+ventaDetalle.getDestino(),
                 ventaDetalle.getAsientoEtiqueta(),
                 ventaDetalle.getServicio(),
                 ventaDetalle.getPrecioPasaje().toString(),
                 DateFormatter.DATE_FORMATTER.print(ventaDetalle.getFechaSalida())
         );
    }
}
