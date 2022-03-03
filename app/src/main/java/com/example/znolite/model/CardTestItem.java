package com.example.znolite.model;


public class CardTestItem {


    String id;
    private String name;
    String percentCorrectAnswers;

    public CardTestItem(String name, String percentCorrectAnswers) {
        this.name = name;
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    public CardTestItem(int id, String name, String percentCorrectAnswers) {
        this.name = name;
        this.percentCorrectAnswers = percentCorrectAnswers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
