package com.example.max.kikooworld.Acrobate.AcrobateItems;

/**
 * Created by Fox on 29/01/2016.
 */

public class MessagesGetItem {
    private String title;
    private String userPicture;
    private String userTitle;
    private String userUrl;
    private String content;
    private String date;

    public MessagesGetItem(String title, String userPicture, String userTitle,
                           String content, String date)
    {
        this.title = title;
        this.userPicture = userPicture;
        this.userTitle = userTitle;
        this.content = content;
        this.date = date;
    }

    public String getTitle(){ return this.title; }
    public String getUserPicture() { return this.userPicture; }
    public String getUserTitle() { return this.userTitle; }
    public String getContent() { return this.content; }
    public String getDate() { return this.date; }
}
