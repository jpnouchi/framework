package com.tci.ventas.pasaje.bean;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.tci.ventas.pasaje.domain.viewmodel.DataNode;
import com.tci.ventas.pasaje.domain.viewmodel.Node;
import com.tci.ventas.pasaje.domain.viewmodel.NodeImpl;

import java.util.*;

/**
 * User: AW
 * Date: 08/04/13
 */
public class CustomTreeNode extends DefaultTreeNode {
    List<Node> model;
    private TreeNode selectedNode;
    List<Node> selectedNodes = new ArrayList<Node>(10);
    private int defaultExpandedLevel = 3;

    public static TreeNode buildTreeNode(List list) {
        TreeNode root = new DefaultTreeNode();
        for (int i = 0; i < list.size(); i++) {
            TreeNode node = new DefaultTreeNode(list.get(i).toString(), list.get(i), root);
        }
        return root;
    }

    public CustomTreeNode(String type, Object data, TreeNode parent) {
        super(type, data, parent);
    }

    public CustomTreeNode(String data, List model) {
        super(data, null);
        this.model = model;
        procesar();
    }

    public CustomTreeNode(String data, List model, int defaultExpandedLevel) {
        super(data, null);
        this.model = model;
        this.defaultExpandedLevel = defaultExpandedLevel;
        procesar();
    }

    public TreeNode findNode(TreeNode node) {
        selectedNode = null;
        findNode(this, node);
        return selectedNode;
    }


    public void selectNode(TreeNode node) {
        findNode(this, node);
        if (selectedNode != null) {
            expandTree(selectedNode);
            selectedNode.setSelected(true);
        }
    }

    public void filterEnableableNode() {

        filterEnableableNode(this.getChildren());
    }

    public TreeNode getSelectedNode() {
        return selectedNode;
    }

    public List<Node> getSelectedNodes() {

        selectedNodes = new ArrayList<Node>(10);

        findSelectedNodes(model);

        return selectedNodes;
    }

    public static boolean existNode(Map<Long, CustomTreeNode> treeNodeMap, DataNode dataNode) {
        for (CustomTreeNode root : treeNodeMap.values()) {
            TreeNode node = new DefaultTreeNode(dataNode.toString(), dataNode, null);
            TreeNode found = root.findNode(node);
            if (found != null) {
                return true;
            }
        }
        return false;
    }

    public static CustomTreeNode getTreeNodesEnableable(Collection<? extends DataNode> allNodes,
                                                        Collection<? extends DataNode> nodesEnableable,
                                                        Collection<? extends DataNode> asignNodes, boolean showLeaf) {

        if (nodesEnableable != null && nodesEnableable.size() == 0){
            return new CustomTreeNode("treeModuleNode", new ArrayList<NodeImpl>(0));
        }
        List<NodeImpl> nodeList = new ArrayList<NodeImpl>();
        for (DataNode dataNode : allNodes) {
            nodeList.add(new NodeImpl(dataNode, showLeaf));
        }

        CustomTreeNode root = new CustomTreeNode("treeModuleNode", nodeList);
//            log.info("root: "+root);
//            log.info("root: "+root.getChildren());
        //Seleccionando los nodos disponibles
        if (nodesEnableable != null && nodesEnableable.size() > 0) {
            for (DataNode n : nodesEnableable) {
                TreeNode node = new DefaultTreeNode(n.toString(), n, null);
                TreeNode found = root.findNode(node);
                if (found != null) {
                    ((Node) found.getData()).setSelectable(true);
                }
            }

            root.filterEnableableNode();
        }
//            log.info("root: "+root);
//            log.info("root: "+root.getChildren());
        //Seleccionando los nodos asignados
        if (root.getChildren().size() > 0 && asignNodes != null) {
            for (DataNode op : asignNodes) {
                TreeNode node = new DefaultTreeNode(op.toString(), op, null);
                TreeNode found = root.findNode(node);
                if (found != null) {
                    ((NodeImpl) found.getData()).setSelectCheck(true);
                }
            }
        }
//        log.info("root: "+root);
//            log.info("root: "+root.getChildren());
        return root;
    }

    private void findSelectedNodes(List<Node> nodes) {
        for (Node node : nodes) {
            if (node.isSelectCheck()) {
                selectedNodes.add(node);
            }

            List<Node> children = node.getChildren();
            if (children != null && !children.isEmpty()) {
                findSelectedNodes(children);
            }
        }
    }

    private void filterEnableableNode(List<TreeNode> nodes) {
        List<TreeNode> children = new ArrayList<TreeNode>(nodes);

        for (TreeNode child : children) {
            if (((Node) child.getData()).isShowable()) {
                filterEnableableNode(child.getChildren());
            } else {
                nodes.remove(child);
            }
        }
    }

    private TreeNode findNode(TreeNode root, TreeNode node) {
        TreeNode child;
        for (int i = 0; i < root.getChildCount(); i++) {
            child = root.getChildren().get(i);
            if (child.getType().equals(node.getType())) {
                selectedNode = child;
                return child;
            }
            if (child.getChildCount() > 0) {
                findNode(child, node);
            }
        }
        return null;
    }

    private void expandTree(TreeNode node) {
        if (node.getParent() == null) {

        } else {
            expandTree(node.getParent());
            node.getParent().setExpanded(true);
        }
    }

    private TreeNode procesarIntern(TreeNode currentRoot, Node document) {
        TreeNode result = new CustomTreeNode(document.toString(), document, currentRoot);
        List<Node> children = document.getChildren();

        for (Node treeNodeDocument : children) {
            TreeNode subDocument = procesarIntern(result, treeNodeDocument);
        }
        return result;
    }


    private void procesar() {
        for (Iterator<Node> iterator = model.iterator(); iterator.hasNext();) {
            Node treeNodeDocument = iterator.next();
            if (!treeNodeDocument.hasParent()) {
                TreeNode node = procesarIntern(this, treeNodeDocument);
            }

        }
        expandTree(this.getChildren(), 0);
    }

    private void expandTree(List<TreeNode> nodes, int level) {
        if (level == defaultExpandedLevel) return;
        List<TreeNode> nodeList = new ArrayList<TreeNode>();

        for (TreeNode node : nodes) {
            if (node.getChildCount() > 0) {
                node.setExpanded(true);
                nodeList.addAll(node.getChildren());
            }
        }
        level++;
        expandTree(nodeList, level);
    }

    public List<Node> printTreeTable() {
        List<Node> nodesPrint = new ArrayList<Node>();
        for (TreeNode node : this.getChildren()) {
            printTreeTable(node, nodesPrint);
        }

        return nodesPrint;
    }

    private void printTreeTable(TreeNode node, List<Node> nodesToPrint) {
        nodesToPrint.add((Node) node.getData());
        for (TreeNode n : node.getChildren()) {
            printTreeTable(n, nodesToPrint);
        }
    }

    public int getDefaultExpandedLevel() {
        return defaultExpandedLevel;
    }

    public void setDefaultExpandedLevel(int defaultExpandedLevel) {
        this.defaultExpandedLevel = defaultExpandedLevel;
    }

}

