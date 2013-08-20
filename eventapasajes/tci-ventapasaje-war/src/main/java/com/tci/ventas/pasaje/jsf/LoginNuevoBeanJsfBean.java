package com.tci.ventas.pasaje.jsf;

import com.tci.exception.TciValidationException;
import com.tci.jsf.FindCrudBeanBase;
import com.tci.seguridad.service.SecurityInfoService;
import com.tci.seguridad.service.SecurityService;
import com.tci.seguridad.service.TciAuthenticationToken;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * User: AW
 * Date: 24/02/13
 */
@ManagedBean
@Scope("session")
@Component
public class LoginNuevoBeanJsfBean extends FindCrudBeanBase {

    private String user = "";
    private String password = "";
    private String oldPassword = "";
    private String newPassword = "";
    private String confirmNewPassword = "";
    private String origen;
    private String errores;

    public final static String messageNewPasswordDifferent = "mensaje_nuevos_passwords_diferentes";
    public final static String messageUserRequired = "property_user_required";
    public final static String messageOldPasswordRequired = "property_oldPassword_required";
    public final static String messageNewPasswordRequired = "property_newPassword_required";
    public final static String messageConfirmNewPasswordRequired = "property_confirmNewPassword_required";
    public final static String messageLowLevelPasswordProtection = "mensaje_password_debil";

    private static final Logger LOG = LoggerFactory.getLogger(LoginNuevoBeanJsfBean.class);

    @Autowired
    protected SecurityService securityService;
    @Autowired
    protected SecurityInfoService securityInfoService;


    @PostConstruct
    public void init() {
        loadDialogChangePassword();
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(final String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }


    private void validate() {
        String nivelFortaleza = "";
        if (origen != null && origen.equals("portal")) {
            nivelFortaleza = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap().get("nivelFortaleza");
        } else {
            nivelFortaleza = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap().get("nivelFortaleza1");
        }
        LOG.info("nivelFortaleza: " + nivelFortaleza);
        if (user == null || user.trim().length() <= 0) {
            throw new TciValidationException(messageUserRequired);
        }
        if (oldPassword == null || oldPassword.trim().length() <= 0) {
            throw new TciValidationException(messageOldPasswordRequired);
        }
        if (newPassword == null || newPassword.trim().length() <= 0) {
            throw new TciValidationException(messageNewPasswordRequired);
        }
        if (confirmNewPassword == null || confirmNewPassword.trim().length() <= 0) {
            throw new TciValidationException(messageConfirmNewPasswordRequired);
        }
        if (!newPassword.equals(confirmNewPassword)) {
            throw new TciValidationException(messageNewPasswordDifferent);
        }
        if (nivelFortaleza.equals("0")) {
            throw new TciValidationException(messageLowLevelPasswordProtection);
        }
    }


    public void actualizarPassword(ActionEvent actionEvent) throws IOException, ServletException {
        LOG.info("actualizarPassword");
        RequestContext requestContext = RequestContext.getCurrentInstance();
        origen = (String) actionEvent.getComponent().getAttributes().get("origenCambio");
        validate();
        //try {
        // En la ventana el usuario no ingresa el password antiguo; por lo q no es necesario validar
        TciAuthenticationToken authentication = (TciAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        String portalId = (String) authentication.getPortal();
//        UsuarioDTO usuarioDTO = securityService.login(user, oldPassword, Long.parseLong(portal));
//        if (!usuarioDTO.isAuthenticated()) {
//            throw new TciBusinessException("Password incorrecto");
//        }
        securityService.updatePassword(user, oldPassword, newPassword);
        oldPassword = newPassword;
        newPassword = "";
        confirmNewPassword = "";
        String urlToRedirect = "main.jsf";
        try {
//            String portalId = UtilResource.getApplicationId();
            LOG.info("portalId: " + portalId);
            if (urlToRedirect == null || urlToRedirect.trim().length() <= 0) {
                urlToRedirect = "main.jsf";
            }
        } catch (Exception e) {
            LOG.info("" + e);
        }
        LOG.info(urlToRedirect);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        facesContext.getExternalContext()
                .redirect(urlToRedirect);
    }

    public void loadDialogChangePassword() {
        LOG.info("loadDialogChangePassword");
        TciAuthenticationToken token = (TciAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        if (token != null) {
            user = (String) token.getPrincipal();
            oldPassword = (String) token.getCredentials();
        }


    }


    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmNewPassword() {
        return confirmNewPassword;
    }

    public void setConfirmNewPassword(String confirmNewPassword) {
        this.confirmNewPassword = confirmNewPassword;
    }


    @Override
    protected void onFindAction() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public String getErrores() {
        return errores;
    }

    public void setErrores(String errores) {
        this.errores = errores;
    }

    private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

}

