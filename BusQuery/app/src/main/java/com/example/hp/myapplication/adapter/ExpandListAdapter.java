package com.example.hp.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.hp.myapplication.R;

import java.util.List;
import java.util.Map;

public class ExpandListAdapter extends BaseExpandableListAdapter {
    private String[] titles;
    private Map<String, List> listMap;
    private Context context;

    public ExpandListAdapter(String[] titles, Map<String, List> listMap, Context context) {
        this.titles = titles;
        this.listMap = listMap;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return titles.length;
    }

    @Override
    public int getChildrenCount(int i) {
        return listMap.get(titles[i]).size();
    }

    @Override
    public Object getGroup(int i) {
        return titles[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        return listMap.get(titles[i]).get(i);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder1 holder1;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fg2_ada_group, viewGroup,false);
            holder1 = new ViewHolder1(view);
            view.setTag(holder1);
        } else {
            holder1 = (ViewHolder1) view.getTag();
        }
        holder1.fg2_group.setText(titles[i] + "");
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolder2 holder2;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.fg2_ada_child, viewGroup,false);
            holder2 = new ViewHolder2(view);
            view.setTag(holder2);
        } else {
            holder2 = (ViewHolder2) view.getTag();
        }
        holder2.fg2_child.setText(listMap.get(titles[i]).get(i1) + "");
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }

    public class ViewHolder1 {
        public View rootView;
        public TextView fg2_group;

        public ViewHolder1(View rootView) {
            this.rootView = rootView;
            this.fg2_group = (TextView) rootView.findViewById(R.id.fg2_group);
        }

    }

    public class ViewHolder2 {
        public View rootView;
        public TextView fg2_child;

        public ViewHolder2(View rootView) {
            this.rootView = rootView;
            this.fg2_child = (TextView) rootView.findViewById(R.id.fg2_child);
        }
    }
}
