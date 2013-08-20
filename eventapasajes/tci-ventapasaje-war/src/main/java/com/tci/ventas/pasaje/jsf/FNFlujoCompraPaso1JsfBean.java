package com.tci.ventas.pasaje.jsf;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.tci.exception.TciValidationException;
import com.tci.jsf.FindCrudBeanBase;
import com.tci.jsf.ViewConstant;
import com.tci.ventas.pasaje.application.service.business.intf.ItinerarioService;
import com.tci.ventas.pasaje.application.service.query.intf.CiudadQryService;
import com.tci.ventas.pasaje.application.service.query.intf.EmpresaQryService;
import com.tci.ventas.pasaje.application.service.query.intf.ItinerarioQryService;
import com.tci.ventas.pasaje.application.service.query.intf.ServicioQryService;
import com.tci.ventas.pasaje.datamodel.ItinerarioDataModel;
import com.tci.ventas.pasaje.domain.enums.CustomerTypeEnum;
import com.tci.ventas.pasaje.domain.model.infraestructure.CustomerContextHolder;
import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaFlt;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.PortalRsl;
import com.tci.ventas.pasaje.domain.viewmodel.vm.CiudadVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ServicioVm;
import com.tci.ventas.pasaje.util.Constant;
import com.tci.ventas.pasaje.util.StringUtil;

@ManagedBean
@Scope("session")
@Component
public class FNFlujoCompraPaso1JsfBean extends FindCrudBeanBase<ItinerarioFlt, ItinerarioRsl> {

	private List<CiudadVm> origenList;
	private List<CiudadVm> destinoList;
	private List<ServicioVm> servicioList;
	private List<ItinerarioRsl> resultListRetorno;
	
	private ItinerarioRsl  selectedItinerarioRetorno;
	private ItinerarioRsl  selectedItinerarioIda;
	
	private ItinerarioDataModel itinerarioIdaModel; 
	private ItinerarioDataModel itinerarioRetornoModel;
	EmpresaFlt empresaFlt;
	
//	private DataTable dataTableIda;
//	private DataTable dataTableRetorno;

	
	@Autowired
	ItinerarioService itinerarioService;
	@Autowired
	ItinerarioQryService itinerarioQryService;

	@Autowired
	ServicioQryService servicioQryService;
	
	@Autowired
	CiudadQryService ciudadQryService;
	
	@Autowired
	EmpresaQryService empresaQryService;
	
	public void init() {
		showMsgNoRecordFound=false;
		pageSufix = "FlujoCompraPaso1";
//		dataTableIda=new DataTable();
//		dataTableRetorno=new DataTable();
		empresaFlt= new EmpresaFlt();
		filter =  new ItinerarioFlt();
		
		resultList = new ArrayList<ItinerarioRsl>();
		resultListRetorno = new ArrayList<ItinerarioRsl>();
		
		itinerarioIdaModel=new ItinerarioDataModel(resultList);
		itinerarioRetornoModel=new ItinerarioDataModel(resultListRetorno);
		
//		dataTableIda.setValue(itinerarioIdaModel);
//		dataTableRetorno.setValue(itinerarioRetornoModel);
		
		filter.setOpcionViaje("IDA");
		CustomerContextHolder.setCustomerType(CustomerTypeEnum.VENTAS_ONLINE);
		origenList=ciudadQryService.findAll();
		destinoList=ciudadQryService.findAll();
		servicioList=servicioQryService.findAll();

	}

	@Override
	protected void onFindAction() {
		
		if(StringUtil.isEmpty(empresaFlt.getNumeroRuc())){
			empresaFlt.setNumeroRuc(getViewInfoMgr().getUsuarioDTO().getEmpresa().getRuc());
			empresaFlt=empresaQryService.find(empresaFlt);
			filter.setIdEmpresaLegacy(empresaFlt.getIdEmpresaLegacy());
		}
		
		validate(itinerarioService.getItinerarioVmForValidation(getFilter()));
		itinerarioService.getItinerarioFltForQuery(getFilter());
		CustomerContextHolder.setCustomerType(CustomerTypeEnum.VENTAS_LEGACY);
		//resetPageDataTables();
		resultList = itinerarioQryService.find(getFilter());
		
		resultListRetorno = new ArrayList<ItinerarioRsl>();
		if(filter.getOpcionViaje().equals(Constant.OPCION_IDA_RETORNO)){
			ItinerarioFlt itinerarioFlt= new ItinerarioFlt();
			itinerarioFlt.setIdCiudadOrigenLegacy(filter.getIdCiudadDestinoLegacy());
			itinerarioFlt.setIdCiudadDestinoLegacy(filter.getIdCiudadOrigenLegacy());
			itinerarioFlt.setIdServicioLegacy(filter.getIdServicioLegacy());
			itinerarioFlt.setFechaSalida(filter.getFechaRetorno());
			itinerarioFlt.setIdEmpresaLegacy(empresaFlt.getIdEmpresaLegacy());
			resultListRetorno=itinerarioQryService.find(itinerarioFlt);
		}
		itinerarioIdaModel=new ItinerarioDataModel(resultList);
		itinerarioRetornoModel=new ItinerarioDataModel(resultListRetorno);
//		dataTableIda.setValue(itinerarioIdaModel);
//		dataTableRetorno.setValue(itinerarioRetornoModel);
	}
	
	protected void createVmForCreation(){
		//portalVm = portalService.getPortalVmForCreation();
	}
	
