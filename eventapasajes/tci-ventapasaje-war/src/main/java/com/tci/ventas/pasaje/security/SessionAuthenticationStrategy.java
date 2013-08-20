package com.tci.ventas.pasaje.security;

import com.tci.ventas.pasaje.application.service.AuditoriaService;
import com.tci.ventas.pasaje.enums.SesionAccionEnum;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.session.ConcurrentSessionControlStrategy;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * User: AW
 * Date: 24/02/13
 */
public class SessionAuthenticationStrategy extends ConcurrentSessionControlStrategy {

    //int MAX_USERS = 1000; // Whatever
    private SessionRegistry sessionRegistry;

    public SessionAuthenticationStrategy(SessionRegistry sessionRegistry) {
        super(sessionRegistry);
        this.sessionRegistry = sessionRegistry;
    }

    @Override
    public void onAuthentication(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {

        List<SessionInformation> sessionInformationList=
                sessionRegistry.getAllSessions(authentication.getPrincipal(), false);
         //Se invalidan las otras sesiones
        for(SessionInformation sessionInfo:sessionInformationList){

            if(!request.getSession().getId().equals(sessionInfo.getSessionId())){
                sessionInfo.expireNow();
            }

        }
/*
        if(sessionRegistry.getAllPrincipals().contains(authentication.getPrincipal())){
            throw new SessionAuthenticationException("The user already is logged in.");
        }

*/
        super.onAuthentication(authentication, request, response);

        if(authentication!=null){
            AuditoriaService service=getSesionService(request.getSession());
            service.logSesion(SesionAccionEnum.LOGIN,(String)authentication.getPrincipal());
        }
    }

    private AuditoriaService getSesionService(HttpSession session){
        ServletContext sc = session.getServletContext();
        WebApplicationContext appContext = WebApplicationContextUtils.getWebApplicationContext(sc);

        return (AuditoriaService)appContext.getBean("auditoriaServiceImpl");
    }
}

