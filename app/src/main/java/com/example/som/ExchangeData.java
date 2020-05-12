package com.example.som;

import java.io.Serializable;

public class ExchangeData implements Serializable {

    private String date, rate;

    public ExchangeData(){}

    public ExchangeData(String date, String rate){
        this.date = date;
        this.rate = rate;
    }

    public String getRate() { return this.rate; }

    public String getDate() { return this.date; }

    public void setDate(String date) { this.date = date; }

    public void setRate(String rate) { this.rate = rate; }

}
