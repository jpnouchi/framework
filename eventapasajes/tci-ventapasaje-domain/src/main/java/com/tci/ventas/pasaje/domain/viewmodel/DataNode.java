package com.tci.ventas.pasaje.domain.viewmodel;

import java.io.Serializable;
import java.util.Set;

/**
 * User: AW
 * Date: 08/04/13
 */
public interface DataNode extends Serializable {
    Long getId();
    String getType();
    String getText();
    boolean isLeaf();
    boolean hasParent();
    Set<DataNode> getChildren();
}
