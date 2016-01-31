package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.PlanningGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TokenFragment extends Fragment {
    private ArrayList<PlanningGetItem> list;
    private ListView live;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final home acti = (home) getActivity();
        final TokenFragment tmp = this;
        RequestParams tok = new RequestParams();
        Calendar calendar = Calendar.getInstance();
        String Year = String.valueOf(calendar.get(calendar.YEAR));
        int iMonth = calendar.get(calendar.MONTH) + 1;
        String Month;
        if (iMonth <= 9)
            Month = "0" + String.valueOf(iMonth);
        else
            Month = String.valueOf(iMonth);
        int iDay = calendar.get(calendar.DAY_OF_MONTH);
        String Day;
        if (iDay <= 9)
            Day = "0" + String.valueOf(iDay);
        else
            Day = String.valueOf(iDay);
        String date = Year + "-" + Month + "-" + Day;
        System.out.println("date = " + date);

        calendar.roll(Calendar.DAY_OF_YEAR, -2);

        int bYear = calendar.get(Calendar.YEAR);
        int bMonth = calendar.get(Calendar.MONTH) + 1;
        int bDay = calendar.get(Calendar.DAY_OF_MONTH);

        String BYear = String.valueOf(bYear);
        String BMonth;
        if (bMonth <= 9)
            BMonth = "0" + String.valueOf(bMonth);
        else
            BMonth = String.valueOf(bMonth);
        String BDay;
        if (bDay <= 9)
            BDay = "0" + String.valueOf(bDay);
        else
            BDay = String.valueOf(bDay);
        String begin = BYear + "-" + BMonth + "-" + BDay;
        System.out.println("Begin = " + begin + " End = " + date);
        tok.put("token", Token.value);
        tok.put("start", begin);
        tok.put("end", date);
        HashMap hm = new HashMap();
        hm.put("Type", "Token");
        hm.put("Fragment", tmp);
        acti.getIntraClient().planningGetRequest(tok, hm);
        return inflater.inflate(R.layout.fragment_token, container, false);
    }

    public void doToken() {
        if (this.list == null || this.list.size() == 0)
            System.out.println("Y'a rien à afficher dédé !");
    }

    public void setToken(ArrayList<PlanningGetItem> planning) {
        this.list = planning;
    }
}

