package com.example.hp.codeoverflow2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void login(View v){
        Intent intent = new Intent(this, login_activity.class);
        startActivity(intent);

    }
    public void signup(View v){
        Intent intent = new Intent(this, signup_activity.class);
        startActivity(intent);

    }
}
