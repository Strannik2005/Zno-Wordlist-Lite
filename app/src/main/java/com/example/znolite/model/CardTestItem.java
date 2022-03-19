package com.example.znolite.model;



public class CardTestItem {


    public int id;
    public String name;
    public String percentCorrectAnswers;


    public CardTestItem(int id, String name, String percentCorrectAnswers) {
        this.id = id;
        this.name = name;
        this.percentCorrectAnswers = percentCorrectAnswers;
    }


    public CardTestItem( String name, String percentCorrectAnswers) {
        this.name = name;
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPercentCorrectAnswers() {
        return percentCorrectAnswers;
    }

    public void setPercentCorrectAnswers(String percentCorrectAnswers) {
        this.percentCorrectAnswers = percentCorrectAnswers;
    }
}
