package com.tci.ventas.pasaje.domain.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.tci.ventas.pasaje.domain.model.entity.Itinerario;

public interface ItinerarioRepository extends CrudRepository<Itinerario, Long>
{

	  //void deletePortal(@Param("idPasaje")Long idPasaje);
}
