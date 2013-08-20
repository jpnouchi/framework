package com.tci.ventas.pasaje.application.service.business.intf;

import com.tci.ventas.pasaje.domain.viewmodel.vm.ConfirmacionCompraVm;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 12:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ConfirmacionCompraService {

    ConfirmacionCompraVm getConfirmacionCompraVmForEdition(Long idVentaOnline);


}
