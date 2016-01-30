package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox on 28/01/2016.
 */

public class PhotoGetResponse extends AsyncTask<String, Void, PhotoGetResponse> {
    private String urlPhoto;

        @Override
        protected PhotoGetResponse doInBackground(String... s) {
            String jsonStr = s[0];
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                this.urlPhoto = jsonObject.getString("url");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

    public String getUrlPhoto() { return (this.urlPhoto); }
}
