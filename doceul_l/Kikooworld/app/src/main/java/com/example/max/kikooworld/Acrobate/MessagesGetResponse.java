package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Fox on 28/01/2016.
 */

public class MessagesGetResponse extends AsyncTask<String, Void, MessagesGetResponse> {
    private List<MessagesGetItem> messagesGetList;

    @Override
    protected MessagesGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        JSONArray jA = null;
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        try { for (int i = 0; i < jA.length(); i++) {
            JSONObject json = jA.getJSONObject(i);
            String title = json.getString("title");
            JSONObject user = json.getJSONObject("user");
            String userPicture = user.getString("picture");
            String userTitle = user.getString("title");
            String userUrl = user.getString("url");
            String content = json.getString("content");
            String date = json.getString("date");
            // Creation d'un item de la liste
            MessagesGetItem item = new MessagesGetItem(title, userPicture, userTitle,
                    userUrl, content, date);
            messagesGetList.add(item); }
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public List<MessagesGetItem> getMessagesGetList() { return this.messagesGetList; }
}
