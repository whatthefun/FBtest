package com.example.user.fbtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by USER on 2016/01/22.
 */
public class Information extends AppCompatActivity {
    private TextView txtName, txtGender, txtBirthday, txtEmail;
    private String info[] = new String[4];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        txtName = (TextView) findViewById(R.id.txtName);
        txtGender = (TextView) findViewById(R.id.txtGender);
        txtBirthday = (TextView) findViewById(R.id.txtBirthday);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        Bundle bundle = getIntent().getExtras();
//        info = bundle.getStringArray("info");
//        txtName.setText("Name:" + info[0]);
//        txtGender.setText("Gender:" + info[1]);
//        txtBirthday.setText("Birthday:" + info[2]);
//        txtEmail.setText("Email:" + info[3]);
        Toast.makeText(this, "??" + bundle.getString("name"),Toast.LENGTH_LONG).show();
        txtName.setText(bundle.getString("name"));
        txtGender.setText(String.format("Gender:%s", bundle.getString("gender")));
        txtBirthday.setText(String.format("Birthday:%s", bundle.getString("birthday")));
        txtEmail.setText(String.format("Email:%s", bundle.getString("email")));
    }
}
