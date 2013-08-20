package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.CiudadQryService;
import com.tci.ventas.pasaje.domain.viewmodel.vm.CiudadVm;

@Service
public class CiudadQryServiceImpl implements CiudadQryService{

	@PersistenceContext
	private EntityManager em;

	
	@Override
	public List<CiudadVm> findAll() {
		
		String sql = "select" +
				"  c.idCiudad as idCiudad," +
				"  c.idCiudadLegacy as idCiudadLegacy," +
				"  c.nombre as nombre " +
                "  from Ciudad c " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();
        
    	sql +=whereBuilder.toString();
    	Session session= em.unwrap(Session.class);
    	org.hibernate.Query query = session.createQuery(sql);
    	em.createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(CiudadVm.class));
        return whereBuilder.populateParametersHbn(query).list();

	}
	
	
}
