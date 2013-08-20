package com.tci.ventas.pasaje.util;

public interface Constant {
	String CREATIVE_USER_COLUMN = "creado_por";
	String CREATION_DATE_COLUMN = "fecha_creacion";
	String MODIFIER_USER_COLUMN = "modificado_por";
	String MODIFICATION_DATE_COLUMN = "fecha_modificacion";
	
	//Generate Entities
	String JPA_ENTITY_BASE = "JpaEntityBase";
	String ENTITY_GENERATOR_USER = "gcruz";
	String APPLICACION_PREFIX = "vp";
	String MASTER_TABLE_PREFIX = "tm";
	String DETAIL_TABLE_PREFIX = "td";
	String RELATION_TABLE_PREFIX = "tr";
	String SEPARATOR_TABLE_NAME = "_";
	
	String OPCION_SOLO_IDA="IDA";
	String OPCION_IDA_RETORNO="IDA_RETORNO";
	String URL_PAGE_STEP_2="/pages/comprasOnline/fnFlujoCompraPaso2.jsf";
	String URL_PAGE_STEP_3="/pages/comprasOnline/fnFlujoCompraPaso3.jsf";
	String URL_PAGE_STEP_1="/pages/comprasOnline/fnFlujoCompraPaso1.jsf";
	
	String NOMBRE_TABLA_TIPO_DOCUMENTO="TIPO_DOCUMENTO";
	String NOMBRE_TABLA_PREFERENCIA_ALIMENTARIA="PREFERENCIA_ALIMENTARIA";
	String NOMBRE_TABLA_FORMA_PAGO="FORMA_PAGO";
	String NOMBRE_TABLA_TIPO_TARJETA="TIPO_TARJETA";
	String TARJETA_CREDITO_DEBITO="01";
    String URL_PAGE_STEP_CONFIRMACION_COMPRA="/pages/comprasOnline/fnConfirmacionCompra.jsf";
	String VISA="01";
	String FORMULARIO_CLIENTE="wvCliente";
	String DATATABLE_ITINERARIO_IDA="frmMain:dttResultadoIdaFlujoCompraPaso1";
	String DATATABLE_ITINERARIO_RETORNO="frmMain:dttResultadoRetornoFlujoCompraPaso1";
	
}
