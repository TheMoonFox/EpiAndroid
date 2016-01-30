package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class HomeFragment extends Fragment {
    private ArrayList<MessagesGetItem> list;
    private String logTime;
    private String faceURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("HomeFragment created");
        //usage intra client dans les fragments
        home acti = (home) getActivity();
        RequestParams tok = new RequestParams();
        tok.put("token", Token.value);
        RequestParams toklog = new RequestParams();
        toklog.put("token", Token.value);
        toklog.put("login", Token.userLogin);
        HashMap hm = new HashMap();
        hm.put("Fragment", this);
        acti.getIntraClient().infosPostRequest(tok, hm);
        acti.getIntraClient().photoGetRequest(toklog, hm);
        acti.getIntraClient().messagesGetRequest(tok, hm);
        //\\
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void setLogTime(String logTime) {
        this.logTime = logTime;
    }

    public void setFace(String URL) {
        this.faceURL = URL;
    }

    public void setMess(ArrayList<MessagesGetItem> mgi) {
        this.list = mgi;
    }

    public void doLogTime() {
        ((TextView) getActivity().findViewById(R.id.Log_Time)).setText(this.logTime);
    }

    public void doFace() {
        Picasso.with(getContext()).load(this.faceURL).into((ImageView) getActivity().findViewById(R.id.Avatar));
    }

    public void doMess() {

    }

}
