package com.tci.ventas.pasaje.jsf;

import com.tci.jsf.FindCrudBeanBase;
import com.tci.jsf.component.AWTreeNode;
import com.tci.seguridad.service.SecurityService;
import com.tci.seguridad.service.TciAuthenticationToken;
import com.tci.seguridad.service.ws.dto.RolEmpresarialDTO;
import com.tci.seguridad.service.ws.dto.UsuarioDTO;
import com.tci.ventas.pasaje.infrastructure.persistence.util.ApplicationProperties;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.TreeNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User: AW
 * Date: 24/02/13
 */
@ManagedBean
@Scope("session")
@Component
public class InfoUsuarioBean extends FindCrudBeanBase {
    private static final Logger LOG = LoggerFactory.getLogger(InfoUsuarioBean.class);

    @Autowired
    SecurityService securityService;


    private UsuarioDTO usuario = new UsuarioDTO();

    private List<RolEmpresarialDTO> rolFuncionalList = new ArrayList<RolEmpresarialDTO>();

    private RolEmpresarialDTO rolFuncional = new RolEmpresarialDTO();

//    private List<PerfilDTO> perfilList = new ArrayList<PerfilDTO>();

//    private PerfilDTO perfil = new PerfilDTO();

    private TreeNode selectedModuleNode = new AWTreeNode("", new ArrayList());

    private TreeNode treeModuleNode = new AWTreeNode("", new ArrayList(0));


    @PostConstruct
    public void init() {
        LOG.info("Inicializando InfoUsuarioBean ");
        TciAuthenticationToken authentication = (TciAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        selectedModuleNode = new AWTreeNode("", new ArrayList());
        treeModuleNode = new AWTreeNode("", new ArrayList(0));
    }

    public void onClean(ActionEvent actionEvent) {

    }

    public void onNewRecord(ActionEvent actionEvent) {
//        perfil = new PerfilDTO();
    }

    //================================================================================
    // Modal Handlers
    //================================================================================
    public void onPerfilRowSelect(SelectEvent se) {
    }


    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }


    public TreeNode getSelectedModuleNode() {
        return selectedModuleNode;
    }

    public void setSelectedModuleNode(TreeNode selectedPerfilNode) {
        this.selectedModuleNode = selectedPerfilNode;
    }

    public TreeNode getTreeModuleNode() {
        return treeModuleNode;
    }

    public void setTreeModuleNode(TreeNode treePerfilNode) {
        this.treeModuleNode = treePerfilNode;
    }


    private Date serverTime;

    public Date getServerTime() {
        return serverTime != null ? serverTime : new Date();
    }

    public void setServerTime(Date serverTime) {
        this.serverTime = serverTime;
    }

    public void actualizarServerTime(){
        setServerTime(new Date());
    }

    public Long getInvertvalUpdate(){
        return 1l;
    }

    @Override
    protected void onFindAction() {

    }

    private String page;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
