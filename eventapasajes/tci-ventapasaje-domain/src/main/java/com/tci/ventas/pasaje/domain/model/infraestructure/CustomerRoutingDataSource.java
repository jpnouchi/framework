package com.tci.ventas.pasaje.domain.model.infraestructure;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class CustomerRoutingDataSource extends AbstractRoutingDataSource {

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return CustomerContextHolder.getCustomerType();

	}
	
	@Override
	public Connection getConnection() throws SQLException {

		return super.getConnection();
	}

}
