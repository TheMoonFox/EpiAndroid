package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox on 28/01/2016.
 */

public class InfosPostResponse extends AsyncTask<String, Void, InfosPostResponse> {
private String activeLog = "";

    @Override
    protected InfosPostResponse doInBackground(String... s)
    {
        String jsonStr = s[0];
        JSONObject json = null;
        try {
            json = new JSONObject(jsonStr);
            JSONObject history = json.getJSONObject("history");
            JSONObject current = history.getJSONObject("current");
            this.activeLog = current.getString("active_log");
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public String getActiveLog() { return this.activeLog; }
}
