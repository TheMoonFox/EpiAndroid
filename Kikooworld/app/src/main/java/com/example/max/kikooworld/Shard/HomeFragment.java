package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
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
    private String login;
    private ListView live;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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
        ((TextView) getActivity().findViewById(R.id.loginValue)).setText(Token.userLogin);
    }

    public void doFace() {
        System.out.println("URL:" + this.faceURL);
        Picasso.with(getContext()).load(this.faceURL).into((ImageView) getActivity().findViewById(R.id.Avatar));
    }

    public void doMess() {
        live = (ListView) getActivity().findViewById(R.id.messagesList);
        MessageAdapter meme = new MessageAdapter(getActivity(), list);
        live.setAdapter(meme);
    }

}
