package com.example.max.kikooworld;

import android.graphics.Bitmap;
import android.os.AsyncTask;

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
    private String login_l;
    private static AsyncHttpClient client = new AsyncHttpClient();
    private Bitmap photoBitmap;
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

    public void login(final RequestParams champs, final String login_str)
    {
        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("[MAXDEBUG] Code de retour : " + statusCode);
                System.out.println("[MAXDEBUG]" + Arrays.toString(headers));
                String s = "";
                login_l = login_str;
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    // PARSING JSON: REPONSE REQUETE "LOGIN" //
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        token = jsonObject.getString("token");
                        System.out.println("[FOXDEBUG] Parsed JSON Token = " + token);
                        // REQUETE PHOTO DANS LA FOULEE //
                        RequestParams photoParams = new RequestParams();
                        photoParams.add("token", token);
                        photoParams.add("login", login_l);
                        getFace(photoParams); // REQUETE PHOTO
                        // ---------------------------- //
                    } catch (JSONException e) { e.printStackTrace(); }
                    // ------------------------------------- //
                } catch (UnsupportedEncodingException e) { e.printStackTrace(); }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("[MAXDEBUG] Code de retour : " + statusCode);
                System.out.println(Arrays.toString(headers));
                System.out.println(Arrays.toString(responseBody));
            }
        });
    }

    public void getFace(RequestParams params)
    {
        // REQUETE PHOTO
        get("photo", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = "";
                try {
                    response = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'photo' request = " + response);
                    try {
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
                System.out.println(Arrays.toString(headers));
                System.out.println(Arrays.toString(responseBody));
            }
        });
    }

    public String getToken()
    {
        return (this.token);
    }

    public String getPhotoUrl()
    {
        return (this.photoUrl);
    }

    public Bitmap getPhotoBitmap()
    {
        return (this.photoBitmap);
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}
