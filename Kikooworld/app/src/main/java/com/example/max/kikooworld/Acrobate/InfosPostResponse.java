package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Shard.HomeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */

public class InfosPostResponse extends AsyncTask<HashMap, Void, InfosPostResponse> {

    @Override
    protected InfosPostResponse doInBackground(HashMap... s)
    {
        HashMap data = s[0];
        String jsonStr = (String) data.get("JSON");
        HomeFragment hf = (HomeFragment) data.get("Fragment");
        JSONObject json = null;
        try {
            json = new JSONObject(jsonStr);
            JSONArray history = json.getJSONArray("current");
            JSONObject current = history.getJSONObject(0);
            String activelogs = current.getString("active_log");
            try {
                System.out.println(activelogs);
            }
            catch (Exception e) { e.printStackTrace(); }
            if (activelogs == null || activelogs.isEmpty() || activelogs.length() == 0 || activelogs == "null")
                hf.setLogTime("0 hours");
            else
                hf.setLogTime(activelogs + " hours");
        } catch (JSONException e) { e.printStackTrace(); }
        System.out.println("[YOYOYO] DOINBACKGROUND INFOSPOSTRESPONSE FIN");
        return this;
    }

}
