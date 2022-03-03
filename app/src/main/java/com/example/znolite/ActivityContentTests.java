package com.example.znolite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.znolite.model.ResultQuiz;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class ActivityContentTests extends AppCompatActivity {

    TextView tv;
    String nameItem;


    List<QuestionsList> questionsLists;

    private int currentQuestionPosition = 0;

    TextView questionText, tv_timer;
    Button op1, op2, op3, op4, nxt;


    Timer timer;
    private int seconds = 0;
    private int totalTime = 1;

    private String selectedOptionByUser = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_tests);


        nameItem = getIntent().getExtras().getString("key_name");

        initFindById();
        fillTestQuestions();
        initToolbar();

        startTimer(tv_timer);


    }


    private void fillTestQuestions() {
        questionText.setText(questionsLists.get(0).getQuestion());
        op1.setText(questionsLists.get(0).getOption1());
        op2.setText(questionsLists.get(0).getOption2());
        op3.setText(questionsLists.get(0).getOption3());
        op4.setText(questionsLists.get(0).getOption4());
    }

    private void changeNextQuestion(){
        currentQuestionPosition++;

        if((currentQuestionPosition + 1) == questionsLists.size()){
            nxt.setText("Submit");
        }

        if(currentQuestionPosition < questionsLists.size()){

            selectedOptionByUser = "";

            op1.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            op2.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            op3.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            op4.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

            questionText.setText(questionsLists.get(currentQuestionPosition).getQuestion());
            op1.setText(questionsLists.get(currentQuestionPosition).getOption1());
            op2.setText(questionsLists.get(currentQuestionPosition).getOption2());
            op3.setText(questionsLists.get(currentQuestionPosition).getOption3());
            op4.setText(questionsLists.get(currentQuestionPosition).getOption4());

        }else{

            Intent i = new Intent(ActivityContentTests.this, ResultQuiz.class);
            i.putExtra("correct", getCorrectAnswers());
            i.putExtra("incorrect", getIncorrectAnswers());
            startActivity(i);
        }
    }


    private void initToolbar() {
        Toolbar t = findViewById(R.id.toolbar_name_of_test);
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

    private void initFindById() {
        questionsLists = QuestionsBank.getQuestions(nameItem);

        tv = findViewById(R.id.toolbarTitleNameTest);
        tv_timer = findViewById(R.id.tv_timer);

        questionText = findViewById(R.id.questWord);
        op1 = findViewById(R.id.answerBt1);
        op2 = findViewById(R.id.answerBt2);
        op3 = findViewById(R.id.answerBt3);
        op4 = findViewById(R.id.answerBt4);
        nxt = findViewById(R.id.nextBt);

        op1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = op1.getText().toString();
                    op1.setBackgroundColor(Color.GRAY);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        op2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = op2.getText().toString();
                    op2.setBackgroundColor(Color.GRAY);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }

            }
        });

        op3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = op3.getText().toString();
                    op3.setBackgroundColor(Color.GRAY);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        op4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){

                    selectedOptionByUser = op4.getText().toString();
                    op4.setBackgroundColor(Color.GRAY);

                    revealAnswer();

                    questionsLists.get(currentQuestionPosition).setUserSelectedAnswer(selectedOptionByUser);
                }
            }
        });

        nxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(selectedOptionByUser.isEmpty()){
                    Toast.makeText(ActivityContentTests.this, "Please choose option.", Toast.LENGTH_SHORT).show();
                }else {
                    changeNextQuestion();

                }
            }
        });
    }



    public int getCorrectAnswers() {

        int correctAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (getUserSelectedAnswer.equals(getAnswer)) {
                correctAnswers++;
            }

        }

        return correctAnswers;
    }

    public int getIncorrectAnswers() {

        int incorrectAnswers = 0;

        for (int i = 0; i < questionsLists.size(); i++) {

            final String getUserSelectedAnswer = questionsLists.get(i).getUserSelectedAnswer();
            final String getAnswer = questionsLists.get(i).getAnswer();

            if (!getUserSelectedAnswer.equals(getAnswer)) {
                incorrectAnswers++;
            }

        }

        return incorrectAnswers;
    }





    private void startTimer(TextView timer_tv){
        timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                if(seconds == 0){
                    totalTime--;
                    seconds = 59;
                }else if(seconds == 0 && totalTime == 0){

                    timer.purge();
                    timer.cancel();

                    Toast.makeText(ActivityContentTests.this, "Time Over", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(ActivityContentTests.this, ResultQuiz.class);
                    i.putExtra("correct", getCorrectAnswers());
                    i.putExtra("incorrect", getIncorrectAnswers());
                    startActivity(i);

                    finish();
                }else{
                    seconds--;
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        String finalMinutes = String.valueOf(totalTime);
                        String finalSeconds = String.valueOf(seconds);

                        if(finalMinutes.length() == 1){
                            finalMinutes = "0" + finalMinutes;
                        }

                        if(finalSeconds.length() == 1){
                            finalSeconds = "0" + finalSeconds;
                        }

                        timer_tv.setText(finalMinutes+":"+finalSeconds);
                    }
                });

            }
        }, 1000, 1000);

    }

    @Override
    public void onBackPressed() {
        timer.purge();
        timer.cancel();

        startActivity(new Intent(ActivityContentTests.this, MainActivity.class));
        finish();
    }


    private void revealAnswer(){

        String getAnswer = questionsLists.get(currentQuestionPosition).getAnswer();

        if(op1.getText().toString().equals(getAnswer)){
            op1.setBackgroundColor(Color.GREEN);
        }else if(op2.getText().toString().equals(getAnswer)){
            op2.setBackgroundColor(Color.GREEN);
        }else if(op3.getText().toString().equals(getAnswer)){
            op3.setBackgroundColor(Color.GREEN);
        }else if(op4.getText().toString().equals(getAnswer)){
            op4.setBackgroundColor(Color.GREEN);
        }
    }
}









