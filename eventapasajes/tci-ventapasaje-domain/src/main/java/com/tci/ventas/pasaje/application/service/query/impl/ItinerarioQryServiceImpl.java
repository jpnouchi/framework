package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.ItinerarioQryService;
import com.tci.ventas.pasaje.domain.model.infraestructure.CustomerRoutingDataSource;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ItinerarioFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ItinerarioRsl;

@Service
public class ItinerarioQryServiceImpl implements ItinerarioQryService{

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<ItinerarioRsl> find(ItinerarioFlt itinerarioFlt) {

		String sql = "select" +
				"  it.idItinerario as idItinerario," +
				"  it.idItinerarioLegacy as idItinerarioLegacy," +
				"  it.idBusLegacy as idBusLegacy," +
                "  it.origen as origen," +
                "  it.destino as destino,  " +
                "  it.servicio as servicio,  " +
                "  it.fechaSalida as fechaSalida,  " +
                "  it.numeroAsientoLibre as numeroAsientoLibre,  " +
                "  it.precioPiso1 as precioPiso1,  " +
                "  it.precioPiso2 as precioPiso2  " +
                "  from Itinerario it " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();
        
        whereBuilder.append("it.idEmpresaLegacy", "idEmpresaLegacy", itinerarioFlt.getIdEmpresaLegacy());
        whereBuilder.append("it.idCiudadOrigenLegacy", "idCiudadOrigenLegacy", itinerarioFlt.getIdCiudadOrigenLegacy());
        whereBuilder.append("it.idCiudadDestinoLegacy", "idCiudadDestinoLegacy", itinerarioFlt.getIdCiudadDestinoLegacy());
        whereBuilder.append("it.idServicioLegacy", "idServicioLegacy", itinerarioFlt.getIdServicioLegacy());
        whereBuilder.appendDate("it.fechaSalida", "fechaSalida", itinerarioFlt.getFechaSalida());
        sql +=whereBuilder.toString();
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(ItinerarioRsl.class));
        return whereBuilder.populateParametersHbn(query)
                .list();
	}
	
	@Override
	public List<ItinerarioRsl> findAll() {
		
		return null;
	}
}
