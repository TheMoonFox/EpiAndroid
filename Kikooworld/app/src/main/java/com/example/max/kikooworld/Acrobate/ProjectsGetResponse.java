package com.example.max.kikooworld.Acrobate;

import android.os.AsyncTask;

import com.example.max.kikooworld.Acrobate.AcrobateItems.ProjectsGetItem;
import com.example.max.kikooworld.Shard.ProjectsFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Fox on 28/01/2016.
 */

public class ProjectsGetResponse extends AsyncTask<HashMap, Void, ProjectsGetResponse>{
    private ArrayList<ProjectsGetItem> projectsGetList;

    @Override
    protected ProjectsGetResponse doInBackground(HashMap... s) {
        projectsGetList = new ArrayList<ProjectsGetItem>();
        HashMap hm = s[0];
        String jsonStr = (String) hm.get("JSON");
        JSONArray jA = null;
        ProjectsFragment pf = (ProjectsFragment) hm.get("Fragment");
        try { jA = new JSONArray(jsonStr); }
        catch (JSONException e) { e.printStackTrace(); }
        try { for (int i = 0; i < jA.length(); i++) {
                JSONObject jsonobject = jA.getJSONObject(i);
            System.out.println("Objet numéro " + i + " : " + jsonobject.toString());
                String codemodule = jsonobject.getString("codemodule");
                String project = jsonobject.getString("project");
                String end_acti = jsonobject.getString("end_acti");
                String acti_title = jsonobject.getString("acti_title");
                String title_module = jsonobject.getString("title_module");
                String begin_acti = jsonobject.getString("begin_acti");
                String scolaryear = jsonobject.getString("scolaryear");
                String code_location = jsonobject.getString("code_location");
                String type_acti_code = jsonobject.getString("type_acti_code");
                String codeacti = jsonobject.getString("codeacti");
                String registered = jsonobject.getString("registered");
                String codeinstance = jsonobject.getString("codeinstance");
                String type_acti = jsonobject.getString("type_acti");
                // Creation d'un item de la liste
                projectsGetList.add(new ProjectsGetItem(codemodule, project, end_acti,
                        acti_title, title_module, begin_acti, scolaryear, code_location,
                        type_acti_code, codeacti, registered, codeinstance, type_acti));
        }
            pf.setProjects(projectsGetList);
        } catch (JSONException e) {
            e.printStackTrace();
            pf.setProjects(null);
        }
        return this;
    }
}
