package com.example.naari;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.example.naari.activities.HealthActivity;
import com.google.android.material.navigation.NavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Toolbar t;
    DrawerLayout drawer;

    public static void start(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer = findViewById(R.id.draw_activity);
        t = (Toolbar) findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, t, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView nav = findViewById(R.id.nav_view);

        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.nav_sos:
                        Intent in = new Intent(MainActivity.this, call.class);
                        startActivity(in);
                        break;
                    case R.id.nav_cal:
                        Intent intent = new Intent(MainActivity.this, Home.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_settings:
                        Intent i = new Intent(MainActivity.this, Settings.class);
                        startActivity(i);
                        break;
                    case R.id.nav_health:
                        Intent t = new Intent(MainActivity.this, HealthActivity.class);
                        startActivity(t);
                        break;
                    case R.id.nav_fit:
                        Intent s = new Intent(MainActivity.this,fitness.class);
                        startActivity(s);
                        break;

                    case R.id.nav_share:
                        Intent myIntent = new Intent(Intent.ACTION_SEND);
                        myIntent.setType("text/plain");
                        startActivity(Intent.createChooser(myIntent,"SHARE USING"));
                        break;

                    case R.id.nav_cntus:
                        Intent c_us = new Intent(MainActivity.this, activity_contact_us.class);
                        startActivity(c_us);
                        break;
                    case R.id.nav_logout:
                        SharedPreferences sp;
                        sp = getSharedPreferences("USER_CREDENTIALS", MODE_PRIVATE);
                        sp.edit().putBoolean("ISLOGGEDIN",false).apply();
                        startLogin();
                        finish();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
    private void startLogin(){
        LoginActivity.start(this);
    }
   }