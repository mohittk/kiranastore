package com.example.kiranastorejar.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

import java.util.Date;

/**
 * It represents a financial transaction
 * 
 * Fields:
 * - id: Unique identifier for the transaction
 * - type: Type of transaction (credit,debit)
 * - amount: The amount involved in the transaction
 * - currency: The currency type used for the transaction
 * - timestamp: the exact date and time of the transaction
 */
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