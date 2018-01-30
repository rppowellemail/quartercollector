package com.rppowellemail.quartercollector.quartercollector;

import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by rpowell on 1/29/18.
 */

public class TreeListArrayAdapter extends android.widget.ArrayAdapter<TreeNode>
{
    public TreeNode[] nodes;
    public android.view.View.OnClickListener onExpandClickListener;

    public TreeListArrayAdapter(android.content.Context ctx, TreeNode[] nodes)
    {
        super(ctx, 0);

        this.nodes = nodes;
        this.addAll(TreeNode.getVisibleNodes(this.nodes));
    }

    @Override
    public android.view.View getView(int idx, android.view.View view, android.view.ViewGroup parent_view)
    {
        android.widget.LinearLayout layout1;
        android.widget.CheckBox handle;
        android.widget.TextView label;
        android.widget.CheckBox completed;
        android.widget.LinearLayout.LayoutParams layout_params;
        TreeNode n;

        n=this.getItem(idx);

        layout1 = new android.widget.LinearLayout(parent_view.getContext());

        handle = new android.widget.CheckBox(parent_view.getContext());
        handle.setTag(n);
        handle.setChecked(n.isExpanded());
        handle.setOnClickListener(this.onExpandClickListener);
        if (!n.hasChildren())
            handle.setVisibility(android.view.View.INVISIBLE);

        layout_params = new android.widget.LinearLayout.LayoutParams(
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,
                android.widget.LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout_params.leftMargin = n.countParents() * 32;
        layout_params.topMargin = 0;
        layout_params.bottomMargin = 0;
        layout_params.rightMargin = 0;
        layout_params.gravity = android.view.Gravity.CENTER;
        layout1.addView(handle, layout_params);

        label = new android.widget.TextView(parent_view.getContext());
        label.setText(n.getName());
        label.setClickable(true);
        label.setGravity(android.view.Gravity.CENTER_VERTICAL);
        label.setOnClickListener(this.onExpandClickListener);
        label.setTag(n);
        label.setPadding(0, 0, 20, 0);
        layout_params = new android.widget.LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout_params.width = 0;x
        layout_params.weight = 1;
        layout1.addView(label, layout_params);

        completed = new android.widget.CheckBox(parent_view.getContext());
        completed.setTag(n);
        completed.setChecked(n.isExpanded());
        completed.setGravity(android.view.Gravity.CENTER_VERTICAL);
        completed.setOnClickListener(this.onExpandClickListener);
        completed.setVisibility(View.VISIBLE);

        layout_params = new android.widget.LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layout1.addView(completed, layout_params);

        if (true) {
            if (!n.hasChildren()) {
                handle.setVisibility(View.INVISIBLE);
                completed.setVisibility(View.VISIBLE);
            } else {
                handle.setVisibility(View.VISIBLE);
                completed.setVisibility(View.INVISIBLE);
            }
        }
        return layout1;
    }

}