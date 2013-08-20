package com.tci.ventas.pasaje.domain.viewmodel;

import java.io.Serializable;
import java.util.List;

/**
 * User: AW
 * Date: 08/04/13
 */
public interface Node extends Serializable {

    Object getId();
    DataNode getModel();
    boolean isSelectCheck();
    boolean hasParent();
    void setSelectCheck(boolean select);
    List<Node> getChildren();
    boolean isSelectable();
    void setSelectable(boolean selectable) ;
    boolean isShowable();
}
