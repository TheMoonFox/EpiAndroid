package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Shard.HomeFragment;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */

public class PhotoGetResponse extends AsyncTask<HashMap, Void, PhotoGetResponse> {

        @Override
        protected PhotoGetResponse doInBackground(HashMap... s) {
            HashMap data = s[0];
            String jsonStr = (String) data.get("JSON");
            HomeFragment hf = (HomeFragment) data.get("Fragment");
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                hf.setFace(jsonObject.getString("url"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return this;
        }
}
