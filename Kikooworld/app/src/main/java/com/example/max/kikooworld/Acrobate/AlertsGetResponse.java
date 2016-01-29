package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Fox on 28/01/2016.
 */
public class AlertsGetResponse extends AsyncTask<String, Void, AlertsGetResponse> {

    private ArrayList<String> alertsGetList;

    @Override
    protected AlertsGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        alertsGetList = new ArrayList<String>();
        JSONArray jA = null;
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        try { for (int i = 0; i < jA.length(); i++) {
            JSONObject json = jA.getJSONObject(i);
            String title = json.getString("title");
            this.alertsGetList.add(title); }
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public ArrayList<String> getAlertsGetList() { return this.alertsGetList; }
}
