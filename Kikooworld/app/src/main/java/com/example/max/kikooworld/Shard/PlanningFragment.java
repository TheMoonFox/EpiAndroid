package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.PlanningGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;

public class PlanningFragment extends Fragment {
    private ArrayList<PlanningGetItem> list;
    private DatePicker dp;
    private ListView live;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final home acti = (home) getActivity();
        final PlanningFragment tmp = this;
        FrameLayout ll = (FrameLayout)inflater.inflate(R.layout.fragment_planning, container, false);
        final Button bubu = (Button) ll.findViewById(R.id.totor);
        dp = (DatePicker) ll.findViewById(R.id.datePicker);
        bubu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestParams tok = new RequestParams();
                String Year = String.valueOf(dp.getYear());
                int iMonth = dp.getMonth() + 1;
                String Month;
                if (iMonth <= 9)
                    Month = "0" + String.valueOf(iMonth);
                else
                    Month = String.valueOf(iMonth);
                int iDay = dp.getDayOfMonth();
                String Day;
                if (iDay <= 9)
                    Day = "0" + String.valueOf(iDay);
                else
                    Day = String.valueOf(iDay);
                String date = Year + "-" + Month + "-" + Day;
                System.out.println("date = " + date);
                tok.put("token", Token.value);
                tok.put("start", date);
                tok.put("end", date);
                HashMap hm = new HashMap();
                hm.put("Type", "Planning");
                hm.put("Fragment", tmp);
                acti.getIntraClient().planningGetRequest(tok, hm);
            }
        });
        return ll;
    }

    public void doPlanning() {
        if (this.list == null)
            System.out.println("Y'a rien à afficher dédé !");
    }

    public void setPlanning(ArrayList<PlanningGetItem> planning) {
        this.list = planning;
    }
}

