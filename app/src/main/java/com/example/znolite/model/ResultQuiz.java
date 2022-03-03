package com.example.znolite.model;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.znolite.MainActivity;
import com.example.znolite.R;

public class ResultQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_quiz);

        int c = getIntent().getIntExtra("correct", 0);
        int b = getIntent().getIntExtra("incorrect", 0);
        TextView tv = findViewById(R.id.correct);
        TextView tv2 = findViewById(R.id.incorrect);
        tv.setText("Correct answers: " + String.valueOf(c));
        tv2.setText("Incorrect answers: " + String.valueOf(b));

        Button backHomeBt = findViewById(R.id.back_home);
        backHomeBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultQuiz.this, MainActivity.class));
            }
        });

    }
}