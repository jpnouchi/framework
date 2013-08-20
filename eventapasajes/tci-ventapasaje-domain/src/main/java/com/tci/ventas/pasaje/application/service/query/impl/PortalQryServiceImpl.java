package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.PortalQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.PortalFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.PortalRsl;

@Service
public class PortalQryServiceImpl implements PortalQryService {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<PortalRsl> find(PortalFlt portalFlt) {
		String sql = "select" +
				"  p.idPortal as idPortal," +
				"  p.path as path," +
                "  p.descripcion as descripcion," +
                "  p.logo as logo  " +
                "  from Portal p " +
                "  where p.estado = 0 ";
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.appendLike("p.descripcion","descripcion",portalFlt.getDescripcion(),true);
        sql +=whereBuilder.toString();
        sql += " order by p.descripcion ";
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(PortalRsl.class));
        return whereBuilder.populateParametersHbn(query)
                .list();
	}
	
	@Override
	public List<PortalRsl> findAll() {
		String sql = "select" +
				"  p.idPortal as idPortal," +
                "  p.descripcion as descripcion " +
                "  from Portal p " +
                "  where p.estado = 0 ";
        WhereBuilder whereBuilder = new WhereBuilder();
        sql +=whereBuilder.toString();
        sql += " order by p.descripcion ";
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(PortalRsl.class));
        return whereBuilder.populateParametersHbn(query)
                .list();
	}
}
