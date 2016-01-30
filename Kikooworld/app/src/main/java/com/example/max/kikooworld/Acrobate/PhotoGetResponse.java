package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.HomeFragmentData;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Fox on 28/01/2016.
 */

public class PhotoGetResponse extends AsyncTask<HomeFragmentData, Void, PhotoGetResponse> {
    private String urlPhoto;

        @Override
        protected PhotoGetResponse doInBackground(HomeFragmentData... s) {
            HomeFragmentData data = s[0];
            String jsonStr = data.getJsonPhotoRequest();
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                this.urlPhoto = jsonObject.getString("url");
                System.out.println("[PHOTOGETRESPONSE] url = " + this.urlPhoto);
                data.setPhotoUrl(this.urlPhoto);
                System.out.println("[HOMEFRAGMENTDATA] photoUrl = " + data.getPhotoUrl());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }

    public String getUrlPhoto() { return (this.urlPhoto); }
}
