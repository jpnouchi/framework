package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.ServicioQryService;
import com.tci.ventas.pasaje.domain.viewmodel.vm.ServicioVm;

@Service
public class ServicioQryServiceImpl implements ServicioQryService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<ServicioVm> findAll() {
		
		String sql = "select" +
				"  s.idServicio as idServicio," +
				"  s.nombreServicio as nombreServicio," +
                "  s.idServicioLegacy as idServicioLegacy  " +
                "  from Servicio s " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();

        sql +=whereBuilder.toString();
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(ServicioVm.class));
        return whereBuilder.populateParametersHbn(query).list();
		
	}
	
	
}
