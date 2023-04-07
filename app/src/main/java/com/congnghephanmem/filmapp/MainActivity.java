package com.congnghephanmem.filmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.congnghephanmem.filmapp.fragment.film_doc_quyen;
import com.congnghephanmem.filmapp.fragment.home;
import com.congnghephanmem.filmapp.fragment.profile;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.bottom_nav)
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new home();
                    break;
                case R.id.copyright:
                    selectedFragment = new film_doc_quyen();
                    break;
                case R.id.profile:
                    selectedFragment = new profile();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment,selectedFragment).commit();
            return true;
        }
    };
}