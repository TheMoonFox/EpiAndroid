package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;
import com.example.max.kikooworld.Shard.HomeFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */

public class MessagesGetResponse extends AsyncTask<HashMap, Void, MessagesGetResponse> {
    private ArrayList<MessagesGetItem> messagesGetList;

    @Override
    protected MessagesGetResponse doInBackground(HashMap... s) {
        HashMap data = s[0];
        String jsonStr = (String) data.get("JSON");
        messagesGetList = new ArrayList<MessagesGetItem>();
        JSONArray jA = null;
        HomeFragment hf = (HomeFragment) data.get("Fragment");
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        try { for (int i = 0; i < jA.length(); i++) {
            JSONObject json = jA.getJSONObject(i);
            String title = json.getString("title");
            JSONObject user = json.getJSONObject("user");
            String userPicture = user.getString("picture");
            String userTitle = user.getString("title");
            String content = json.getString("content");
            String date = json.getString("date");
            // Creation d'un item de la liste
            this.messagesGetList.add(new MessagesGetItem(title, userPicture, userTitle, content, date));
        }
            hf.setMess(this.messagesGetList);
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

}
