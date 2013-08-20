package com.tci.ventas.pasaje.security;

import org.springframework.security.authentication.ProviderNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.session.SessionAuthenticationException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: AW
 * Date: 24/02/13
 */
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        if(exception instanceof SessionAuthenticationException){
            setDefaultFailureUrl("/login.jsf?authSessionjFailure=err");
        } else if(exception instanceof ProviderNotFoundException){
            setDefaultFailureUrl("/login.jsf?authFailure=err");
        }else{
            setDefaultFailureUrl("/login.jsf?authFailure=err");
        }

        super.onAuthenticationFailure(request,response,exception);
    }
}
