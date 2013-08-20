package com.tci.ventas.pasaje.jsf;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.tci.jsf.FindCrudBeanBase;
import com.tci.ventas.pasaje.application.service.business.intf.BusService;
import com.tci.ventas.pasaje.application.service.query.intf.EmpresaConfiguracionQryService;
import com.tci.ventas.pasaje.domain.enums.CustomerTypeEnum;
import com.tci.ventas.pasaje.domain.model.infraestructure.CustomerContextHolder;
import com.tci.ventas.pasaje.domain.viewmodel.flt.BusFlt;
import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaConfiguracionFlt;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.AsientoPasajeroVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.EmpresaConfiguracionVm;
import com.tci.ventas.pasaje.util.Constant;

@ManagedBean
@Scope("session")
@Component
public class FNFlujoCompraPaso2JsfBean extends FindCrudBeanBase<ItinerarioFlt, ItinerarioRsl> {

	private AsientoPasajeroVm asientoPasajeroVm;
	private List<EmpresaConfiguracionVm> tipoDocumentoList;
	private List<EmpresaConfiguracionVm> preferenciaAlimentariaList;
	private List<EmpresaConfiguracionVm> formaPagoList;
	private List<EmpresaConfiguracionVm> tipoTarjetaList;
	private FNFlujoCompraPaso1JsfBean fnFlujoCompraPaso1JsfBean;
	private ItinerarioRsl selectedItinerarioIda;
	private ItinerarioRsl selectedItinerarioRetorno;
	private BusFlt busFltIda;
	private BusFlt busFltRetorno;
	private String jsonBusIda;
	private String jsonBusRetorno;
	Gson gson = new Gson();

	
	@Autowired
	BusService busService; 
	@Autowired
	EmpresaConfiguracionQryService empresaConfiguracionQryService;
	

	public void init() {
		showMsgNoRecordFound=false;
		pageSufix = "FlujoCompraPaso2";
		CustomerContextHolder.setCustomerType(CustomerTypeEnum.VENTAS_ONLINE);
		asientoPasajeroVm=new AsientoPasajeroVm();
		String numeroRuc=getViewInfoMgr().getUsuarioDTO().getEmpresa().getRuc();
		EmpresaConfiguracionFlt empresaConfiguracionFlt = new EmpresaConfiguracionFlt();
		empresaConfiguracionFlt.setRuc(numeroRuc);
		
		empresaConfiguracionFlt.setNombreTabla(Constant.NOMBRE_TABLA_TIPO_DOCUMENTO);
		tipoDocumentoList=empresaConfiguracionQryService.find(empresaConfiguracionFlt);
		
		empresaConfiguracionFlt.setNombreTabla(Constant.NOMBRE_TABLA_FORMA_PAGO);
		formaPagoList=empresaConfiguracionQryService.find(empresaConfiguracionFlt);
		
		empresaConfiguracionFlt.setNombreTabla(Constant.NOMBRE_TABLA_TIPO_TARJETA);
		tipoTarjetaList=empresaConfiguracionQryService.find(empresaConfiguracionFlt);
		
		empresaConfiguracionFlt.setNombreTabla(Constant.NOMBRE_TABLA_PREFERENCIA_ALIMENTARIA);
		preferenciaAlimentariaList=empresaConfiguracionQryService.find(empresaConfiguracionFlt);
		
		getSelectedItinerarios();
		
	}

	@Override
	protected void onFindAction() {	}
	
	protected void createVmForCreation(){
		//portalVm = portalService.getPortalVmForCreation();
	}
	
	protected void createVmForEdition(ItinerarioRsl itinerarioRsl){
		//portalVm = portalService.getPortalVmForEdition(portalRsl.getIdPortal());
	}
	@Override
	protected void onDeleteAction(ItinerarioRsl itinerarioRsl){
		//portalService.delete(itinerarioRsl.getIdItinerario());
	}
	@Override
	protected void onSaveAction(){
		//validate(portalVm);
		//portalService.save(portalVm);
	}
	


