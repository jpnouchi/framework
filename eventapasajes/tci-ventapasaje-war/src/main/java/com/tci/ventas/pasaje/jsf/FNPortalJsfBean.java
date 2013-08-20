package com.tci.ventas.pasaje.jsf;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tci.jsf.FindCrudBeanBase;
import com.tci.ventas.pasaje.application.service.business.intf.PortalService;
import com.tci.ventas.pasaje.application.service.query.intf.PortalQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.PortalFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.PortalRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.PortalVm;

@ManagedBean
@Scope("session")
@Component
public class FNPortalJsfBean extends FindCrudBeanBase<PortalFlt, PortalRsl> {
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	private PortalVm portalVm;
	@Autowired
	PortalService portalService;
	@Autowired
	PortalQryService portalQryService;

	public void init() {
		pageSufix = "Portal";
		filter =  new PortalFlt();
		resultList = new ArrayList<PortalRsl>();
		executeFindAction();
	}

	@Override
	protected void onFindAction() {
		resultList = portalQryService.find(getFilter());
	}
	
	protected void createVmForCreation(){
		portalVm = portalService.getPortalVmForCreation();
	}
	
	protected void createVmForEdition(PortalRsl portalRsl){
		portalVm = portalService.getPortalVmForEdition(portalRsl.getIdPortal());
	}
	@Override
	protected void onDeleteAction(PortalRsl portalRsl){
		portalService.delete(portalRsl.getIdPortal());
	}
	@Override
	protected void onSaveAction(){
		validate(portalVm);
		portalService.save(portalVm);
	}

	public PortalVm getPortalVm() {
		return portalVm;
	}

	public void setPortalVm(PortalVm portalVm) {
		this.portalVm = portalVm;
	}

	
	
	
	

}
