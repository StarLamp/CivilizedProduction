package com.example.administrator.civilizedproduction.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.administrator.civilizedproduction.R;
import com.example.administrator.civilizedproduction.fragment.MainFragment;
import com.example.administrator.civilizedproduction.fragment.MeFragment;
import com.example.administrator.civilizedproduction.fragment.RecordFragment;

public class MainActivity extends AppCompatActivity {

    protected Fragment mainFragment = new MainFragment();
    protected Fragment recordFragment = new RecordFragment();
    protected Fragment meFragment = new MeFragment();
    protected FragmentManager fm = getSupportFragmentManager();
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    fm.beginTransaction().show(mainFragment)
                        .hide(meFragment)
                        .hide(recordFragment)
                        .commit();
                    return true;
                case R.id.navigation_dashboard:
                    fm.beginTransaction().show(recordFragment)
                            .hide(meFragment)
                            .hide(mainFragment)
                            .commit();
                    return true;
                case R.id.navigation_notifications:
                    fm.beginTransaction().show(meFragment)
                            .hide(mainFragment)
                            .hide(recordFragment)
                            .commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm.beginTransaction()
                .add(R.id.container,mainFragment)
                .add(R.id.container,meFragment)
                .add(R.id.container,recordFragment)
                .show(mainFragment)
                        .hide(meFragment)
                        .hide(recordFragment)
                        .commit();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