	protected void createVmForEdition(PortalRsl portalRsl){
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

	public List<CiudadVm> getOrigenList() {
		return origenList;
	}

	public void setOrigenList(List<CiudadVm> origenList) {
		this.origenList = origenList;
	}

	public List<CiudadVm> getDestinoList() {
		return destinoList;
	}

	public void setDestinoList(List<CiudadVm> destinoList) {
		this.destinoList = destinoList;
	}

	public List<ServicioVm> getServicioList() {
		return servicioList;
	}

	public void setServicioList(List<ServicioVm> servicioList) {
		this.servicioList = servicioList;
	}

	
	
	public void dirigirPaso2(ActionEvent actionEvent){
		
		if(getSelectedItinerarioIda()==null){
			throw new TciValidationException(getMessage("comprar.pasaje.itinerario.no.seleccionado"));
		}
		
		if(filter.getOpcionViaje().equals(Constant.OPCION_IDA_RETORNO) && getSelectedItinerarioRetorno()==null ){
			throw new TciValidationException(getMessage("comprar.pasaje.itinerario.no.seleccionado"));
		}
		
		getViewInfoMgr().goToPage(Constant.URL_PAGE_STEP_2);
		
	}

	@Override
	protected void setDefaultValuesAfterClean() {
		resultListRetorno = new ArrayList<ItinerarioRsl>();
		itinerarioIdaModel=new ItinerarioDataModel(resultList);
		itinerarioRetornoModel=new ItinerarioDataModel(resultListRetorno);
		filter.setIdEmpresaLegacy(empresaFlt.getIdEmpresaLegacy());
		filter.setOpcionViaje("IDA");
	}
	
	public Integer getResultListRetornoSize() {
        return resultListRetorno != null ? resultListRetorno.size() : 0;
    }

	public List<ItinerarioRsl> getResultListRetorno() {
		return resultListRetorno;
	}
	
	public String showLabelPrice(Double price){
		Object[] parameters=null;
		return (price!=null && price.floatValue()>0)? price.toString() : getMessage("label_precio_no_disponible", parameters); 
			
	}

	public ItinerarioDataModel getItinerarioIdaModel() {
		return itinerarioIdaModel;
	}

	public void setItinerarioIdaModel(ItinerarioDataModel itinerarioIdaModel) {
		this.itinerarioIdaModel = itinerarioIdaModel;
	}

	public ItinerarioDataModel getItinerarioRetornoModel() {
		return itinerarioRetornoModel;
	}

	public void setItinerarioRetornoModel(ItinerarioDataModel itinerarioRetornoModel) {
		this.itinerarioRetornoModel = itinerarioRetornoModel;
	}

	
	public ItinerarioRsl getSelectedItinerarioRetorno() {
		return selectedItinerarioRetorno;
	}

	public void setSelectedItinerarioRetorno(ItinerarioRsl selectedItinerarioRetorno) {
		this.selectedItinerarioRetorno = selectedItinerarioRetorno;
	}

	public ItinerarioRsl getSelectedItinerarioIda() {
		return selectedItinerarioIda;
	}

	public void setSelectedItinerarioIda(ItinerarioRsl selectedItinerarioIda) {
		this.selectedItinerarioIda = selectedItinerarioIda;
	}
	
	public void onRowSelectItinerarioIda(SelectEvent event) {  
			selectedItinerarioIda = (ItinerarioRsl) event.getObject();  
    }
	
	public void onRowSelectItinerarioRetorno(SelectEvent event) {  
		selectedItinerarioRetorno = (ItinerarioRsl) event.getObject();  
	}
	
	protected void cleanSelectedRowsVars() {
		super.cleanSelectedRowsVars();
        setSelectedItinerarioIda(null);
        setSelectedItinerarioRetorno(null);
        
    }

	public void resetPageDataTables(){
		resetPageDataTable(Constant.DATATABLE_ITINERARIO_IDA);
		resetPageDataTable(Constant.DATATABLE_ITINERARIO_RETORNO);
	}
    public void dirigirPasoConfirmacionCompra(ActionEvent actionEvent){

        LOG.info("ir al paso 3");

//        if(getSelectedItinerarioIda()==null){
//            throw new TciValidationException(getMessage("comprar.pasaje.itinerario.no.seleccionado"));
//        }
//
//        if(filter.getOpcionViaje().equals(Constant.OPCION_IDA_RETORNO) && getSelectedItinerarioRetorno()==null ){
//            throw new TciValidationException(getMessage("comprar.pasaje.itinerario.no.seleccionado"));
//        }

        getViewInfoMgr().goToPage(Constant.URL_PAGE_STEP_CONFIRMACION_COMPRA);

    }


	
	public void resetPageDataTable(String id) {
		UIViewRoot view =(UIViewRoot)FacesContext.getCurrentInstance().getViewRoot();
		final DataTable dataTable = (DataTable) view.findComponent(id);
		dataTable.setFirst(0);
		
	}

//	public DataTable getDataTableIda() {
//		return dataTableIda;
//	}
//
//	public void setDataTableIda(DataTable dataTableIda) {
//		this.dataTableIda = dataTableIda;
//	}
//
//	public DataTable getDataTableRetorno() {
//		return dataTableRetorno;
//	}
//
//	public void setDataTableRetorno(DataTable dataTableRetorno) {
//		this.dataTableRetorno = dataTableRetorno;
//	}
	
//	private void createDataTable(DataTable dataTable, String id, ItinerarioDataModel itinerarioDataModel, String variable){
//		dataTable.setId(id);
//		dataTable.setValue(itinerarioDataModel);
//		dataTable.setVar(variable);
//		dataTable.setRowKey();
//		
//		
//		dataTable.setPaginator();
//		
//		
//		
//	}
	
	public boolean isShowablePaginatorIda(){
		return this.isShowablePaginator();
	}
	
	public boolean isShowablePaginatorRetorno(){
		return getResultListRetornoSize() > ViewConstant.INIT_ROWS_PER_RESULT_PAGE;
	}

}
