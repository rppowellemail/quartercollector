package com.rppowellemail.quartercollector.quartercollector;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by rpowell on 1/29/18.
 */

public class TreeNodeArray extends ArrayList<TreeNode> {
    public ArrayList<TreeNode> getVisibleNodes() {
        ArrayList<TreeNode> visibleNodes = new ArrayList<TreeNode>();

        for (TreeNode treeNode: this ) {
            Log.d("getVisibleNodes[]", treeNode + " (" + treeNode.getParent() + ")");
            visibleNodes.addAll(treeNode.getVisibleNodes());
        }
        return visibleNodes;
    }


    public static TreeNode[] generateListTreeNodes1() {
        TreeNode[] nodes;
        nodes=new TreeNode[10];
        nodes[0]=new TreeNode(null, "Node 1");
        nodes[1]=new TreeNode(null, "Node 2");
        nodes[2]=new TreeNode(null, "Node 3");
        nodes[3]=new TreeNode(nodes[1], "Node 2.1");
        nodes[4]=new TreeNode(nodes[1], "Node 2.2");
        nodes[5]=new TreeNode(nodes[1], "Node 2.3");
        nodes[6]=new TreeNode(nodes[4], "Node 2.2.1");
        nodes[7]=new TreeNode(nodes[4], "Node 2.2.2");
        nodes[8]=new TreeNode(nodes[2], "Node 3.1");
        nodes[9]=new TreeNode(nodes[2], "Node 3.2");
        return nodes;
    }

//    public static ListTreeNode[] generateListTreeNodes2() {
//        TreeNode root;
//
//        ArrayList<ListTreeNode> nodes = new ArrayList<ListTreeNode>();
//        nodes.add(new ListTreeNode(null, "Node 1"));
//        ListTreeNode t2 = new ListTreeNode(null, "Node 2");
//        nodes.add(t2);
//        nodes.add(new ListTreeNode(t2, "Node 2.1"));
//        ListTreeNode t2_2 = new ListTreeNode(t2, "Node 2.2");
//        nodes.add(t2_2);
//        nodes.add(new ListTreeNode(t2_2, "Node 2.2.1"));
//        nodes.add(new ListTreeNode(t2_2, "Node 2.2.2"));
//        nodes.add(new ListTreeNode(t2, "Node 2.3"));
//
//        ListTreeNode t3 = new ListTreeNode(null, "Node 3");
//        nodes.add(t3);
//        nodes.add(new ListTreeNode(t3, "Node 3.1"));
//        nodes.add(new ListTreeNode(t3, "Node 3.2"));
//
//        ListTreeNode[] a = nodes.toArray(new ListTreeNode[nodes.size()]);
//        logListTreeNode(a);
//
//        return (a);
//    }
//
//    public static void appendTreeNodes(ArrayList<ListTreeNode> list, ListTreeNode parent, TreeNode t) {
//        ListTreeNode n = new ListTreeNode(parent, t.getName());
//        list.add(new ListTreeNode(parent, t.getName()));
//        String s;
//        if (parent == null) {
//            s = "null";
//        } else {
//            s = parent.data.toString();
//        }
//        Log.d("appendTreeNodes", s +":" + t.getName());
//        for (TreeNode subnode : t.getNodes()) {
//            appendTreeNodes(list, n, subnode);
//        }
//    }
//
//    public static void logListTreeNode(ListTreeNode[] nodes) {
//        for (int i = 0; i < nodes.length; i++) {
//            ListTreeNode n = nodes[i];
//            Log.d("logListTreeNodes", n.parent + ":" + n.data.toString() + " hasChildren("+n.hasChildren(nodes) + ")");
//        }
//    }
//
//    public static ListTreeNode[] generateListTreeNodes3() {
//        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
//
//        treeNodes.add(new TreeNode(null, "Node 1"));
//        treeNodes.add(new TreeNode(null, "Node 2"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.1"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2"));
//        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.1"));
//        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.2"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.3"));
//        treeNodes.add(new TreeNode(null, "Node 3"));
//        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.1"));
//        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.2"));
//
//        ArrayList<ListTreeNode> nodes = new ArrayList<ListTreeNode>();
//
//        ListTreeNode t1 = new ListTreeNode(null, treeNodes.get(0).getName());
//
//        ListTreeNode t2 = new ListTreeNode(null, treeNodes.get(1).getName());
//        ListTreeNode t2_1 = new ListTreeNode(t2, treeNodes.get(1).getNodes().get(0).getName());
//        ListTreeNode t2_2 = new ListTreeNode(t2, treeNodes.get(1).getNodes().get(1).getName());
//
//        ListTreeNode t2_2_1 = new ListTreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(0).getName());
//        ListTreeNode t2_2_2 = new ListTreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(1).getName());
//
//        ListTreeNode t2_3 = new ListTreeNode(t2, treeNodes.get(1).getNodes().get(2).getName());
//
//        ListTreeNode t3 = new ListTreeNode(null, treeNodes.get(2).getName());
//        ListTreeNode t3_1 = new ListTreeNode(t3, treeNodes.get(2).getNodes().get(0).getName());
//        ListTreeNode t3_2 = new ListTreeNode(t3, treeNodes.get(2).getNodes().get(1).getName());
//
//        nodes.add(t1);
//        nodes.add(t2);
//        nodes.add(t2_1);
//        nodes.add(t2_2);
//        nodes.add(t2_2_1);
//        nodes.add(t2_2_2);
//        nodes.add(t2_3);
//        nodes.add(t3);
//        nodes.add(t3_1);
//        nodes.add(t3_2);
//
//        ListTreeNode[] a = nodes.toArray(new ListTreeNode[nodes.size()]);
//        logListTreeNode(a);
//        return (a);
//    }
//
//    public static ListTreeNode[] generateListTreeNodes4() {
//        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();
//
//        treeNodes.add(new TreeNode(null, "Node 1"));
//        treeNodes.add(new TreeNode(null, "Node 2"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.1"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2"));
//        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.1"));
//        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.2"));
//        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.3"));
//        treeNodes.add(new TreeNode(null, "Node 3"));
//        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.1"));
//        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.2"));
//
//
//        ArrayList<ListTreeNode> list = new ArrayList<ListTreeNode>();
//        for (TreeNode t : treeNodes) {
//            ListTreeNode l = new ListTreeNode(null, t.getName());
//            list.add(l);
//            list.addAll(l.generateListFromTreeNodes(l, t));
//        }
//
//        ListTreeNode[] a = list.toArray(new ListTreeNode[list.size()]);
//        logListTreeNode(a);
//        return (a);
//    }
}