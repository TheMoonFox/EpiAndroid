package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.ModulesGetItem;
import com.example.max.kikooworld.Shard.ModulesFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Fox on 28/01/2016.
 */
public class AllmodulesGetResponse extends AsyncTask<HashMap, Void, AllmodulesGetResponse> {
    private ArrayList<ModulesGetItem> modulesGetList;
    @Override
    protected AllmodulesGetResponse doInBackground(HashMap... s) {
        HashMap hm = s[0];
        modulesGetList = new ArrayList<ModulesGetItem>();
        JSONObject gigie = null;
        ModulesFragment mf = (ModulesFragment) hm.get("Fragment");
        try { gigie = new JSONObject((String) hm.get("JSON")); }
        catch (JSONException e) { e.printStackTrace(); }
        try {
            JSONArray JA = gigie.getJSONArray("items");
            for (int i = 0; i < JA.length(); i++) {
                JSONObject jsonobject = JA.getJSONObject(i);
                String semester = jsonobject.getString("semester");
                String begin = jsonobject.getString("begin");
                String end = jsonobject.getString("end");
                String end_register = jsonobject.getString("end_register");
                String scolaryear = jsonobject.getString("scolaryear");
                String code = jsonobject.getString("code");
                String codeinstance = jsonobject.getString("codeinstance");
                String instance_location = jsonobject.getString("instance_location");
                String credits = jsonobject.getString("credits");
                String status = jsonobject.getString("status");
                String active_promo = jsonobject.getString("active_promo");
                String open = jsonobject.getString("open");
                String title = jsonobject.getString("title");
                this.modulesGetList.add(new ModulesGetItem(semester, begin, end, end_register,
                        scolaryear, code, codeinstance, instance_location, credits, status,
                        active_promo, open, title));
            }
            mf.setModules(this.modulesGetList);
        } catch (JSONException e) {
            e.printStackTrace();
            mf.setModules(null);
        }
        return this;
    }

}
