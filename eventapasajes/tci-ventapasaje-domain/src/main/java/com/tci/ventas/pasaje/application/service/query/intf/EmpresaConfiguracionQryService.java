package com.tci.ventas.pasaje.application.service.query.intf;

import java.util.List;

import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaConfiguracionFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.EmpresaConfiguracionVm;

public interface EmpresaConfiguracionQryService {
	List<EmpresaConfiguracionVm> find(EmpresaConfiguracionFlt empresaConfiguracionFlt);

}
