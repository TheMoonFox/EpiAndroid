package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.HomeFragmentData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox on 28/01/2016.
 */

public class InfosPostResponse extends AsyncTask<HomeFragmentData, Void, InfosPostResponse> {

    @Override
    protected InfosPostResponse doInBackground(HomeFragmentData... s)
    {
        System.out.println("[YOYOYO] DOINBACKGROUND INFOSPOSTRESPONSE DEBUT");
        HomeFragmentData data = s[0];
        String jsonStr = data.getJsonInfosRequest();
        JSONObject json = null;
        try {
            System.out.println("[YOYOYO] DOINBACKGROUND INFOSPOSTRESPONSE TRY");
            json = new JSONObject(jsonStr);
            JSONArray history = json.getJSONArray("current");
            JSONObject current = history.getJSONObject(0);
            String activelogs = current.getString("active_log");
            if (activelogs != null)
                System.out.println("[FOXDEBUG] INFOSPOSTRESPONSE.ACTIVELOG = " + activelogs);
            else
                System.out.println("[FOXDEBUG] INFOSPOSTRESPONSE.ACTIVELOG = null");
            data.setActiveLog(activelogs);
        } catch (JSONException e) { e.printStackTrace(); }
        System.out.println("[YOYOYO] DOINBACKGROUND INFOSPOSTRESPONSE FIN");
        return this;
    }
}
