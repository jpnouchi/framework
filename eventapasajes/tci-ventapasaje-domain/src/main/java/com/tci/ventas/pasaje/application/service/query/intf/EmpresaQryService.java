package com.tci.ventas.pasaje.application.service.query.intf;

import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.EmpresaRsl;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: jperalta
 * Date: 12/08/13
 * Time: 05:42 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmpresaQryService {
   EmpresaRsl findRuc(String numeroRuc);


	EmpresaFlt find(EmpresaFlt empresaFlt);

}
