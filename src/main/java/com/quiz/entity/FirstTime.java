package com.quiz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FirstTime {
    @Id
    private int id;
    private boolean firstTime=false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isFirstTime() {
        return firstTime;
    }

    public void setFirstTime(boolean firstTime) {
        this.firstTime = firstTime;
    }
}
