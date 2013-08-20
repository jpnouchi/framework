package com.tci.ventas.pasaje.application.service.query.impl;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.EmpresaQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaFlt;
import com.tci.ventas.pasaje.domain.viewmodel.rsl.EmpresaRsl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
public class EmpresaQryServiceImpl implements EmpresaQryService{

	@PersistenceContext
	private EntityManager em;

	@Override
	public EmpresaFlt find(EmpresaFlt empresaFlt) {
		
		String sql = "select" +
				"  e.idEmpresa as idEmpresa," +
				"  e.numeroRuc as numeroRuc," +
                "  e.idEmpresaLegacy as idEmpresaLegacy  " +
                "  from Empresa e " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.append("e.numeroRuc", "numeroRuc", empresaFlt.getNumeroRuc());
        
        sql +=whereBuilder.toString();
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(EmpresaFlt.class));
        return (EmpresaFlt)whereBuilder.populateParametersHbn(query).uniqueResult();
		
	}
	
	
 @Override
    public EmpresaRsl findRuc(String numeroRuc) {
        StringBuilder sql = new StringBuilder();
        sql.append("select ");
        sql.append("e.idEmpresa as idEmpresa,");
        sql.append("e.razonSocial as razonSocial,");
        sql.append("e.direccion as direccion,");
        sql.append("e.dominio as dominio,");
        sql.append("e.logo as logo,");
        sql.append("e.numeroRuc as numeroRuc,");
        sql.append("e.telefono as telefono ");
        sql.append("from Empresa e ");
        WhereBuilder whereBuilder = new WhereBuilder();
        whereBuilder.append("e.numeroRuc","numeroRuc",numeroRuc);
        sql.append(whereBuilder.toString());
        Query query = em.unwrap(Session.class).createQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(EmpresaRsl.class));

        return (EmpresaRsl)query.uniqueResult();  //To change body of implemented methods use File | Settings | File Templates.
    }

	
}
