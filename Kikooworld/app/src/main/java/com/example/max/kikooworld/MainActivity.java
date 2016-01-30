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
    final intraClient client = new intraClient(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestParams rq = new RequestParams();
                String log = String.valueOf(((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                rq.put("login", log);
                rq.put("password", ((EditText) findViewById(R.id.LoginScreenPasswordTextField)).getText());
                client.loginPostRequest(rq);
            }
        });
    }
}
