package com.example.kiranastorejar.model;

import java.util.Date;
import lombok.Data;

/**
 * It represents a request for the financial transaction
 * 
 * - type: Type of the transaction (credit, debit).
 * - amount: The amount involved in the transaction.
 * - currency: The currency type used for the transaction.
 * - timestamp: the exact date and time of the transaction.
 */
@Data
public class TransactionRequest {
    private String type;
    private double amount;
    private String currency;
    private Date timestamp;
}