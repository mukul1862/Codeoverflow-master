package com.example.hp.codeoverflow2;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hp.codeoverflow2.R;
import com.example.hp.codeoverflow2.adapters.main_adapter;

public class home_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home_activity);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);


            ViewPager viewPager = (ViewPager) findViewById(R.id.vp_home);
            viewPager.setAdapter(new main_adapter(getSupportFragmentManager()));

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tl_title);
            tabLayout.setupWithViewPager(viewPager);
        }catch (Exception e){}

    }
}
