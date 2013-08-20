package com.tci.ventas.pasaje.application.service;

import com.tci.ventas.pasaje.enums.SesionAccionEnum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: AW
 * Date: 24/02/13
 */
@Service
public class AuditoriaServiceImpl implements AuditoriaService {
    public static final Logger LOG = LoggerFactory.getLogger("auditorialog");

    public void logSesion(SesionAccionEnum accion, String login) {
        if (login != null) {
            LOG.info("Session Action:{} user: {}", new Object[]{accion, login});
        }
    }
}
