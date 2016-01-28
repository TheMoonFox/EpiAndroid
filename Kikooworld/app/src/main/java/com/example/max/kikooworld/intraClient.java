package com.example.max.kikooworld;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

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

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public void loginPostRequest(final RequestParams champs)
    {
        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);

                    // PARSING JSON: REPONSE REQUETE "LOGIN" //
                    try {
                        //LoginPostResponse = Acrobate.loginPostParse(s);
                        JSONObject jsonObject = new JSONObject(s);
                        token = jsonObject.getString("token");

                        System.out.println("[FOXDEBUG] Parsed JSON Token = " + token);
                    } catch (JSONException e) { e.printStackTrace(); }
                    // ------------------------------------- //

                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void infosPostRequest(final RequestParams champs) {

        //parameters :
        // /infos POST
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void planningGetRequest(final RequestParams champs) {

        //parameters :
        // /planning GET
        //"token":"login_token"
        //"start":"YEAR-MM-DD"
        //"end":"YEAR-MM-DD"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void projectsGetRequest(final RequestParams champs) {

        //parameters :
        // /projects GET
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void modulesGetRequest(final RequestParams champs) {

        //parameters :
        // /modules GET
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void marksGetRequest(final RequestParams champs) {

        //parameters :
        // /marks GET
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void messagesGetRequest(final RequestParams champs) {

        //parameters :
        // /messages GET
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void alertsGetRequest(final RequestParams champs) {

        //parameters :
        // /alerts GET
        //"token":"login_token"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void photoGetRequest(RequestParams params)
    {
        get("photo", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = "";
                try {
                    response = new String(responseBody, "ISO-8859-1");

                    //DEBUT PARSING//
                    System.out.println("[FOXDEBUG] JSON response to 'photo' request = " + response);
                    try {
                        //InfosPostResponse = Acrobate.infosPostParse(s);
                        JSONObject jsonObject = new JSONObject(response);
                        photoUrl = jsonObject.getString("url");
                        System.out.println("[FOXDEBUG] Parsed JSON Photo URL = " + photoUrl);
                        mainActivity.setPhoto(photoUrl);
                        //photoUrl = photoUrl + ".jpg";
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
                System.out.println("[FOXDEBUG] Code retour 'requete photo' : " + statusCode);
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

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void trombiGetRequest(final RequestParams champs) {

        //parameters :
        // /trombi GET
        //"token":"login_token"
        //"year":2014
        //"location":"FR/GAY"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void userGetRequest(final RequestParams champs) {

        //parameters :
        // /user GET
        //"token":"login_token"
        //"user":"leaugi_n"

        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    //InfosPostResponse = Acrobate.infosPostParse(s);
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                ((TextView) mainActivity.findViewById(R.id.WrongLogin)).setVisibility(View.VISIBLE);
            }
        });
    }

    public void disconnect() {
        token = "";
    }

    public String getPhotoUrl()
    {
        return (this.photoUrl);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}
