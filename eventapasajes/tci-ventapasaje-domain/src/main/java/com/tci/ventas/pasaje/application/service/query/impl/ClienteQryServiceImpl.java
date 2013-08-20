package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.ClienteQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.ClienteFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.ClienteRsl;

@Service
public class ClienteQryServiceImpl implements ClienteQryService {

	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<ClienteRsl> find(ClienteFlt clienteFlt) {
	       String sql = "SELECT id_cliente AS idCliente " +
	               "FROM vptm_cliente " +
	               "WHERE estado = 0 ";
	       
	       WhereBuilder whereBuilder = new WhereBuilder();
	       whereBuilder.appendLike("id_cliente","id_cliente",clienteFlt.getIdCliente().toString(),true);
	       sql +=whereBuilder.toString();
	       
	       org.hibernate.Query query = em.unwrap(Session.class).createSQLQuery(sql).addScalar("idCliente",LongType.INSTANCE);
	       query.setResultTransformer(Transformers.aliasToBean(ClienteRsl.class));
	       return whereBuilder.populateParametersHbn(query).list();
	}

	@Override
	public List<ClienteRsl> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
