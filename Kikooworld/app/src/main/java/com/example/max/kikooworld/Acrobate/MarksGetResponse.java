package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.Shard.NotesFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Fox on 29/01/2016.
 */

public class MarksGetResponse extends AsyncTask<HashMap, Void, MarksGetResponse> {
    private ArrayList<MarksGetItem> marksGetList;
    @Override
    protected MarksGetResponse doInBackground(HashMap... s) {
        HashMap hm = s[0];
        marksGetList = new ArrayList<MarksGetItem>();
        JSONObject gigie = null;
        NotesFragment nf = (NotesFragment) hm.get("Fragment");
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

}
