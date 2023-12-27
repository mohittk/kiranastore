package com.example.kiranastorejar.model;

import java.util.Date;
import lombok.Data;

@Data
public class TransactionRequest {
    private String type;
    private double amount;
    private String currency;
    private Date timestamp;
}