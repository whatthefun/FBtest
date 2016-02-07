package com.example.user.fbtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONObject;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    CallbackManager callbackManager;
    private LoginButton btnFBLogin;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(this.getApplicationContext());

        btnFBLogin = (LoginButton) findViewById(R.id.btnFBLogin);
        btnFBLogin.setReadPermissions(Arrays.asList("public_profile, email, user_birthday"));//下載時，顯示的權限請求
        callbackManager = CallbackManager.Factory.create();
        btnFBLogin.registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(
                                            JSONObject object,
                                            GraphResponse response) {
                                        String str[] = new String[4];
                                        str[0] = object.optString("name");
                                        str[1] = object.optString("gender");
                                        str[2] = object.optString("email");
                                        str[3] = object.optString("birthday");

                                        Intent intent = new Intent();//利用intent切換activity
                                        intent.setClass(MainActivity.this, Information.class);
                                        Bundle bundle = new Bundle();//利用bundle夾帶資料
                                        bundle.putStringArray("info", str);
                                        intent.putExtras(bundle);
                                        startActivity(intent);
                                        Log.e("LoginActivity", object.toString());
                                    }
                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields", "name, email, gender, birthday");//拿取登入者特定資料
                        request.setParameters(parameters);
                        request.executeAsync();
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });

    }
}
