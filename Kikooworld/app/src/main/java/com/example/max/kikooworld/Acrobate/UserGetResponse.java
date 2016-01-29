package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Map;

/**
 * Created by Fox on 28/01/2016.
 */
/*
login, title, promo, location, course_code, credits, nsstat(active, nslog_norm)
*/

public class UserGetResponse extends AsyncTask<String, Void, UserGetResponse>{
    private String login;
    private String title;
    private String promo;
    private String location;
    private String course_code;
    private String credits;

    @Override
    protected UserGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            this.login = jsonObject.getString("login");
            this.title = jsonObject.getString("title");
            this.promo = jsonObject.getString("promo");
            this.location = jsonObject.getString("location");
            this.course_code = jsonObject.getString("course_code");
            this.credits = jsonObject.getString("credits");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public String getLogin() { return (this.login); }
    public String getTitle() { return (this.title); }
    public String getPromo() { return (this.promo); }
    public String getLocation() { return (this.location); }
    public String getCourseCode() { return (this.course_code); }
    public String getCredits() { return (this.credits); }
}
