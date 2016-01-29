package com.example.max.kikooworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;
import com.example.max.kikooworld.Acrobate.MarksGetResponse;
import com.example.max.kikooworld.Acrobate.MessagesGetResponse;
import com.example.max.kikooworld.Acrobate.PlanningGetResponse;
import com.example.max.kikooworld.Acrobate.UserGetResponse;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Max on 26/01/2016.
 * Added Token from json to string by Fox on 27/01/2016.
 * Work on doInBackground json parsing by Fox on 28/01/2016.
 */

public class intraClient extends AsyncTask {
    private static final String BASE_URL = "https://epitech-api.herokuapp.com/";
    private String token;
    private String photoUrl;
    private static AsyncHttpClient client = new AsyncHttpClient();
    private MainActivity mainActivity;

    public intraClient(MainActivity mainActivity)
    {
        this.mainActivity = mainActivity;
    }

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void del(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.delete(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public void loginPostRequest(final RequestParams champs)
    {
        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //LoginPostResponse lpr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);

                    // PARSING JSON: REPONSE REQUETE "LOGIN" //
                    try {
                        //lpr = new loginPostResponse().execute(s);
                        println("Request OK");
                        JSONObject jsonObject = new JSONObject(s);
                        token = jsonObject.getString("token");
                        System.out.println("[FOXDEBUG] Parsed JSON Token = " + token);
                        Intent intent = new Intent(mainActivity, home.class);
                        mainActivity.startActivity(intent);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    // ------------------------------------- //

                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                (mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void infosPostRequest(final RequestParams champs) {

        //parameters :
        // /infos POST
        //"token":"login_token"

        post("infos", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //InfosPostRequest ipr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'infos' request = " + s);
                    //ipr = new InfosPostRequest().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("infosPostRequest failed, error code : " + statusCode);
            }
        });
    }

    public void planningGetRequest(final RequestParams champs) {

        //parameters :
        // /planning GET
        //"token":"login_token"
        //"start":"YEAR-MM-DD"
        //"end":"YEAR-MM-DD"

        get("planning", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                PlanningGetResponse pgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'planning' request = " + s);
                    pgr = (PlanningGetResponse) new PlanningGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("planningGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void projectsGetRequest(final RequestParams champs) {

        //parameters :
        // /projects GET
        //"token":"login_token"

        get("projects", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ProjectsGetResponse pgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'projects' request = " + s);
                    //pgr = new ProjectsGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("projectsGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void projectGetRequest(final RequestParams champs) {

        //parameters :
        // /project GET
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-6-9"
        //"codeacti":"acti-123456"

        get("project", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ProjectGetResponse pgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'project' request = " + s);
                    //pgr = new ProjectGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("projectGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void projectPostRequest(final RequestParams champs) {

        //parameters :
        // /project POST
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"

        post("project", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ProjectPostResponse ppr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'project' request = " + s);
                    //ppr = new ProjectPostResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("projectPostRequest failed, error code : " + statusCode);
            }
        });
    }

    public void projectDeleteRequest(final RequestParams champs) {

        //parameters :
        // /project DELETE
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"

        del("project", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ProjectDeleteResponse pdr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'project' request = " + s);
                    //pdr = new ProjectDeleteResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("projectDeleteRequest failed, error code : " + statusCode);
            }
        });
    }

    public void projectFilesGetRequest(final RequestParams champs) {

        //parameters :
        // /project/files GET
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"

        get("project/files", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ProjectFilesGetRequest pfgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'project' request = " + s);
                    //pfgr = new ProjectFilesGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("projectFilesGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void modulesGetRequest(final RequestParams champs) {

        //parameters :
        // /modules GET
        //"token":"login_token"

        get("modules", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ModulesGetResponse mgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'modules' request = " + s);
                    //mgr = new ModulesGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("modulesGetResponse failed, error code : " + statusCode);
            }
        });
    }

    public void allmodulesGetRequest(final RequestParams champs) {

        //parameters :
        // /allmodules GET
        //"token":"login_token"
        //"scolaryear":2014
        //"location":"FR/GAY"
        //"course":"bachelor/dummy"

        get("allmodules", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //AllmodulesGetResponse agr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'allmodules' request = " + s);
                    //agr = new AllmodulesGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("allmodulesGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void moduleGetRequest(final RequestParams champs) {

        //parameters :
        // /module GET
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"

        get("module", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ModuleGetResponse mgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'module' request = " + s);
                    //mgr = new ModuleGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("moduleGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void modulePostRequest(final RequestParams champs) {

        //parameters :
        // /module POST
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"

        post("module", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ModulePostResponse mpr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'module' request = " + s);
                    //mpr = new ModulePostResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("modulePostRequest failed, error code : " + statusCode);
            }
        });
    }

    public void moduleDeleteRequest(final RequestParams champs) {

        //parameters :
        // /module DELETE
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"

        del("module", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //ModuleDeleteResponse mdr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'module' request = " + s);
                    //mdr = new ModuleDeleteResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("moduleDeleteRequest failed, error code : " + statusCode);
            }
        });
    }

