package com.rppowellemail.quartercollector.quartercollector;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rpowell on 1/29/18.
 */

public class TreeNode {

    private String name;
    private ArrayList<TreeNode> nodes;
    boolean completed;

    private TreeNode parent;
    private boolean expanded;

    public TreeNode getParent() {
        return parent;
    }

    public void setParent(TreeNode parent) {
        this.parent = parent;
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
    public int countParents() {
        int c = 0;
        for(TreeNode t = this; t != null; t=t.getParent()) {
            c++;
        }
        return c;
    }

    public boolean isExpanded() {
        //Log.d("TreeNode", this + " isExpanded:" + isExpanded);
        return this.expanded;
    }
    public void setExpanded(boolean b) {
        //Log.d("TreeNode", this + " setExpanded:" + isExpanded + " -> " + b);
        this.expanded = b;
    }

    public TreeNode(TreeNode parent, String name) {
        this.parent = parent;
        this.name = name;
        this.completed = false;
        this.nodes = new ArrayList<TreeNode>();
    }

    public TreeNode(TreeNode parent, String name, boolean completed) {
        this.parent = parent;
        this.name = name;
        this.completed = completed;
        this.nodes = new ArrayList<TreeNode>();
    }

    public ArrayList<TreeNode> getNodes() {
        return this.nodes;
    }

    public ArrayList<TreeNode> toArrayList() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        for (TreeNode t: nodes ) {
            n.addAll(t.toArrayList());
        }
        return n;
    }

//    public static ArrayList<TreeNode> getVisibleNodes(TreeNode parent, TreeNode[] nodes)
//    {
//        ArrayList<TreeNode> visible_nodes=null;
//
//        visible_nodes = new ArrayList<TreeNode>();
//        for (TreeNode n: nodes)
//            if (n.parent==parent)
//            {
//                visible_nodes.add(n);
//                if (n.isExpanded())
//                    visible_nodes.addAll(getVisibleNodes(n, nodes));
//            }
//        return visible_nodes;
//    }

    public ArrayList<TreeNode> getVisibleNodes() {
        ArrayList<TreeNode> n = new ArrayList<TreeNode>();
        n.add(this);
        Log.d("getVisibleNodes", this + " (" + this.getParent() + ") size:" + getNodes().size() + " " + this.isExpanded() );
        if (isExpanded()) {
            for (TreeNode t: this.getNodes() ) {
                n.addAll(t.getVisibleNodes());
            }
        }
        return n;
    }

    public static ArrayList<TreeNode> getVisibleNodes(TreeNode[] treeNodes) {
        ArrayList<TreeNode> visibleNodes = new ArrayList<TreeNode>();


        for (TreeNode treeNode: treeNodes ) {
            Log.d("getVisibleNodes[]", treeNode + " (" + treeNode.getParent() + ")");
            visibleNodes.addAll(treeNode.getVisibleNodes());
        }
        return visibleNodes;
    }


    public static TreeNode[] generateDemoTreeNodes1() {
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

        treeNodes.add(new TreeNode(null, "TreeNode 1", false));
        treeNodes.add(new TreeNode(null, "TreeNode 2", false));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "TreeNode 2.1", false));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2", false));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2.1", false));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "TreeNode 2.2.2", false));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "TreeNode 2.3", false));
        treeNodes.add(new TreeNode(null, "TreeNode 3", false));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "TreeNode 3.1", false));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "TreeNode 3.2", false));
        TreeNode[] a = treeNodes.toArray(new TreeNode[treeNodes.size()]);
        return (a);
    }



}