	public AsientoPasajeroVm getAsientoPasajeroVm() {
		return asientoPasajeroVm;
	}

	public void setAsientoPasajeroVm(AsientoPasajeroVm asientoPasajeroVm) {
		this.asientoPasajeroVm = asientoPasajeroVm;
	}

	public void dirigirPaso3(ActionEvent actionEvent){
		
		getViewInfoMgr().goToPage(Constant.URL_PAGE_STEP_3);
	}
	
	public void dirigirPaso1(ActionEvent actionEvent){
		
		getViewInfoMgr().goToPage(Constant.URL_PAGE_STEP_1);
	}

	public void copyUserDataToCustomer(){
		LOG.info("copyUserDataToCustomer");
	}
	
	@Override
	protected void setDefaultValuesAfterClean() {
		
	}


	public List<EmpresaConfiguracionVm> getTipoDocumentoList() {
		return tipoDocumentoList;
	}

	public void setTipoDocumentoList(List<EmpresaConfiguracionVm> tipoDocumentoList) {
		this.tipoDocumentoList = tipoDocumentoList;
	}

	public List<EmpresaConfiguracionVm> getPreferenciaAlimentariaList() {
		return preferenciaAlimentariaList;
	}

	public void setPreferenciaAlimentariaList(
			List<EmpresaConfiguracionVm> preferenciaAlimentariaList) {
		this.preferenciaAlimentariaList = preferenciaAlimentariaList;
	}

	public List<EmpresaConfiguracionVm> getFormaPagoList() {
		return formaPagoList;
	}

	public void setFormaPagoList(List<EmpresaConfiguracionVm> formaPagoList) {
		this.formaPagoList = formaPagoList;
	}

	public List<EmpresaConfiguracionVm> getTipoTarjetaList() {
		return tipoTarjetaList;
	}

	public void setTipoTarjetaList(List<EmpresaConfiguracionVm> tipoTarjetaList) {
		this.tipoTarjetaList = tipoTarjetaList;
	}
	
	private void getSelectedItinerarios(){
		fnFlujoCompraPaso1JsfBean = (FNFlujoCompraPaso1JsfBean) getApplicationContext().getBean("fnFlujoCompraPaso1JsfBean");
		
		selectedItinerarioIda = fnFlujoCompraPaso1JsfBean.getSelectedItinerarioIda();
		selectedItinerarioRetorno = fnFlujoCompraPaso1JsfBean.getSelectedItinerarioRetorno();
		busFltIda=new BusFlt();
		busFltRetorno=new BusFlt();
		if(selectedItinerarioIda!=null && selectedItinerarioIda.getIdItinerarioLegacy()!=null){
			busFltIda.setIdBusLegacy(selectedItinerarioIda.getIdItinerarioLegacy());
			asientoPasajeroVm.setBusVmIda(busService.getBusVmToShow(busFltIda));
			setJsonBusIda(gson.toJson(asientoPasajeroVm.getBusVmIda()));
		}
		
		if(selectedItinerarioRetorno!=null && selectedItinerarioRetorno.getIdItinerarioLegacy()!=null){
			busFltRetorno.setIdBusLegacy(selectedItinerarioRetorno.getIdItinerarioLegacy());
			asientoPasajeroVm.setBusVmRetorno(busService.getBusVmToShow(busFltRetorno));
			setJsonBusRetorno(gson.toJson(asientoPasajeroVm.getBusVmRetorno()));
		}
		
	}

	public String getJsonBusIda() {
		return jsonBusIda;
	}

	public void setJsonBusIda(String jsonBusIda) {
		this.jsonBusIda = jsonBusIda;
	}

	public String getJsonBusRetorno() {
		return jsonBusRetorno;
	}

	public void setJsonBusRetorno(String jsonBusRetorno) {
		this.jsonBusRetorno = jsonBusRetorno;
	}

	
	
}
