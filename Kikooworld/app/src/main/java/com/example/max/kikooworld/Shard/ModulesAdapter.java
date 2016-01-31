package com.example.max.kikooworld.Shard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.Acrobate.AcrobateItems.ModulesGetItem;
import com.example.max.kikooworld.R;

import java.util.List;

/**
 * Created by Max on 31/01/2016.
 */
public class ModulesAdapter extends ArrayAdapter<ModulesGetItem> {

    public ModulesAdapter(Context context, List<ModulesGetItem> modules) {
        super(context, 0, modules);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.modules_row, parent, false);
        }

        ModulesRow viewHolder = (ModulesRow) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ModulesRow();
            viewHolder.moduletitle = (TextView) convertView.findViewById(R.id.moduletitle);
            viewHolder.credits = (TextView) convertView.findViewById(R.id.credits);
            viewHolder.status = (TextView) convertView.findViewById(R.id.status);
            convertView.setTag(viewHolder);
        }

        ModulesGetItem mgi = getItem(position);

        viewHolder.moduletitle.setText(mgi.getTitle());
        viewHolder.credits.setText(mgi.getCredits());
        viewHolder.status.setText(mgi.getStatus());

        return convertView;
    }
}
