package com.rppowellemail.quartercollector.quartercollector;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by rpowell on 1/29/18.
 */

public class TreeNodeArray extends ArrayList<TreeNode> {
    public ArrayList<TreeNode> getAllNodes() {
        ArrayList<TreeNode> allNodes = new ArrayList<TreeNode>();

        for (TreeNode treeNode: this ) {
            // Log.d("getVisibleNodes[]", treeNode + " (" + treeNode.getParent() + ")");
            allNodes.addAll(treeNode.getAllNodes());
        }
        return allNodes;
    }

    public ArrayList<TreeNode> getVisibleNodes() {
        ArrayList<TreeNode> visibleNodes = new ArrayList<TreeNode>();

        for (TreeNode treeNode: this ) {
            // Log.d("getVisibleNodes[]", treeNode + " (" + treeNode.getParent() + ")");
            visibleNodes.addAll(treeNode.getVisibleNodes());
        }
        return visibleNodes;
    }


    public static void logTreeNodeArray(TreeNodeArray treeNodeArray) {
        Log.d("logListTreeNodes", "TreeNodeArray size: " + treeNodeArray.size());
        for (int i = 0; i < treeNodeArray.size(); i++) {
            TreeNode n = treeNodeArray.get(i);
            TreeNode.logTreeNodes(n);
        }
    }

    public static TreeNode[] generateTreeNodes1() {
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

    public static TreeNode[] generateTreeNodes2() {
        TreeNode root;

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        nodes.add(new TreeNode(null, "Node 1"));
        TreeNode t2 = new TreeNode(null, "Node 2");
        nodes.add(t2);
        nodes.add(new TreeNode(t2, "Node 2.1"));
        TreeNode t2_2 = new TreeNode(t2, "Node 2.2");
        nodes.add(t2_2);
        nodes.add(new TreeNode(t2_2, "Node 2.2.1"));
        nodes.add(new TreeNode(t2_2, "Node 2.2.2"));
        nodes.add(new TreeNode(t2, "Node 2.3"));

        TreeNode t3 = new TreeNode(null, "Node 3");
        nodes.add(t3);
        nodes.add(new TreeNode(t3, "Node 3.1"));
        nodes.add(new TreeNode(t3, "Node 3.2"));

        TreeNode[] a = nodes.toArray(new TreeNode[nodes.size()]);
        //logListTreeNode(a);
        return (a);
    }

    public static TreeNodeArray generateTreeNodes2a() {
        TreeNode root;

        TreeNodeArray treeNodeArray = new TreeNodeArray();

        treeNodeArray.add(new TreeNode(null, "Node 1"));
        TreeNode t2 = new TreeNode(null, "Node 2");
        treeNodeArray.add(t2);
        treeNodeArray.add(new TreeNode(t2, "Node 2.1"));
        TreeNode t2_2 = new TreeNode(t2, "Node 2.2");
        treeNodeArray.add(t2_2);
        treeNodeArray.add(new TreeNode(t2_2, "Node 2.2.1"));
        treeNodeArray.add(new TreeNode(t2_2, "Node 2.2.2"));
        treeNodeArray.add(new TreeNode(t2, "Node 2.3"));

        TreeNode t3 = new TreeNode(null, "Node 3");
        treeNodeArray.add(t3);
        treeNodeArray.add(new TreeNode(t3, "Node 3.1"));
        treeNodeArray.add(new TreeNode(t3, "Node 3.2"));

        return treeNodeArray;
    }



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

    public static TreeNodeArray generateTreeNodes3() {
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

        treeNodes.add(new TreeNode(null, "Node 1"));
        treeNodes.add(new TreeNode(null, "Node 2"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.1"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2"));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.1"));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.2"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.3"));
        treeNodes.add(new TreeNode(null, "Node 3"));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.1"));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.2"));

        //ArrayList<ListTreeNode> nodes = new ArrayList<ListTreeNode>();

        TreeNode t1 = new TreeNode(null, treeNodes.get(0).getName());

        TreeNode t2 = new TreeNode(null, treeNodes.get(1).getName());
        TreeNode t2_1 = new TreeNode(t2, treeNodes.get(1).getNodes().get(0).getName());
        TreeNode t2_2 = new TreeNode(t2, treeNodes.get(1).getNodes().get(1).getName());

//        TreeNode t2_2_1 = new TreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(0).getName());
//        TreeNode t2_2_2 = new TreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(1).getName());

//        TreeNode t2_3 = new TreeNode(t2, treeNodes.get(1).getNodes().get(2).getName());
//
//        TreeNode t3 = new TreeNode(null, treeNodes.get(2).getName());
//        TreeNode t3_1 = new TreeNode(t3, treeNodes.get(2).getNodes().get(0).getName());
//        TreeNode t3_2 = new TreeNode(t3, treeNodes.get(2).getNodes().get(1).getName());

