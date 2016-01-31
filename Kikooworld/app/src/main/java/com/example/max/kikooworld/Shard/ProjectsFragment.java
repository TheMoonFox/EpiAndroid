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
import com.example.max.kikooworld.Acrobate.AcrobateItems.ProjectsGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class ProjectsFragment extends Fragment {

    private ArrayList<ProjectsGetItem> pgi;
    private ArrayList<ProjectsGetItem> dummy = new ArrayList<>();
    private ListView live;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final home acti = (home) getActivity();
        RequestParams tok = new RequestParams();
        tok.put("token", Token.value);
        HashMap hm = new HashMap();
        hm.put("Fragment", this);
        acti.getIntraClient().projectsGetRequest(tok, hm);
        return inflater.inflate(R.layout.fragment_projects, container, false);
    }

    public void doProjects() {
        live = (ListView) getActivity().findViewById(R.id.projectsList);
        ProjectsAdapter meme;
        if (pgi == null)
            meme = new ProjectsAdapter(getActivity(), dummy);
        else
            meme = new ProjectsAdapter(getActivity(), pgi);
        live.setAdapter(meme);
    }

    public void setProjects(ArrayList<ProjectsGetItem> lily) {
        this.pgi = lily;
    }
}

