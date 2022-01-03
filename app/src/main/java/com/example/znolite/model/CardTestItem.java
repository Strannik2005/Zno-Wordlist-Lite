package com.example.znolite.model;

import android.content.Context;


public class CardTestItem {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardTestItem(Context c, String name) {
        this.name = name;
    }
}