        TreeNodeArray treeNodeArray = new TreeNodeArray();

        treeNodeArray.add(t1);
        treeNodeArray.add(t2);
        treeNodeArray.add(t2_1);
        treeNodeArray.add(t2_2);
//        treeNodeArray.add(t2_2_1);
//        treeNodeArray.add(t2_2_2);
//        treeNodeArray.add(t2_3);
//        treeNodeArray.add(t3);
//        treeNodeArray.add(t3_1);
//        treeNodeArray.add(t3_2);
        return(treeNodeArray);
    }

    public static TreeNodeArray generateTreeNodes3a() {
        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

        treeNodes.add(new TreeNode(null, "Node 1"));
        treeNodes.add(new TreeNode(null, "Node 2"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.1"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2"));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.1"));
        treeNodes.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.2.2"));
        treeNodes.get(1).getNodes().add(new TreeNode(treeNodes.get(1), "Node 2.3"));
        treeNodes.add(new TreeNode(null, "Node 3"));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.1"));
        treeNodes.get(2).getNodes().add(new TreeNode(treeNodes.get(2), "Node 3.2"));

        //ArrayList<ListTreeNode> nodes = new ArrayList<ListTreeNode>();

        TreeNode t1 = new TreeNode(null, treeNodes.get(0).getName());

        TreeNode t2 = new TreeNode(null, treeNodes.get(1).getName());
        TreeNode t2_1 = new TreeNode(t2, treeNodes.get(1).getNodes().get(0).getName());
        TreeNode t2_2 = new TreeNode(t2, treeNodes.get(1).getNodes().get(1).getName());

//        TreeNode t2_2_1 = new TreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(0).getName());
//        TreeNode t2_2_2 = new TreeNode(t2_2, treeNodes.get(1).getNodes().get(1).getNodes().get(1).getName());

//        TreeNode t2_3 = new TreeNode(t2, treeNodes.get(1).getNodes().get(2).getName());
//
//        TreeNode t3 = new TreeNode(null, treeNodes.get(2).getName());
//        TreeNode t3_1 = new TreeNode(t3, treeNodes.get(2).getNodes().get(0).getName());
//        TreeNode t3_2 = new TreeNode(t3, treeNodes.get(2).getNodes().get(1).getName());

        TreeNodeArray treeNodeArray = new TreeNodeArray();

        treeNodeArray.add(t1);
        treeNodeArray.add(t2);
        treeNodeArray.add(t2_1);
        treeNodeArray.add(t2_2);
//        treeNodeArray.add(t2_2_1);
//        treeNodeArray.add(t2_2_2);
//        treeNodeArray.add(t2_3);
//        treeNodeArray.add(t3);
//        treeNodeArray.add(t3_1);
//        treeNodeArray.add(t3_2);
        return(treeNodeArray);
    }


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

    public static TreeNodeArray generateTreeNodes4() {
//        ArrayList<TreeNode> treeNodes = new ArrayList<TreeNode>();

        TreeNodeArray treeNodeArray = new TreeNodeArray();

        treeNodeArray.add(new TreeNode(null, "Node 1", true, false));
        treeNodeArray.add(new TreeNode(null, "Node 2", false, false));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "Node 2.1", true, false));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "Node 2.2", true, false));
        treeNodeArray.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodeArray.get(1).getNodes().get(1), "Node 2.2.1", true, false));
        treeNodeArray.get(1).getNodes().get(1).getNodes().add(new TreeNode(treeNodeArray.get(1).getNodes().get(1), "Node 2.2.2", true, false));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "Node 2.3", true, false));
        treeNodeArray.add(new TreeNode(null, "Node 3", true, false));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "Node 3.1", true, false));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "Node 3.2", true, false));

//        for (TreeNode t : treeNodes) {
//            treeNodeArray.add(t);
//        }
        return treeNodeArray;
    }

    public static TreeNodeArray generateStateQuarters() {
        TreeNodeArray treeNodeArray = new TreeNodeArray();
        return treeNodeArray;
    }
}
