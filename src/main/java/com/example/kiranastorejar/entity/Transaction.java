package com.example.kiranastorejar.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;

@Document
@Data
public class Transaction {
    @Id
    private String id;
    private String type;
    private double amount;
    private CurrencyType currency;
    private Date timestamp;

    public enum CurrencyType {
        INR,
        USD
    }

 
}