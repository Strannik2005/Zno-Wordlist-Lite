package com.example.znolite;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.znolite.adapters.AllTestAdapter;
import com.example.znolite.model.CardTestItem;

import java.util.ArrayList;

public class TestsActivity extends AppCompatActivity {

    ArrayList<CardTestItem> cards = new ArrayList<CardTestItem>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);
        initToolbar();

        fillArray();

        RecyclerView recyclerViewTests = findViewById(R.id.rv);

        AllTestAdapter adapter = new AllTestAdapter(this, cards);
        recyclerViewTests.setAdapter(adapter);

        recyclerViewTests.setLayoutManager(new LinearLayoutManager(this));


    }


    private void initToolbar(){
        Toolbar t  = findViewById(R.id.toolbar_tests);
        setSupportActionBar(t);
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

    private void fillArray(){
        cards.add(new CardTestItem(this,"Test 1"));
        cards.add(new CardTestItem(this, "Test 2"));
        cards.add(new CardTestItem(this, "Test 3"));
        cards.add(new CardTestItem(this, "Test 4"));
        cards.add(new CardTestItem(this, "Test 5"));
        cards.add(new CardTestItem(this, "Test 6"));
        cards.add(new CardTestItem(this, "Test 7"));
        cards.add(new CardTestItem(this, "Test 8"));
        cards.add(new CardTestItem(this, "Test 9"));
        cards.add(new CardTestItem(this, "Test 10"));
        cards.add(new CardTestItem(this, "Test 11"));
        cards.add(new CardTestItem(this, "Test 12"));
        cards.add(new CardTestItem(this, "Test 13"));
        cards.add(new CardTestItem(this, "Test 14"));
        cards.add(new CardTestItem(this, "Test 15"));
        cards.add(new CardTestItem(this, "Test 16"));
    }
}