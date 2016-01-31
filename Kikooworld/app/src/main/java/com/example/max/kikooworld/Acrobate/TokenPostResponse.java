package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */
public class TokenPostResponse {} /*extends AsyncTask<HashMap, Void, String> {
    @Override
    protected String doInBackground(HashMap... s) {
        HashMap hm = s[0];
        JSONObject gigie = null;
        try { gigie = new JSONObject((String) hm.get("JSON")); }
        catch (JSONException e) { e.printStackTrace(); }
        try {
            JSONArray JA = gigie.getJSONArray("notes");
            for (int i = 0; i < JA.length(); i++) {
                JSONObject jsonobject = JA.getJSONObject(i);
                String scolaryear = jsonobject.getString("scolaryear");
                String codemodule = jsonobject.getString("codemodule");
                String titlemodule = jsonobject.getString("titlemodule");
                String codeinstance = jsonobject.getString("codeinstance");
                String codeacti = jsonobject.getString("codeacti");
                String title = jsonobject.getString("title");
                String date = jsonobject.getString("date");
                String correcteur = jsonobject.getString("correcteur");
                String final_note = jsonobject.getString("final_note");
                String comment = jsonobject.getString("comment");
                this.marksGetList.add(new MarksGetItem(scolaryear, codemodule, titlemodule,
                        codeinstance, codeacti, title, date, correcteur, final_note, comment));
            }
            nf.setMarks(this.marksGetList);
        } catch (JSONException e) {
            e.printStackTrace();
            nf.setMarks(null);
        }
        return this;
    }

}*/
