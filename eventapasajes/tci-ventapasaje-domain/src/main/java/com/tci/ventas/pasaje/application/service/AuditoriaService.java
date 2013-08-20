package com.tci.ventas.pasaje.application.service;

import com.tci.ventas.pasaje.enums.SesionAccionEnum;

/**
 * User: AW
 * Date: 24/02/13
 */
public interface AuditoriaService {

    void logSesion(SesionAccionEnum accion, String login);

}
