package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Fox on 29/01/2016.
 */

public class MarksGetResponse extends AsyncTask<String, Void, MarksGetResponse> {
    private ArrayList<MarksGetItem> marksGetList;
    @Override
    protected MarksGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        marksGetList = new ArrayList<MarksGetItem>();
        JSONObject gigie = null;
        try { gigie = new JSONObject(jsonStr); }
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
            // Creation d'un item de la liste
            this.marksGetList.add(new MarksGetItem(scolaryear, codemodule, titlemodule,
                    codeinstance, codeacti, title, date, correcteur, final_note, comment)); }
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public ArrayList<MarksGetItem> getMarksGetList() { return this.marksGetList; }
}
