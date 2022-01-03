package com.example.znolite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ActivityContentTests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_tests);
        initToolbar();
    }

    private void initToolbar(){

        TextView tv = findViewById(R.id.toolbarTitleNameTest);

        String nameItem = getIntent().getExtras().getString("key_name");


        Toolbar t  = findViewById(R.id.toolbar_name_of_test);
        setSupportActionBar(t);
        tv.setText(nameItem);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
}