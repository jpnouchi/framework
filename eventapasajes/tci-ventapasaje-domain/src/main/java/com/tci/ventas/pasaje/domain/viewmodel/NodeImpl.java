package com.tci.ventas.pasaje.domain.viewmodel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * User: AW
 * Date: 08/04/13
 */
public class NodeImpl implements Node {

    private DataNode model;
    private boolean selectCheck;
    private boolean selectable;
    private boolean showLeaf;

    List<Node> children = new ArrayList<Node>();

    public NodeImpl() {
    }

    public NodeImpl(DataNode model, boolean showLeaf) {
        this.model = model;
        this.showLeaf = showLeaf;

        Set<DataNode> detail = model.getChildren();
        if(detail!=null){
            for (DataNode modulo : detail) {
                if(!modulo.isLeaf()|| showLeaf){
                    children.add(new NodeImpl(modulo,showLeaf));
                }
            }
        }

    }

    public DataNode getModel() {
        return model;
    }

    public void setModel(DataNode model) {
        this.model = model;
    }

    public Long getId() {
        return model.getId();
    }

    public boolean isSelectCheck() {
        return selectCheck;
    }

    public String getSelectCheckStr() {
        return selectCheck? "Si":"No";
    }

    public void setSelectCheck(boolean selectCheck) {
        this.selectCheck = selectCheck;
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean hasParent() {
        return model.hasParent();
    }

    @Override
    public String toString() {
        return model.toString();
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public boolean isShowable() {
        if(showLeaf){
            if(model.isLeaf() && isSelectable()){
                return true;
            }
            return children.size()>0 && hasLeafShowable();
        }
        if(isSelectable()){
            return true;
        }
        return children.size()>0 && hasLeafShowable();
    }

    private boolean hasLeafShowable(){
        for (Node child :children){
            if(child.isShowable()){
                return true;
            }
        }
        return false;
    }

}

