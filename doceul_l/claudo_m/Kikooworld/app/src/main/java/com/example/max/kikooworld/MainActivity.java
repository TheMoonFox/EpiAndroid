package com.example.max.kikooworld;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.loopj.android.http.*;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;

import android.content.Intent;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestParams rq = new RequestParams();
                rq.put("login", ((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                rq.put("password", ((EditText) findViewById(R.id.LoginScreenPasswordTextField)).getText());
                intraClient.post("login", rq, new AsyncHttpResponseHandler() {
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                        System.out.println("Code de retour : " + statusCode);
                        System.out.println(Arrays.toString(headers));
                        String s = "";
                        try {
                            s = new String(responseBody, "ISO-8859-1");
                            Intent intent = new Intent(MainActivity.this, home.class);
                            startActivity(intent);
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
        });
    }

}
