package com.example.max.kikooworld;

import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;

import com.example.max.kikooworld.Acrobate.AcrobateItems.MarksGetItem;
import com.example.max.kikooworld.Acrobate.AcrobateItems.MessagesGetItem;
import com.example.max.kikooworld.Acrobate.AlertsGetResponse;
import com.example.max.kikooworld.Acrobate.InfosPostResponse;
import com.example.max.kikooworld.Acrobate.LoginPostResponse;
import com.example.max.kikooworld.Acrobate.MarksGetResponse;
import com.example.max.kikooworld.Acrobate.MessagesGetResponse;
import com.example.max.kikooworld.Acrobate.PhotoGetResponse;
import com.example.max.kikooworld.Acrobate.PlanningGetResponse;
import com.example.max.kikooworld.Acrobate.UserGetResponse;
import com.example.max.kikooworld.Shard.HomeFragment;
import com.example.max.kikooworld.Shard.NotesFragment;
import com.example.max.kikooworld.Shard.PlanningFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Max on 26/01/2016.
 * Added Token from json to string by Fox on 27/01/2016.
 * Work on doInBackground json parsing by Fox on 28/01/2016.
 */

public class intraClient extends AsyncTask {
    private static final String BASE_URL = "https://epitech-api.herokuapp.com/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public intraClient() {}

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

    public void loginPostRequest(final RequestParams champs, final MainActivity ma)
    {
        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                LoginPostResponse lpr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    lpr = (LoginPostResponse) new LoginPostResponse().execute(s);
                    println("Request OK");
                    Token.value = lpr.getToken();
                    Token.userLogin = String.valueOf(((EditText) ma.findViewById(R.id.LoginScreenLoginTextField)).getText());
                    System.out.println("[FOXDEBUG] TOKEN.USERLOGIN = " + Token.userLogin);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                ((EditText) ma.findViewById(R.id.LoginScreenLoginTextField)).setText("");
                ((EditText) ma.findViewById(R.id.LoginScreenPasswordTextField)).setText("");
                ma.findViewById(R.id.WrongLogin).setVisibility(View.INVISIBLE);
                Intent intent = new Intent(ma.getActivity(), home.class);
                ma.startActivity(intent);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ma.findViewById(R.id.WrongLogin).setVisibility(View.VISIBLE);
            }
        });

    }

    // Renvoie les temps de log
    public void infosPostRequest(final RequestParams champs, final HashMap hm) {

        //parameters :
        // /infos POST
        //"token":"login_token"

        post("infos", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                InfosPostResponse ipr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    hm.put("JSON", s);
                    ipr = (InfosPostResponse) new InfosPostResponse().execute(hm);
                    println("Request OK");
                    ((HomeFragment) hm.get("Fragment")).doLogTime();
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

    public void planningGetRequest(final RequestParams champs, final HashMap hm) {

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
                    hm.put("JSON", s);
                    System.out.println("[MAXDEBUG] JSON response to 'planning' request = " + s);
                    pgr = (PlanningGetResponse) new PlanningGetResponse().execute(hm);
                    println("Request OK");
                    ((PlanningFragment) hm.get("Fragment")).doPlanning();
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

    public void marksGetRequest(final RequestParams champs, final HashMap hm) {

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
                    hm.put("JSON", s);
                    mgr = (MarksGetResponse) new MarksGetResponse().execute(hm);
                    println("Request OK");
                    ((NotesFragment) hm.get("Fragment")).doMarks();
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

    public void messagesGetRequest(final RequestParams champs,  final HashMap hm) {

        get("messages", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                MessagesGetResponse mgr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    hm.put("JSON", s);
                    mgr = (MessagesGetResponse) new MessagesGetResponse().execute(hm);
                    println("Request OK");
                    ((HomeFragment) hm.get("Fragment")).doMess();
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
                AlertsGetResponse agr;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[MAXDEBUG] JSON response to 'alerts' request = " + s);
                    agr = (AlertsGetResponse) new AlertsGetResponse().execute(s);
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

    public void photoGetRequest(RequestParams params,  final HashMap hm)
    {
        get("photo", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = "";
                PhotoGetResponse pgr;
                try {
                    response = new String(responseBody, "ISO-8859-1");
                    hm.put("JSON", response);
                    pgr = (PhotoGetResponse) new PhotoGetResponse().execute(hm);
                    println("Request OK");
                    ((HomeFragment) hm.get("Fragment")).doFace();
                } catch (UnsupportedEncodingException e) {
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

    public void println(String s) {
        System.out.println(s);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }

}