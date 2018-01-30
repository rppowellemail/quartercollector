package com.rppowellemail.quartercollector.quartercollector;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rpowell on 1/29/18.
 */

public class TreeNode {

    private TreeNode parent;
    private String name;
    private ArrayList<TreeNode> nodes;
    private boolean completed;
    private boolean expanded;

    public TreeNode(TreeNode parent, String name) {
        this.parent = parent;
        this.name = name;
        this.nodes = new ArrayList<TreeNode>();
        this.expanded = true;
        this.completed = false;
    }

    public TreeNode(TreeNode parent, String name, boolean expanded, boolean completed) {
        this.parent = parent;
        this.name = name;
        this.nodes = new ArrayList<TreeNode>();
        this.expanded = expanded;
        this.completed = completed;
    }

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    public int countParents() {
        int c = 0;
        for(TreeNode t = this; t != null; t=t.getParent()) {
            c++;
        }
        return c;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean hasChildren() {
        return (nodes.size() != 0);
    }
    public ArrayList<TreeNode> getChildren() {
        return this.nodes;
    }
    public ArrayList<TreeNode> getNodes() {
        return this.nodes;
    }


    public boolean isExpanded() {
        //Log.d("TreeNode", this + " isExpanded:" + isExpanded);
        return this.expanded;
    }
    public void setExpanded(boolean b) {
        //Log.d("TreeNode", this + " setExpanded:" + isExpanded + " -> " + b);
        this.expanded = b;
    }

    public boolean isCompleted() {
        return this.completed;
    }

    public void setCompleted(boolean b) {
        this.completed = b;
    }


    public ArrayList<TreeNode> toArrayList() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        for (TreeNode t: nodes ) {
            n.addAll(t.toArrayList());
        }
        return n;
    }

    public ArrayList<TreeNode> getAllNodes() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        for (TreeNode t: nodes ) {
            n.addAll(t.getAllNodes());
        }
        return n;
    }

    public ArrayList<TreeNode> getAllVisibleNodes() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        for (TreeNode t: nodes ) {
            if (!isExpanded()) {
                n.addAll(t.getAllVisibleNodes());
            }
        }
        return n;
    }

    public static void logThisTreeNode(TreeNode t) {
        TreeNode p = t.getParent();
        String parentName;
        if(p != null) {
            parentName = p.toString();
        } else {
            parentName = "null";
        }
        Log.d("logTreeNodes", "parent:" + parentName + ", name:'" + t.getName() + "', hasChildren("+t.hasChildren() + ") isExpanded("+t.isExpanded()+") isCompleted("+t.isCompleted()+")");
    }

    public static void logTreeNodes(TreeNode t) {
        logThisTreeNode(t);
        if(t.hasChildren()) {
            for (TreeNode child : t.getChildren()) {
                logTreeNodes(child);
            }
        }
    }

    public ArrayList<TreeNode> getVisibleNodes() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        if (isExpanded()) {
            for (TreeNode t: this.getChildren() ) {
                n.addAll(t.getVisibleNodes());
            }
        }
        return n;
    }

    public static TreeNode[] generateTreeNodes1() {
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

        treeNodes.add(new TreeNode(null, "TreeNode 1", true, false));
        treeNodes.add(new TreeNode(null, "TreeNode 2", true, false));
        treeNodes.get(1).getChildren().add(new TreeNode(treeNodes.get(1), "TreeNode 2.1", true,false));
        treeNodes.get(1).getChildren().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2", true,false));
        treeNodes.get(1).getChildren().get(1).getChildren().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2.1", true,false));
        treeNodes.get(1).getChildren().get(1).getChildren().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2.2", true,false));
        treeNodes.get(1).getChildren().add(new TreeNode(treeNodes.get(1), "TreeNode 2.3", true, false));
        treeNodes.add(new TreeNode(null, "TreeNode 3", true, false));
        treeNodes.get(2).getChildren().add(new TreeNode(treeNodes.get(2), "TreeNode 3.1", true, false));
        treeNodes.get(2).getChildren().add(new TreeNode(treeNodes.get(2), "TreeNode 3.2", true, false));
        TreeNode[] a = treeNodes.toArray(new TreeNode[treeNodes.size()]);
        return (a);
    }
}
