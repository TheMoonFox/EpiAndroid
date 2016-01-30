package com.example.max.kikooworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {
    final static intraClient client = new intraClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Token.value = "";
        Token.userLogin = "";

        final Button button = (Button) findViewById(R.id.loginButton);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                RequestParams rq = new RequestParams();
                String log = String.valueOf(((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                rq.put("login", log);
                rq.put("password", ((EditText) findViewById(R.id.LoginScreenPasswordTextField)).getText());
                client.loginPostRequest(rq, getActivity());
            }
        });
    }

    public MainActivity getActivity() {
        return this;
    }
}
