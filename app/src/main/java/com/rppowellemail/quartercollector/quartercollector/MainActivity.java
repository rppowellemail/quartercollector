package com.rppowellemail.quartercollector.quartercollector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_TreeNodeListView();

    }

    private void init_TreeNodeListView() {
        TreeNode nodes[];

        nodes = TreeNodeArray.generateListTreeNodes1();

        TreeListArrayAdapter treeListArrayAdapter;
        treeListArrayAdapter = new TreeListArrayAdapter(this, nodes);
        //treeListArrayAdapter.onExpandClickListener = this;

        ListView treelistview;
        treelistview = new android.widget.ListView(this);
        treelistview.setAdapter(treeListArrayAdapter);

        setContentView(treelistview);

    }
}
