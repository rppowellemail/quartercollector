package com.rppowellemail.quartercollector.quartercollector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private TreeListArrayAdapter treeListArrayAdapter;
    private ListView treelistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_TreeNodeListView();

    }

    private void init_TreeNodeListView() {

        //TreeNodeArray nodes = TreeNodeArray.generateTreeNodes4();

        TreeNodeArray nodes = TreeNodeArray.generateStateQuarters();
        TreeNodeArray.logTreeNodeArray(nodes);

        treeListArrayAdapter = new TreeListArrayAdapter(this, nodes);

        treelistview = new android.widget.ListView(this);
        treelistview.setAdapter(treeListArrayAdapter);

        setContentView(treelistview);
    }

}
