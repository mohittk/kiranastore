package com.example.kiranastorejar.model;

import java.util.Date;


public class TransactionRequest {
    private String type;
    private double amount;
    private String currency;
    private Date timestamp;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public void setTimeStamp(Date timeStamp){
        this.timestamp = timeStamp;
    }

    
}