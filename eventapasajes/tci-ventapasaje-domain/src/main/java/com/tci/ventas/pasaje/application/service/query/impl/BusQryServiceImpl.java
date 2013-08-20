package com.tci.ventas.pasaje.application.service.query.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.BusQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.BusFlt;

@Service
public class BusQryServiceImpl implements BusQryService{

	
	@PersistenceContext
	private EntityManager em;

	@Override
	public BusFlt find(BusFlt busFlt) {
		
		String sql = "select" +
				"  bus.idBus as idBus," +
                "  bus.idBusLegacy as idBusLegacy  " +
                "  from Bus bus " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder.append("bus.idBusLegacy", "idBusLegacy", busFlt.getIdBusLegacy());
        //whereBuilder.append("bus.estado", "estado", busFlt.getIdBusLegacy());
        sql +=whereBuilder.toString();
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(BusFlt.class));
        return (BusFlt)whereBuilder.populateParametersHbn(query).uniqueResult();
		
	}
	
	
}
