package com.tci.ventas.pasaje.security;

import com.tci.ventas.pasaje.application.service.AuditoriaService;
import com.tci.ventas.pasaje.enums.SesionAccionEnum;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

/**
 * User: AW
 * Date: 24/02/13
 */
public class AppSessionEventPublisher extends HttpSessionEventPublisher {

    @Override
    public void sessionCreated(HttpSessionEvent event) {
        super.sessionCreated(event);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            AuditoriaService service = getSesionService(event.getSession());
            service.logSesion(SesionAccionEnum.LOGOUT,(String)authentication.getPrincipal());
        }

        //do something
        super.sessionDestroyed(event);

    }

    private AuditoriaService getSesionService(HttpSession session) {
        ServletContext sc = session.getServletContext();
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sc);

        return (AuditoriaService) appContext.getBean("auditoriaServiceImpl");
    }
}
