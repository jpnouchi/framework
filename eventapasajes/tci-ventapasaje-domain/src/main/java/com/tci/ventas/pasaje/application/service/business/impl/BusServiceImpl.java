package com.tci.ventas.pasaje.application.service.business.impl;

import java.util.Collections;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import com.tci.ventas.pasaje.application.service.business.intf.BusService;
import com.tci.ventas.pasaje.application.service.query.intf.BusQryService;
import com.tci.ventas.pasaje.domain.comparable.BusPisoPosicionVmComparable;
import com.tci.ventas.pasaje.domain.comparable.BusPisoVmComparable;
import com.tci.ventas.pasaje.domain.model.entity.Bus;
import com.tci.ventas.pasaje.domain.model.entity.BusPiso;
import com.tci.ventas.pasaje.domain.model.entity.BusPisoPosicion;
import com.tci.ventas.pasaje.domain.model.entity.BusPisoPosicionObjeto;
import com.tci.ventas.pasaje.domain.model.repository.BusRepository;
import com.tci.ventas.pasaje.domain.viewmodel.flt.BusFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionObjetoIdVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionObjetoVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoPosicionVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusPisoVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.BusVm;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ObjetoVm;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	ConversionService conversionService;

	@Autowired
	BusRepository busRepository;
	
	@Autowired
	BusQryService busQryService;
	
	
	
	protected final Logger LOG = LoggerFactory.getLogger(getClass());

	@Override
	public BusVm getBusVmToShow(BusFlt busFlt) {
		
		busFlt=busQryService.find(busFlt);
		Bus bus =  busRepository.findOne(busFlt.getIdBus());
		BusVm busVm = conversionService.convert(bus, BusVm.class);
		Iterator<BusPiso> itBusPiso = bus.getBusPisos().iterator();
		while(itBusPiso.hasNext()){
			//BusPiso busPiso = new BusPiso();
			BusPiso busPiso = itBusPiso.next();
			BusPisoVm busPisoVm = conversionService.convert(busPiso, BusPisoVm.class);
			Iterator<BusPisoPosicion> itBusPisoPosicion = busPiso.getBusPisoPosicions().iterator();
			while(itBusPisoPosicion.hasNext()){
				//BusPisoPosicion busPisoPosicion = new BusPisoPosicion();
				BusPisoPosicion busPisoPosicion = itBusPisoPosicion.next();
				BusPisoPosicionVm busPisoPosicionVm =  conversionService.convert(busPisoPosicion, BusPisoPosicionVm.class);
				Iterator<BusPisoPosicionObjeto> itBusPisoPosicionObjeto =  busPisoPosicion.getBusPisoPosicionObjetos().iterator();
				while(itBusPisoPosicionObjeto.hasNext()){
					//BusPisoPosicionObjeto busPisoPosicionObjeto = new BusPisoPosicionObjeto();
					BusPisoPosicionObjeto busPisoPosicionObjeto = itBusPisoPosicionObjeto.next();
					ObjetoVm objetoVm = conversionService.convert(busPisoPosicionObjeto.getObjeto(), ObjetoVm.class);
					BusPisoPosicionObjetoIdVm busPisoPosicionObjetoIdVm = conversionService.convert(busPisoPosicionObjeto.getId(), BusPisoPosicionObjetoIdVm.class);
					//BusPisoPosicionObjetoVm busPisoPosicionObjetoVm =  conversionService.convert(busPisoPosicionObjeto, BusPisoPosicionObjetoVm.class);
					
					BusPisoPosicionObjetoVm busPisoPosicionObjetoVm = new BusPisoPosicionObjetoVm();
					busPisoPosicionObjetoVm.setEtiqueta(busPisoPosicionObjeto.getEtiqueta());
					busPisoPosicionObjetoVm.setEstado(busPisoPosicionObjeto.getEstado());
					busPisoPosicionObjetoVm.setId(busPisoPosicionObjetoIdVm);
					busPisoPosicionObjetoVm.setObjeto(objetoVm);
					
					busPisoPosicionVm.getBusPisoPosicionObjetos().add(busPisoPosicionObjetoVm);
				}
				
				busPisoVm.getBusPisoPosicions().add(busPisoPosicionVm);
			}
			Collections.sort(busPisoVm.getBusPisoPosicions(), new BusPisoPosicionVmComparable());
			busVm.getBusPisos().add(busPisoVm);
		}
		
		Collections.sort(busVm.getBusPisos(), new BusPisoVmComparable());
		
		
		return busVm;
	}

}
