package com.example.naari;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

public class LoginActivity extends AppCompatActivity  {
    TabLayout tabLayout;
    ViewPager viewPager;
    private float v;

    public static void start(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tabLayout=findViewById(R.id.tab_layout);
        viewPager=findViewById(R.id.view_pager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final LoginAdapter adapter=new LoginAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

    }
    @Override
    protected void onStart() {
        super.onStart();
        checkForLogin();
    }

    private void checkForLogin() {
        final SharedPreferences sharedPreferences = getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
        final Boolean isloggedin=sharedPreferences.getBoolean("ISLOGGEDIN",false);

        if(isloggedin){
            startMainActivity();
        }
    }

    private void startMainActivity() {
        MainActivity.start(LoginActivity.this);
        finish();
    }


}