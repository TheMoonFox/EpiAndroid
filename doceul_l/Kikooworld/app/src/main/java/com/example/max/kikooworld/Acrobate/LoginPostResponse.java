package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox on 28/01/2016.
 */

public class LoginPostResponse extends AsyncTask<String, Void, LoginPostResponse>
{
    private String token = "";

    @Override
    protected LoginPostResponse doInBackground(String... s) {
        String jsonStr = s[0];
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            this.token = jsonObject.getString("token");
            System.out.println("[FOXDEBUG] Parsed JSON Token = " + this.token);
            // ---------------------------- //
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getToken() { return (this.token); }
}
