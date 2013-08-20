package com.tci.ventas.pasaje.domain.viewmodel.vm;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class VoucherVm implements Serializable {
	private Long idPortal;
	@NotEmpty
	private String descripcion;
	@NotEmpty
	private String path;
	@NotEmpty
	private String logo;
	private Boolean estado=false;

	private String creadoPor;
	private Date fechaCreacion;
	private String modificadoPor;
	private Date fechaModificacion;


}
