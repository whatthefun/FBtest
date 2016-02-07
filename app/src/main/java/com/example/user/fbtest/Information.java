package com.example.user.fbtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by USER on 2016/01/22.
 */
public class Information extends AppCompatActivity {
    private TextView txtName, txtGender, txtBirthday, txtEmail;
    private String info[] = new String[4];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infor);
        txtName = (TextView) findViewById(R.id.txtName);
        txtGender = (TextView) findViewById(R.id.txtGender);
        txtBirthday = (TextView) findViewById(R.id.txtBirthday);
        txtEmail = (TextView) findViewById(R.id.txtEmail);

        Bundle bundle = getIntent().getExtras();//利用bundle拿取夾帶資料
        info = bundle.getStringArray("info");

        txtName.setText("Name:" + info[0]);
        txtGender.setText("Gender:" + info[1]);
        txtBirthday.setText("Birthday:" + info[3]);
        txtEmail.setText("Email:\n" + info[2]);

    }
}
