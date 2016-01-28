package com.example.max.kikooworld;

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

    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }

    public static void login(RequestParams champs)
    {
        post("login", champs, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                System.out.println("[MAXDEBUG] Code de retour : " + statusCode);
                System.out.println("[MAXDEBUG]" + Arrays.toString(headers));
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                    System.out.println("[FOXDEBUG] JSON response to 'login' request = " + s);
                    // PARSING JSON: REPONSE REQUETE "LOGIN" -> CLASS TOKEN (temporaire) //
                    try {
                        JSONObject jsonObject = new JSONObject(s);
                        Token token = new Token(jsonObject.getString("token"));
                        System.out.println("[FOXDEBUG] Parsed JSON Token = " + token.getToken());
                    } catch (JSONException e) { e.printStackTrace(); }
                    // ----------------------------------------------------------------- //
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

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }
}
