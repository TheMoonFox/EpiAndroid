package com.example.max.kikooworld.Shard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.ProjectsGetItem;
import com.example.max.kikooworld.R;

import java.util.List;

/**
 * Created by Max on 31/01/2016.
 */
public class ProjectsAdapter extends ArrayAdapter<ProjectsGetItem> {

    public ProjectsAdapter(Context context, List<ProjectsGetItem> projects) {
        super(context, 0, projects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.projects_row, parent, false);
        }

        ProjectsRow viewHolder = (ProjectsRow) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProjectsRow();
            viewHolder.titleproject = (TextView) convertView.findViewById(R.id.titleproject);
            viewHolder.registered = (TextView) convertView.findViewById(R.id.registered);
            viewHolder.code_location = (TextView) convertView.findViewById(R.id.code_location);
            viewHolder.begin_acti = (TextView) convertView.findViewById(R.id.begin_acti);
            viewHolder.end_acti = (TextView) convertView.findViewById(R.id.end_acti);
            convertView.setTag(viewHolder);
        }

        ProjectsGetItem pgi = getItem(position);

        viewHolder.titleproject.setText(pgi.getActi_title());
        viewHolder.registered.setText(pgi.getRegistered());
        viewHolder.code_location.setText(pgi.getCode_location());
        viewHolder.begin_acti.setText(pgi.getBegin_acti());
        viewHolder.end_acti.setText(pgi.getEnd_acti());
        return convertView;
    }
}
