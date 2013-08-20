package com.tci.ventas.pasaje.jsf;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tci.jsf.FindCrudBeanBase;
import com.tci.ventas.pasaje.application.service.business.intf.ClienteService;
import com.tci.ventas.pasaje.application.service.query.intf.ClienteQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ClienteFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ClienteRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ClienteVm;
import com.tci.ventas.pasaje.util.Constant;

@ManagedBean
@Scope("session")
@Component
public class FNClienteJsfBean extends FindCrudBeanBase<ClienteFlt, ClienteRsl> {
	protected final Logger LOG = LoggerFactory.getLogger(getClass());
	private ClienteVm clienteVm;



	@Autowired
	ClienteService clienteService;
	@Autowired
	ClienteQryService clienteQryService;
	
	@Override
	@PostConstruct
	public void init() {
		pageSufix = "Cliente";
		filter =  new ClienteFlt();
		resultList = new ArrayList<ClienteRsl>();
	}
	
	@Override
	protected void onFindAction() {
		resultList = clienteQryService.find(getFilter());		
	} 

	protected void createVmForCreation(){
		clienteVm = clienteService.getClienteVmForCreation();
	}
	
	protected void createVmForEdition(ClienteRsl clienteRsl){
		clienteVm = clienteService.getClienteVmForEdition(clienteRsl.getIdCliente());
	}
	
	@Override
	protected void onSaveAction(){
		validate(clienteVm);
		clienteService.save(clienteVm);
	}
	
	public ClienteVm getClienteVm() {
		return clienteVm;
	}

	public void setClienteVm(ClienteVm clienteVm) {
		this.clienteVm = clienteVm;
	}
	
	public void showModalNewCustomer(){
		
		RequestContext context = RequestContext.getCurrentInstance();
        String command = Constant.FORMULARIO_CLIENTE+".show()";
        context.execute(command);
	}
}
