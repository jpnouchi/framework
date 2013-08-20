package com.tci.ventas.pasaje.domain.model.repository;
/**
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tci.ventas.pasaje.domain.model.entity.Portal;

public interface PortalRepository extends CrudRepository<Portal, Long>{

	  @Modifying()
	  @Query("update Portal p set p.estado = 1 " +
	            " where p.idPortal =:idPasaje")
	  void deletePortal(@Param("idPasaje")Long idPasaje);
}
**/