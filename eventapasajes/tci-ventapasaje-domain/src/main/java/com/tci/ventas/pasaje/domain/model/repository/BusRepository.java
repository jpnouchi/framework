package com.tci.ventas.pasaje.domain.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.tci.ventas.pasaje.domain.model.entity.Bus;

public interface BusRepository extends CrudRepository<Bus, Long>
{

	Bus findOne(@Param("idBus")Long idBus);
	
}