    public void eventGetRequest(final RequestParams champs) {

        //parameters :
        // /event GET
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"
        //"codeevent":"event-123456"

        get("event", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //EventGetRequest egr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'event' request = " + s);
                    //egr = new EventGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("eventGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void eventPostRequest(final RequestParams champs) {

        //parameters :
        // /event POST
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"
        //"codeevent":"event-123456"

        post("event", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //EventPostRequest epr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'event' request = " + s);
                    //epr = new EventPostResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("eventPostRequest failed, error code : " + statusCode);
            }
        });
    }

    public void eventDeleteRequest(final RequestParams champs) {

        //parameters :
        // /event DELETE
        //"token":"login_token"
        //"scolaryear":int
        //"codemodule":"B-GAY-666-1"
        //"codeinstance":"GAY-666-9"
        //"codeacti":"acti-123456"
        //"codeevent":"event-123456"

        del("event", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //EventDeleteResponse edr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'event' request = " + s);
                    //edr = new EventDeleteResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("eventDeleteRequest failed, error code : " + statusCode);
            }
        });
    }

    public void marksGetRequest(final RequestParams champs) {

        //parameters :
        // /marks GET
        //"token":"login_token"

        get("marks", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                MarksGetResponse mgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    //System.out.println("[MAXDEBUG] JSON response to 'marks' request = " + s);
                    mgr = (MarksGetResponse) new MarksGetResponse().execute(s);
                    println("Request OK");
                    ArrayList<MarksGetItem> lily = mgr.getMarksGetList();
                    System.out.println(lily.get(0).getCorrecteur());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("marksGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void messagesGetRequest(final RequestParams champs) {

        //parameters :
        // /messages GET
        //"token":"login_token"

        get("messages", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                MessagesGetResponse mgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'messages' request = " + s);
                    mgr = (MessagesGetResponse) new MessagesGetResponse().execute(s);
                    println("Request OK");
                    ArrayList<MessagesGetItem> lily = mgr.getMessagesGetList();
                    System.out.println(lily.get(0).getUserUrl());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("messagesGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void alertsGetRequest(final RequestParams champs) {

        //parameters :
        // /alerts GET
        //"token":"login_token"

        get("alerts", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //AlertsGetResponse agr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'alerts' request = " + s);
                    //agr = new AlertsGetResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("alertsGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void photoGetRequest(RequestParams params)
    {
        get("photo", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = "";
                //PhotoGetResponse pgr;
                try {
                    response = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'photo' request = " + response);
                    //pgr = new PhotoGetResponse().execute(s);
                    println("Request OK");
                }
                // ------------------------------------- //
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("photoGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void tokenPostRequest(final RequestParams champs) {

        //parameters :
        // /token POST
        //"token":"login_token"
        //"scolaryear":2014
        //"codemodule":"B-GAY-666-9"
        //"codeinstance":"GAY-6-9"
        //"codeacti":"acti-123456"
        //"codeevent":"event-123456"
        //"tokenvalidationcode":"12345678"

        post("token", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //TokenPostRequest tpr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'token' request = " + s);
                    //tpr = new TokenPostResponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("tokenPostRequest failed, error code : " + statusCode);
            }
        });
    }

    public void trombiGetRequest(final RequestParams champs) {

        //parameters :
        // /trombi GET
        //"token":"login_token"
        //"year":2014
        //"location":"FR/GAY"

        get("trombi", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                //TrombiGetResponse tgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'trombi' request = " + s);
                    //tgr = new TrombiGetRespponse().execute(s);
                    println("Request OK");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("trombiGetRequest failed, error code : " + statusCode);
            }
        });
    }

    public void userGetRequest(final RequestParams champs) {

        //parameters :
        // /user GET
        //"token":"login_token"
        //"user":"leaugi_n"

        get("user", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                UserGetResponse ugr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'user' request = " + s);
                    ugr = (UserGetResponse) new UserGetResponse().execute(s);
                    println("request OK");
                    System.out.println(ugr.getCourseCode());
                    System.out.println(ugr.getCredits());
                    System.out.println(ugr.getLocation());
                    System.out.println(ugr.getLogin());
                    System.out.println(ugr.getPromo());
                    System.out.println(ugr.getTitle());
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("userGetRequest failed, error code : " + statusCode);
            }
        });
    }

    private void println(String s) {
        System.out.println(s);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        token = "";
    }

    public String getPhotoUrl()
    {
        return (this.photoUrl);
    }

    public String getToken() {
        return this.token;
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}