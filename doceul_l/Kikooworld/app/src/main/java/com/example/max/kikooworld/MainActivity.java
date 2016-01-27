package com.example.max.kikooworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final intraClient client = new intraClient();
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestParams rq = new RequestParams();
                rq.put("login", ((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                rq.put("password", ((EditText) findViewById(R.id.LoginScreenPasswordTextField)).getText());
                client.login(rq);
            }
        });
    }
}
