package com.example.max.kikooworld.Shard;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;
import com.example.max.kikooworld.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.List;

/**
 * Created by Max on 31/01/2016.
 */
public class MessageAdapter extends ArrayAdapter<MessagesGetItem> {

    public MessageAdapter(Context context, List<MessagesGetItem> messages) {
        super(context, 0, messages);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_home_row,parent, false);
        }

        MessageRow viewHolder = (MessageRow) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new MessageRow();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.pseudo);
            viewHolder.text = (TextView) convertView.findViewById(R.id.text);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            convertView.setTag(viewHolder);
        }

        MessagesGetItem mgi = getItem(position);

        viewHolder.pseudo.setText(mgi.getTitle());
        viewHolder.text.setText(mgi.getContent());
        if (!(mgi.getUserPicture() == null || mgi.getUserPicture() == "null"))
            Picasso.with(getContext()).load(mgi.getUserPicture()).into(viewHolder.avatar);

        return convertView;
    }
}
