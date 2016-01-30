package com.example.max.kikooworld;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;

import java.util.ArrayList;

/**
 * Created by Fox on 30/01/2016.
 */

public class HomeFragmentData {
    private String activeLog = "";
    private String photoUrl = "";
    private ArrayList<MessagesGetItem> messagesList;
    private String jsonPhotoRequest;
    private String jsonInfosRequest;
    private String jsonMessagesRequest;

    public HomeFragmentData()
    {
        this.jsonPhotoRequest = "COUCOU JE SUIS UN JSON VIDE";
        this.jsonInfosRequest = "COUCOU JE SUIS UN JSON VIDE";
        this.jsonMessagesRequest = "COUCOU JE SUIS UN JSON VIDE";
        this.activeLog="COUCOU JE SUIS UN ACTIVELOG VIDE";
        this.photoUrl="COUCOU JE SUIS TA MERE LA PUTE";
        this.messagesList = new ArrayList<MessagesGetItem>();
    }

    public HomeFragmentData(HomeFragmentData data)
    {
        this.jsonInfosRequest = data.getJsonInfosRequest();
        this.jsonMessagesRequest = data.getJsonMessagesRequest();
        this.jsonPhotoRequest = data.getJsonPhotoRequest();

        this.activeLog = data.getActiveLog();
        this.photoUrl = data.getPhotoUrl();
        this.messagesList = data.getMessagesList();
    }

    public String getJsonPhotoRequest() { return jsonPhotoRequest; }
    public void setJsonPhotoRequest(String jsonPhotoRequest) { this.jsonPhotoRequest = jsonPhotoRequest; }
    public String getJsonInfosRequest() { return jsonInfosRequest; }
    public void setJsonInfosRequest(String jsonInfosRequest) { this.jsonInfosRequest = jsonInfosRequest; }
    public String getJsonMessagesRequest() { return jsonMessagesRequest; }
    public void setJsonMessagesRequest(String jsonMessagesRequest) { this.jsonMessagesRequest = jsonMessagesRequest; }
    public String getActiveLog() { return activeLog; }
    public void setActiveLog(String activeLog) { this.activeLog = activeLog; }
    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }
    public ArrayList<MessagesGetItem> getMessagesList() { return messagesList; }
    public void setMessagesList(ArrayList<MessagesGetItem> messagesList) { this.messagesList = messagesList; }
}
