package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Shard.ModulesFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */
/*
login, title, promo, location, course_code, credits, nsstat(active, nslog_norm)
*/

public class UserGetResponse extends AsyncTask<HashMap, Void, UserGetResponse>{
    private String login;
    private String title;
    private String promo;
    private String location;
    private String course_code;
    private String credits;

    @Override
    protected UserGetResponse doInBackground(HashMap... s) {
        HashMap hm = s[0];
        String jsonStr = (String) hm.get("JSON");
        ModulesFragment mf = (ModulesFragment) hm.get("Fragment");
        try {
            JSONObject jsonObject = new JSONObject(jsonStr);
            this.login = jsonObject.getString("login");
            this.title = jsonObject.getString("title");
            this.promo = jsonObject.getString("promo");
            this.location = jsonObject.getString("location");
            this.course_code = jsonObject.getString("course_code");
            this.credits = jsonObject.getString("credits");
            mf.setCourse(this.course_code);
            mf.setLocation(this.location);
            mf.setScolaryear(this.promo);
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
