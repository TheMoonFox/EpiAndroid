package com.example.max.kikooworld.Shard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.PlanningGetItem;
import com.example.max.kikooworld.R;

import java.util.List;

/**
 * Created by Fox on 31/01/2016.
 */

public class PlanningAdapter  extends ArrayAdapter<PlanningGetItem> {

    public PlanningAdapter(Context context, List<PlanningGetItem> plannings) {
        super(context, 0, plannings);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.planning_row, parent, false);
        }

        PlanningRow viewHolder = (PlanningRow) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new PlanningRow();
            viewHolder.titlemodule = (TextView) convertView.findViewById(R.id.titlemodule);
            viewHolder.start = (TextView) convertView.findViewById(R.id.start);
            viewHolder.end = (TextView) convertView.findViewById(R.id.end);
            viewHolder.totalStudentsRegistered = (TextView) convertView.findViewById(R.id.totalStudentsRegistered);
            viewHolder.roomType = (TextView) convertView.findViewById(R.id.roomType);
            viewHolder.type_title = (TextView) convertView.findViewById(R.id.typetitle);
            viewHolder.acti_title = (TextView) convertView.findViewById(R.id.actititle);
            convertView.setTag(viewHolder);
        }

        PlanningGetItem mgi = getItem(position);

        viewHolder.titlemodule.setText(mgi.getTitlemodule());
        viewHolder.start.setText(mgi.getStart());
        viewHolder.end.setText(mgi.getEnd());
        viewHolder.totalStudentsRegistered.setText(mgi.getTotalStudentsRegistered());
        viewHolder.roomType.setText(mgi.getRoomType());
        viewHolder.type_title.setText(mgi.getType_title());
        viewHolder.acti_title.setText(mgi.getActi_title());

        return convertView;
    }
}