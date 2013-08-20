package com.tci.ventas.pasaje.jsf;

import com.tci.jsf.FindCrudBeanBase;
import com.tci.ventas.pasaje.application.service.business.intf.ConfirmacionCompraService;
import com.tci.ventas.pasaje.application.service.query.intf.EmpresaQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.EmpresaRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ConfirmacionCompraVm;
import com.tci.ventas.pasaje.util.Constant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 06:29 PM
 * To change this template use File | Settings | File Templates.
 */
@ManagedBean
@Scope("session")
@Component
public class FNConfirmacionCompraJsfBean extends FindCrudBeanBase {
    protected final Logger LOG = LoggerFactory.getLogger(getClass());


    private ConfirmacionCompraVm confirmacionCompraVm;

    @Autowired
    private ConfirmacionCompraService confirmacionCompraVmService;

    @Autowired
    private EmpresaQryService empresaQryService;

    @Override
    public void init() {
        pageSufix = "ConfirmacionCompra";
        Long idVenta=1L;
        confirmacionCompraVm= confirmacionCompraVmService.getConfirmacionCompraVmForEdition(idVenta);
        setPropiedadesEmpresa(empresaQryService.findRuc(confirmacionCompraVm.getNumeroRuc()));


        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected void onFindAction() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void dirigirPasoConfirmacionCompra(ActionEvent actionEvent){

        LOG.info("ir al paso 3");


        getViewInfoMgr().goToPage(Constant.URL_PAGE_STEP_CONFIRMACION_COMPRA);

    }

    private void setPropiedadesEmpresa(EmpresaRsl empresaRsl){
        getConfirmacionCompraVm().setRazonSocial(empresaRsl.getRazonSocial());
        getConfirmacionCompraVm().setDireccion(empresaRsl.getDireccion());
        getConfirmacionCompraVm().setDominio(empresaRsl.getDominio());
        getConfirmacionCompraVm().setLogo(empresaRsl.getLogo());
        getConfirmacionCompraVm().setNumeroRuc(empresaRsl.getNumeroRuc());
        getConfirmacionCompraVm().setTelefono(empresaRsl.getTelefono());

    }

    public ConfirmacionCompraVm getConfirmacionCompraVm() {
        return confirmacionCompraVm;
    }

    public void setConfirmacionCompraVm(ConfirmacionCompraVm confirmacionCompraVm) {
        this.confirmacionCompraVm = confirmacionCompraVm;
    }
}
