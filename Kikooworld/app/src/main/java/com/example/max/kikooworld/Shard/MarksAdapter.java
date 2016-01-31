package com.example.max.kikooworld.Shard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Max on 31/01/2016.
 */
public class MarksAdapter extends ArrayAdapter<MarksGetItem> {

    public MarksAdapter(Context context, List<MarksGetItem> marks) {
        super(context, 0, marks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.marks_row, parent, false);
        }

        MarksRow viewHolder = (MarksRow) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new MarksRow();
            viewHolder.titlemodule = (TextView) convertView.findViewById(R.id.titlemodule);
            viewHolder.titletitle = (TextView) convertView.findViewById(R.id.titletitle);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.correcteur = (TextView) convertView.findViewById(R.id.correcteur);
            viewHolder.final_note = (TextView) convertView.findViewById(R.id.final_note);
            convertView.setTag(viewHolder);
        }

        MarksGetItem mgi = getItem(position);

        viewHolder.titlemodule.setText(mgi.getTitlemodule());
        viewHolder.titletitle.setText(mgi.getTitle());
        viewHolder.date.setText(mgi.getDate());
        viewHolder.correcteur.setText(mgi.getCorrecteur());
        viewHolder.final_note.setText(mgi.getFinalNote());

        return convertView;
    }
}
