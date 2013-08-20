package com.tci.ventas.pasaje.application.service.query.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Service;

import com.tci.infrastructure.persistence.jpa.WhereBuilder;
import com.tci.ventas.pasaje.application.service.query.intf.EmpresaConfiguracionQryService;
import com.tci.ventas.pasaje.domain.viewmodel.flt.EmpresaConfiguracionFlt;
import com.tci.ventas.pasaje.domain.viewmodel.vm.EmpresaConfiguracionVm;

@Service
public class EmpresaConfiguracionQryServiceImpl implements EmpresaConfiguracionQryService{

	@PersistenceContext
	private EntityManager em;


    public List<EmpresaConfiguracionVm> find(EmpresaConfiguracionFlt empresaConfiguracionFlt) {
        String sql = "select" +
                "  ec.idConfiguracion as idConfiguracion," +
                "  ec.nombreTabla as nombreTabla," +
                "  ec.codigo as codigo," +
                "  ec.valor as valor  " +
                "  from EmpresaConfiguracion ec " +
                "  where 1 = 1 ";
        WhereBuilder whereBuilder = new WhereBuilder();

        whereBuilder.append("ec.nombreTabla", "nombreTabla", empresaConfiguracionFlt.getNombreTabla());
        whereBuilder.append("ec.empresa.numeroRuc", "numeroRuc", empresaConfiguracionFlt.getRuc());

        sql +=whereBuilder.toString();
        org.hibernate.Query query = em.unwrap(Session.class).createQuery(sql);
        query.setResultTransformer(Transformers.aliasToBean(EmpresaConfiguracionVm.class));
        return whereBuilder.populateParametersHbn(query)
                .list();
    }
}
