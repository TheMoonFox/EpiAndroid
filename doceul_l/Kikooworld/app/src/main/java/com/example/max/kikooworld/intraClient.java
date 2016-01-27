package com.example.max.kikooworld;

import android.os.AsyncTask;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Max on 26/01/2016.
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
                System.out.println("Code de retour : " + statusCode);
                System.out.println(Arrays.toString(headers));
                String s = "";
                try {
                    s = new String(responseBody, "ISO-8859-1");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                System.out.println(s);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                System.out.println("Code de retour : " + statusCode);
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
