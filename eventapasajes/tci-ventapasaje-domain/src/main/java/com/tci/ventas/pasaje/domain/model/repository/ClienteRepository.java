package com.tci.ventas.pasaje.domain.model.repository;

import org.springframework.data.repository.CrudRepository;

import com.tci.ventas.pasaje.domain.model.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> 
{
	
}
