package com.example.max.kikooworld.Shard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.max.kikooworld.HomeFragmentData;
import com.example.max.kikooworld.R;
import com.example.max.kikooworld.home;
import com.squareup.picasso.Picasso;

public class HomeFragment extends Fragment {
    private ImageView avatar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("HomeFragment created");
        //usage intra client dans les fragments
        home acti = (home) getActivity();
        HomeFragmentData data = new HomeFragmentData(acti.getIntraClient().getHomeFragmentData());
        //\\
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        avatar = (ImageView) view.findViewById(R.id.Avatar);
        System.out.println("Bonsoirmézamis");
        System.out.println("HomeData->activeLogs = " + data.getActiveLog());
        System.out.println("HomeData->photoUrl = " + data.getPhotoUrl());
        Picasso.with(getContext()).load(data.getPhotoUrl()).into(avatar);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
}
