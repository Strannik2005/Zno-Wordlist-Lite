package com.example.znolite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.znolite.Fragments.StudyFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initBottNavBar();
        init();

    }


    private void initBottNavBar(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_study:
                        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new StudyFragment()).commit();
                        break;
                    case R.id.nav_payment:
                        break;
                    case R.id.nav_course_info:
                        break;
                    case R.id.nav_share:
                        Toast.makeText(MainActivity.this, "Придбати весь курс", Toast.LENGTH_SHORT).show();
                        Intent shareIntent = new Intent(Intent.ACTION_SEND);
                        shareIntent.setType("text/plain");
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_text));
                        shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.url_play_store));
                        startActivity(Intent.createChooser(shareIntent, getString(R.string.title_act_share)));
                        break;

                }

                return true;
            }
        });

    }


    private void init(){
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container, new StudyFragment()).commit();
    }





}