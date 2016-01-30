package com.example.max.kikooworld;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class HomeFragment extends Fragment {
    private ImageView avatar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("HomeFragment created");
        //usage intra client dans les fragments
        home acti = (home) getActivity();
        acti.getIntraClient().getPhotoUrl();
        //\\
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        avatar = (ImageView) view.findViewById(R.id.Avatar);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
