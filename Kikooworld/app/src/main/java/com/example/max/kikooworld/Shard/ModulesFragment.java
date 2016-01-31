package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.ModulesGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;

public class ModulesFragment extends Fragment {

    private String scolaryear;
    private String location;
    private String course;
    private home acti;
    private ArrayList<ModulesGetItem> mgi;
    private ListView live;
    private ArrayList<ModulesGetItem> dummy = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        acti = (home) getActivity();
        RequestParams tok = new RequestParams();
        tok.put("token", Token.value);
        tok.put("user", Token.userLogin);
        HashMap hm = new HashMap();
        hm.put("Fragment", this);
        acti.getIntraClient().userGetRequest(tok, hm);
        return inflater.inflate(R.layout.fragment_modules, container, false);
    }

    public void doNext() {
        RequestParams rp = new RequestParams();
        rp.put("token", Token.value);
        rp.put("scolaryear", this.scolaryear);
        rp.put("location", this.location);
        rp.put("course", this.course);
        HashMap hm = new HashMap();
        hm.put("Fragment", this);
        acti.getIntraClient().allmodulesGetRequest(rp, hm);
    }

    public void doModules() {
        live = (ListView) getActivity().findViewById(R.id.modulesList);
        ModulesAdapter meme;
        if (mgi == null)
            meme = new ModulesAdapter(getActivity(), dummy);
        else
            meme = new ModulesAdapter(getActivity(), mgi);
        live.setAdapter(meme);
    }

    public void setModules(ArrayList<ModulesGetItem> lily) {
        this.mgi = lily;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCourse(String course) {
        this.course = course;
    }

}
