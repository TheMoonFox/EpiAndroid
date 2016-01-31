package com.example.max.kikooworld.Shard;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.PlanningGetItem;
import com.example.max.kikooworld.MainActivity;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.loopj.android.http.RequestParams;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Fox on 31/01/2016.
 */

public class PlanningAdapter  extends ArrayAdapter<PlanningGetItem> {

    final PlanningAdapter totor = this;

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
            viewHolder.sub = (Button) convertView.findViewById(R.id.btnSub);
            viewHolder.unsub = (Button) convertView.findViewById(R.id.btnUnSub);
            viewHolder.token = (Button) convertView.findViewById(R.id.btnToken);

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
        viewHolder.codeacti = mgi.getCodeacti();
        viewHolder.codeevent = mgi.getCodeevent();
        viewHolder.scolaryear = mgi.getScolaryear();
        viewHolder.codemodule = mgi.getCodemodule();
        viewHolder.codeinstance = mgi.getCodeinstance();
        final PlanningRow finalViewHolder = viewHolder;
        viewHolder.token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertbox = new AlertDialog.Builder(getContext());
                alertbox.setTitle("Enter token");
                final EditText input = new EditText(getContext());
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertbox.setView(input);
                alertbox.setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        RequestParams rp = new RequestParams();
                        rp.put("token", Token.value);
                        rp.put("scolaryear", finalViewHolder.scolaryear);
                        rp.put("codemodule", finalViewHolder.codemodule);
                        rp.put("codeinstance", finalViewHolder.codeinstance);
                        rp.put("codeacti", finalViewHolder.codeacti);
                        rp.put("codeevent", finalViewHolder.codeevent);
                        rp.put("tokenvalidationcode", input.getText());
                        HashMap hm = new HashMap();
                        hm.put("this", totor);
                        Token.glob.tokenPostRequest(rp, hm);
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                    }
                }).show();
            }
        });

        viewHolder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams rp = new RequestParams();
                rp.put("token", Token.value);
                rp.put("scolaryear", finalViewHolder.scolaryear);
                rp.put("codemodule", finalViewHolder.codemodule);
                rp.put("codeinstance", finalViewHolder.codeinstance);
                rp.put("codeacti", finalViewHolder.codeacti);
                rp.put("codeevent", finalViewHolder.codeevent);
                HashMap hm = new HashMap();
                hm.put("this", totor);
                Token.glob.eventPostRequest(rp, hm);
            }
        });

        viewHolder.unsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams rp = new RequestParams();
                rp.put("token", Token.value);
                rp.put("scolaryear", finalViewHolder.scolaryear);
                rp.put("codemodule", finalViewHolder.codemodule);
                rp.put("codeinstance", finalViewHolder.codeinstance);
                rp.put("codeacti", finalViewHolder.codeacti);
                rp.put("codeevent", finalViewHolder.codeevent);
                HashMap hm = new HashMap();
                hm.put("this", totor);
                Token.glob.eventDeleteRequest(rp, hm);
            }
        });

        return convertView;
    }

    public void doBibi() {
        AlertDialog.Builder bibi = new AlertDialog.Builder(getContext());
        bibi.setTitle("Success");
        bibi.setMessage("Token validated.");
        bibi.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void doBibo() {
        AlertDialog.Builder bibo = new AlertDialog.Builder(getContext());
        bibo.setTitle("Error");
        bibo.setMessage("Could not validate token.");
        bibo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void doOKSub() {
        AlertDialog.Builder bibo = new AlertDialog.Builder(getContext());
        bibo.setTitle("Success");
        bibo.setMessage("Subscription complete.");
        bibo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void doNOKSub() {
        AlertDialog.Builder bibo = new AlertDialog.Builder(getContext());
        bibo.setTitle("Error");
        bibo.setMessage("Subscription failed.");
        bibo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void doOKUnsub() {
        AlertDialog.Builder bibo = new AlertDialog.Builder(getContext());
        bibo.setTitle("Success");
        bibo.setMessage("Unsubscription complete.");
        bibo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void doNOKUnsub() {
        AlertDialog.Builder bibo = new AlertDialog.Builder(getContext());
        bibo.setTitle("Error");
        bibo.setMessage("Unsubscription failed.");
        bibo.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).show();
        reload();
    }

    public void reload() {
        PlanningFragment p_fragment = new PlanningFragment();
        android.support.v4.app.FragmentTransaction p_fragmentTransaction =
                Token.Home.getSupportFragmentManager().beginTransaction();
        p_fragmentTransaction.replace(R.id.fragment_container, p_fragment);
        p_fragmentTransaction.commit();
    }
}