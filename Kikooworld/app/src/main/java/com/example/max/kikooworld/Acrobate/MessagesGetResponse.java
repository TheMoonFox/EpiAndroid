package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Fox on 28/01/2016.
 */

public class MessagesGetResponse extends AsyncTask<String, Void, MessagesGetResponse> {
    private ArrayList<MessagesGetItem> messagesGetList;

    @Override
    protected MessagesGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        messagesGetList = new ArrayList<MessagesGetItem>();
        JSONArray jA = null;
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        System.out.println(jA.length());
        try { for (int i = 0; i < jA.length(); i++) {
            System.out.println(i);
            JSONObject json = jA.getJSONObject(i);
            String title = json.getString("title");
            JSONObject user = json.getJSONObject("user");
            String userPicture = user.getString("picture");
            String userTitle = user.getString("title");
            String userUrl = user.getString("url");
            String content = json.getString("content");
            String date = json.getString("date");
            // Creation d'un item de la liste
            this.messagesGetList.add(new MessagesGetItem(title, userPicture, userTitle,
                    userUrl, content, date)); }
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public ArrayList<MessagesGetItem> getMessagesGetList() { return this.messagesGetList; }
}
