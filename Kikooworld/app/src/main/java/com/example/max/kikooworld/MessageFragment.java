package com.example.max.kikooworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MessageFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("MessagesFragment created");
        View view = inflater.inflate(R.layout.fragment_message, container, false);
        return inflater.inflate(R.layout.fragment_message, container, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        System.out.println("SPAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAACE");
    }

}
