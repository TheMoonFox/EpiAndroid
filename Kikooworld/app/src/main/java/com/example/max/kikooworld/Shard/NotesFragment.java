package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.Token;
import com.example.max.kikooworld.home;
import com.loopj.android.http.RequestParams;

import java.util.ArrayList;
import java.util.HashMap;

public class NotesFragment extends Fragment {
    private ArrayList<MarksGetItem> list;
    private ListView live;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        home acti = (home) getActivity();
        RequestParams tok = new RequestParams();
        tok.put("token", Token.value);
        HashMap hm = new HashMap();
        hm.put("Fragment", this);
        acti.getIntraClient().marksGetRequest(tok, hm);
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    public void doMarks() {
        live = (ListView) getActivity().findViewById(R.id.marksList);
        MarksAdapter meme = new MarksAdapter(getActivity(), list);
        live.setAdapter(meme);
    }

    public void setMarks(ArrayList<MarksGetItem> mgi) {
        this.list = mgi;
    }
}
