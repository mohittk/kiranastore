package com.example.kiranastorejar.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Transaction {
    @Id
    private String id;
    private String type;
    private double amount;
    private String currency;
    private Date timestamp;

    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    

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

   

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimeStamp(Date timeStamp){
        this.timestamp = timeStamp;
    }

 
}