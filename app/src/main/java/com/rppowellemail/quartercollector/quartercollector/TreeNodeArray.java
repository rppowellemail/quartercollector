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

    public static TreeNodeArray generateTreeNodes4() {

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

        return treeNodeArray;
    }

    public static TreeNodeArray generateStateQuarters() {

        // https://www.usmint.gov/news/image-library/50-state-quarters-program
        TreeNodeArray treeNodeArray = new TreeNodeArray();
        treeNodeArray.add(new TreeNode(null, "1999", true, false));
        treeNodeArray.get(0).getNodes().add(new TreeNode(treeNodeArray.get(0), "DE - Delaware", false, true));
        treeNodeArray.get(0).getNodes().add(new TreeNode(treeNodeArray.get(0), "PA - Pennsylvania", true, false));
        treeNodeArray.get(0).getNodes().add(new TreeNode(treeNodeArray.get(0), "NJ - New Jersey", true, false));
        treeNodeArray.get(0).getNodes().add(new TreeNode(treeNodeArray.get(0), "GA - Georgia", true, true));
        treeNodeArray.get(0).getNodes().add(new TreeNode(treeNodeArray.get(0), "CT - Connecticut", true, true));
        treeNodeArray.add(new TreeNode(null, "2000", false, false));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "MA - Massachusetts", true, true));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "MD - Maryland", true, true));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "SC - South Carolina", true, true));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "NH - New Hampshire", true, true));
        treeNodeArray.get(1).getNodes().add(new TreeNode(treeNodeArray.get(1), "VA - Virginia", true, true));
        treeNodeArray.add(new TreeNode(null, "2001", false, false));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "NY - New York", true, true));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "NC - North Carolina", true, true));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "RI - Rhode Island", true, true));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "VT - Vermont", true, true));
        treeNodeArray.get(2).getNodes().add(new TreeNode(treeNodeArray.get(2), "KY - Kentucky", true, true));
        treeNodeArray.add(new TreeNode(null, "2002", true, false));
        treeNodeArray.get(3).getNodes().add(new TreeNode(treeNodeArray.get(3), "TN - Tennessee", true, true));
        treeNodeArray.get(3).getNodes().add(new TreeNode(treeNodeArray.get(3), "OH - Ohio", true, false));
        treeNodeArray.get(3).getNodes().add(new TreeNode(treeNodeArray.get(3), "LA - Louisiana", true, true));
        treeNodeArray.get(3).getNodes().add(new TreeNode(treeNodeArray.get(3), "IN - Indiana", true, true));
        treeNodeArray.get(3).getNodes().add(new TreeNode(treeNodeArray.get(3), "MS - Mississippi", true, true));
        treeNodeArray.add(new TreeNode(null, "2003", false, false));
        treeNodeArray.get(4).getNodes().add(new TreeNode(treeNodeArray.get(4), "IL - Illinois", true, true));
        treeNodeArray.get(4).getNodes().add(new TreeNode(treeNodeArray.get(4), "AL - Alabama", true, true));
        treeNodeArray.get(4).getNodes().add(new TreeNode(treeNodeArray.get(4), "ME - Maine", true, true));
        treeNodeArray.get(4).getNodes().add(new TreeNode(treeNodeArray.get(4), "MO - Missouri", true, true));
        treeNodeArray.get(4).getNodes().add(new TreeNode(treeNodeArray.get(4), "AR - Arkansas", true, true));
        treeNodeArray.add(new TreeNode(null, "2004", true, false));
        treeNodeArray.get(5).getNodes().add(new TreeNode(treeNodeArray.get(5), "MI - Michigan", true, false));
        treeNodeArray.get(5).getNodes().add(new TreeNode(treeNodeArray.get(5), "FL - Florida", true, false));
        treeNodeArray.get(5).getNodes().add(new TreeNode(treeNodeArray.get(5), "TX - Texas", true, false));
        treeNodeArray.get(5).getNodes().add(new TreeNode(treeNodeArray.get(5), "IA - Iowa", true, true));
        treeNodeArray.get(5).getNodes().add(new TreeNode(treeNodeArray.get(5), "WI - Wisconsin", true, false));
        treeNodeArray.add(new TreeNode(null, "2005", false, false));
        treeNodeArray.get(6).getNodes().add(new TreeNode(treeNodeArray.get(6), "CA - California", true, true));
        treeNodeArray.get(6).getNodes().add(new TreeNode(treeNodeArray.get(6), "MN - Minnesota", true, true));
        treeNodeArray.get(6).getNodes().add(new TreeNode(treeNodeArray.get(6), "OR - Oregon", true, true));
        treeNodeArray.get(6).getNodes().add(new TreeNode(treeNodeArray.get(6), "KA - Kansas", true, true));
        treeNodeArray.get(6).getNodes().add(new TreeNode(treeNodeArray.get(6), "WV - West Virginia", true, true));
        treeNodeArray.add(new TreeNode(null, "2006", false, false));
        treeNodeArray.get(7).getNodes().add(new TreeNode(treeNodeArray.get(7), "NV - Nevada", true, true));
        treeNodeArray.get(7).getNodes().add(new TreeNode(treeNodeArray.get(7), "NE - Nebraska", true, true));
        treeNodeArray.get(7).getNodes().add(new TreeNode(treeNodeArray.get(7), "CO - Colorado", true, true));
        treeNodeArray.get(7).getNodes().add(new TreeNode(treeNodeArray.get(7), "ND - North Dakota", true, true));
        treeNodeArray.get(7).getNodes().add(new TreeNode(treeNodeArray.get(7), "SD - South Dakota", true, true));
        treeNodeArray.add(new TreeNode(null, "2007", false, false));
        treeNodeArray.get(8).getNodes().add(new TreeNode(treeNodeArray.get(8), "MT - Montana", true, true));
        treeNodeArray.get(8).getNodes().add(new TreeNode(treeNodeArray.get(8), "WA - Washington", true, true));
        treeNodeArray.get(8).getNodes().add(new TreeNode(treeNodeArray.get(8), "ID - Idaho", true, true));
        treeNodeArray.get(8).getNodes().add(new TreeNode(treeNodeArray.get(8), "WY - Wyoming", true, true));
        treeNodeArray.get(8).getNodes().add(new TreeNode(treeNodeArray.get(8), "UT - Utah", true, true));
        treeNodeArray.add(new TreeNode(null, "2008", true, false));
        treeNodeArray.get(9).getNodes().add(new TreeNode(treeNodeArray.get(9), "OK - Oklahoma", true, true));
        treeNodeArray.get(9).getNodes().add(new TreeNode(treeNodeArray.get(9), "NM - New Mexico", true, false));
        treeNodeArray.get(9).getNodes().add(new TreeNode(treeNodeArray.get(9), "AZ - Arizona", true, true));
        treeNodeArray.get(9).getNodes().add(new TreeNode(treeNodeArray.get(9), "AK - Alaska", true, true));
        treeNodeArray.get(9).getNodes().add(new TreeNode(treeNodeArray.get(9), "HI - Hawaii", true, false));


        // D.C. & U.S. Territories Quarter Program
        // https://www.usmint.gov/news/image-library/district-of-columbia-and-us-territories-quarters
        treeNodeArray.add(new TreeNode(null, "2009 D.C. & U.S. Territories Quarter Program", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "District of Columbia Quarter", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "Puerto Rico Quarter", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "Guam Quarter", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "American Samoa Quarter", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "US Virgin Islands Quarter", true, false));
        treeNodeArray.get(10).getNodes().add(new TreeNode(treeNodeArray.get(10), "Northern Mariana Islands Quarter", true, false));

        // America the Beautiful Quarters
        // https://www.usmint.gov/learn/coin-and-medal-programs/america-the-beautiful-quarters
        treeNodeArray.add(new TreeNode(null, "2010", true, false));
        treeNodeArray.get(11).getNodes().add(new TreeNode(treeNodeArray.get(11), "Hot Springs National Park", true, false));
        treeNodeArray.get(11).getNodes().add(new TreeNode(treeNodeArray.get(11), "Yellowstone National Park", true, false));
        treeNodeArray.get(11).getNodes().add(new TreeNode(treeNodeArray.get(11), "Yosemite National Park", true, false));
        treeNodeArray.get(11).getNodes().add(new TreeNode(treeNodeArray.get(11), "Grand Canyon National Park", true, false));
        treeNodeArray.get(11).getNodes().add(new TreeNode(treeNodeArray.get(11), "Mt. Hood National Forest", true, false));
        treeNodeArray.add(new TreeNode(null, "2011", true, false));
        treeNodeArray.get(12).getNodes().add(new TreeNode(treeNodeArray.get(12), "Gettysburg National Military Park", true, false));
        treeNodeArray.get(12).getNodes().add(new TreeNode(treeNodeArray.get(12), "Glacier National Park", true, false));
        treeNodeArray.get(12).getNodes().add(new TreeNode(treeNodeArray.get(12), "Olympic National Park", true, false));
        treeNodeArray.get(12).getNodes().add(new TreeNode(treeNodeArray.get(12), "Vicksburg National Military Park", true, false));
        treeNodeArray.get(12).getNodes().add(new TreeNode(treeNodeArray.get(12), "Chickasaw National Recreation Area", true, false));
        treeNodeArray.add(new TreeNode(null, "2012", true, false));
        treeNodeArray.get(13).getNodes().add(new TreeNode(treeNodeArray.get(13), "El Yunque National Forest", true, false));
        treeNodeArray.get(13).getNodes().add(new TreeNode(treeNodeArray.get(13), "Chaco Culture National Historical Park", true, false));
        treeNodeArray.get(13).getNodes().add(new TreeNode(treeNodeArray.get(13), "Acadia National Park", true, false));
        treeNodeArray.get(13).getNodes().add(new TreeNode(treeNodeArray.get(13), "Hawai’i Volcanoes National Park", true, false));
        treeNodeArray.get(13).getNodes().add(new TreeNode(treeNodeArray.get(13), "Denali National Park and Preserve", true, false));
        treeNodeArray.add(new TreeNode(null, "2013", true, false));
        treeNodeArray.get(14).getNodes().add(new TreeNode(treeNodeArray.get(14), "White Mountain National Forest", true, false));
        treeNodeArray.get(14).getNodes().add(new TreeNode(treeNodeArray.get(14), "Perry’s Victory and International Peace Memorial", true, false));
        treeNodeArray.get(14).getNodes().add(new TreeNode(treeNodeArray.get(14), "Great Basin National Park", true, false));
        treeNodeArray.get(14).getNodes().add(new TreeNode(treeNodeArray.get(14), "Fort McHenry National Monument and Historic Shrine", true, false));
        treeNodeArray.get(14).getNodes().add(new TreeNode(treeNodeArray.get(14), "Mount Rushmore National Memorial", true, false));
        treeNodeArray.add(new TreeNode(null, "2014", true, false));
        treeNodeArray.get(15).getNodes().add(new TreeNode(treeNodeArray.get(15), "Great Smoky Mountains National Park", true, false));
        treeNodeArray.get(15).getNodes().add(new TreeNode(treeNodeArray.get(15), "Shenandoah National Park", true, false));
        treeNodeArray.get(15).getNodes().add(new TreeNode(treeNodeArray.get(15), "Arches National Park", true, false));
        treeNodeArray.get(15).getNodes().add(new TreeNode(treeNodeArray.get(15), "Great Sand Dunes National Park", true, false));
        treeNodeArray.get(15).getNodes().add(new TreeNode(treeNodeArray.get(15), "Everglades National Park", true, false));
        treeNodeArray.add(new TreeNode(null, "2015", true, false));
        treeNodeArray.get(16).getNodes().add(new TreeNode(treeNodeArray.get(16), "Homestead National Monument of America", true, false));
        treeNodeArray.get(16).getNodes().add(new TreeNode(treeNodeArray.get(16), "Kisatchie National Forest", true, false));
        treeNodeArray.get(16).getNodes().add(new TreeNode(treeNodeArray.get(16), "Blue Ridge Parkway", true, false));
        treeNodeArray.get(16).getNodes().add(new TreeNode(treeNodeArray.get(16), "Bombay Hook National Wildlife Refuge", true, false));
        treeNodeArray.get(16).getNodes().add(new TreeNode(treeNodeArray.get(16), "Saratoga National Historical Park", true, false));
        treeNodeArray.add(new TreeNode(null, "2016", true, false));
        treeNodeArray.get(17).getNodes().add(new TreeNode(treeNodeArray.get(17), "Shawnee National Forest", true, false));
        treeNodeArray.get(17).getNodes().add(new TreeNode(treeNodeArray.get(17), "Cumberland Gap National Historical Park", true, false));
        treeNodeArray.get(17).getNodes().add(new TreeNode(treeNodeArray.get(17), "Harpers Ferry National Historical Park", true, false));
        treeNodeArray.get(17).getNodes().add(new TreeNode(treeNodeArray.get(17), "Theodore Roosevelt National Park", true, false));
        treeNodeArray.get(17).getNodes().add(new TreeNode(treeNodeArray.get(17), "Fort Moultrie (Fort Sumter National Monument)", true, false));
        treeNodeArray.add(new TreeNode(null, "2017", true, false));
        treeNodeArray.get(18).getNodes().add(new TreeNode(treeNodeArray.get(18), "Effigy Mounds National Monument", true, false));
        treeNodeArray.get(18).getNodes().add(new TreeNode(treeNodeArray.get(18), "Frederick Douglass National Historic Site", true, false));
        treeNodeArray.get(18).getNodes().add(new TreeNode(treeNodeArray.get(18), "Ozark National Scenic Riverways", true, false));
        treeNodeArray.get(18).getNodes().add(new TreeNode(treeNodeArray.get(18), "Ellis Island", true, false));
        treeNodeArray.get(18).getNodes().add(new TreeNode(treeNodeArray.get(18), "George Rogers Clark National Historical Park", true, false));

        return treeNodeArray;
    }
}
