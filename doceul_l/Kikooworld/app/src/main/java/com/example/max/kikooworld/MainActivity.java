package com.example.max.kikooworld;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;

import com.loopj.android.http.RequestParams;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;
    private Bitmap bmp;
    final intraClient client = new intraClient(this);
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button = (Button) findViewById(R.id.loginButton);
        imgView = (ImageView) findViewById(R.id.imageView);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                RequestParams rq = new RequestParams();
                rq.put("login", ((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                rq.put("password", ((EditText) findViewById(R.id.LoginScreenPasswordTextField)).getText());
                String logi = String.valueOf(((EditText) findViewById(R.id.LoginScreenLoginTextField)).getText());
                client.login(rq, logi);
            }
        });
    }

    public void setPhoto(String photoUrl)
    {
        // REVELE L'HORRIBLE VISAGE DE L'UTILISATEUR (voir INTRACLIENT) //
        Picasso.with(getApplicationContext()).load(photoUrl).into((ImageView) findViewById(R.id.imageView));
        System.out.println("[FOXDEBUG] Tentative de révéler l'horrible visage terminée.");
        // ------------------------------------------------------------- //
    }
}
