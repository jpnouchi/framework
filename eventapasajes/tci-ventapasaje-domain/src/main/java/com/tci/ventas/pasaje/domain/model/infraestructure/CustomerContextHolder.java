package com.tci.ventas.pasaje.domain.model.infraestructure;

import com.tci.ventas.pasaje.domain.enums.CustomerTypeEnum;

public class CustomerContextHolder {

	   private static final ThreadLocal<CustomerTypeEnum> contextHolder =
	            new ThreadLocal<CustomerTypeEnum>();
	 
	   public static void setCustomerType(CustomerTypeEnum customerType) {
	      contextHolder.set(customerType);
	   }
	 
	   public static CustomerTypeEnum getCustomerType() {
	      return (CustomerTypeEnum) contextHolder.get();
	   }
	 
	   public static void clearCustomerType() {
	      contextHolder.remove();
	   }

}
