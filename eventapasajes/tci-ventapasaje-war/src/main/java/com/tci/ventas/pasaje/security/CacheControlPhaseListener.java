package com.tci.ventas.pasaje.security;

import javax.faces.application.ResourceHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: AW
 * Date: 24/02/13
 */
public class CacheControlPhaseListener implements PhaseListener
{
    public PhaseId getPhaseId()
    {
        return PhaseId.RENDER_RESPONSE;
    }

    public void afterPhase(PhaseEvent event)
    {
    }

    public void beforePhase(PhaseEvent event)
    {
        FacesContext facesContext = event.getFacesContext();
        HttpServletResponse response = (HttpServletResponse ) facesContext
                .getExternalContext().getResponse();

        HttpServletRequest  request  = (HttpServletRequest ) facesContext
                .getExternalContext().getRequest();

        if (!request.getRequestURI().startsWith(request.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER)) { // Skip JSF resources (CSS/JS/Images/etc)
            response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
            response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
            response.setDateHeader("Expires", 0); // Proxies.
        }
    }
}
