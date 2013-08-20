package com.tci.ventas.pasaje.application.service.business.impl;

import com.tci.ventas.pasaje.application.service.business.intf.ConfirmacionCompraService;
import com.tci.ventas.pasaje.domain.model.entity.VentaOnline;
import com.tci.ventas.pasaje.domain.model.repository.VentaOnlineRepository;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ConfirmacionCompraVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConfirmacionCompraServiceImpl implements ConfirmacionCompraService {

    @Autowired
    private VentaOnlineRepository ventaOnlineRepository;

    @Autowired
    ConversionService conversionService;

    @Override
    public ConfirmacionCompraVm getConfirmacionCompraVmForEdition(Long idVentaOnline) {

        return getConfirmacionCompraVm(idVentaOnline);  //To change body of implemented methods use File | Settings | File Templates.
    }

    private ConfirmacionCompraVm getConfirmacionCompraVm(Long idVentaOnline) {
        VentaOnline ventaOnline=ventaOnlineRepository.findOne(idVentaOnline);
        ConfirmacionCompraVm confirmacionCompraVm=conversionService.convert(ventaOnline,ConfirmacionCompraVm.class);

        return confirmacionCompraVm;  //To change body of created methods use File | Settings | File Templates.
    }
}
