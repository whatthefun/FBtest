package com.example.user.fbtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

/**
 * Created by USER on 2016/01/22.
 */
public class Information extends AppCompatActivity {
    private TextView txtInfo;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtInfo = (TextView) findViewById(R.id.txtInfor);
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

    }
}
