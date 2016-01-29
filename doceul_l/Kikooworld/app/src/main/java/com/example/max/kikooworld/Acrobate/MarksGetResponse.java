package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Fox on 29/01/2016.
 */

public class MarksGetResponse extends AsyncTask<String, Void, MarksGetResponse> {
    private List<MarksGetItem> marksGetList;
    @Override
    protected MarksGetResponse doInBackground(String... s) {
        String jsonStr = s[0];
        JSONArray jA = null;
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        try { for (int i = 0; i < jA.length(); i++) {
            JSONObject jsonobject = jA.getJSONObject(i);
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
            MarksGetItem item = new MarksGetItem(scolaryear, codemodule, titlemodule,
                    codeinstance, codeacti, title, date, correcteur, final_note, comment);
            marksGetList.add(item); }
        } catch (JSONException e) { e.printStackTrace(); }
        return this;
    }

    public List<MarksGetItem> getMarksGetList() { return this.marksGetList; }
}
