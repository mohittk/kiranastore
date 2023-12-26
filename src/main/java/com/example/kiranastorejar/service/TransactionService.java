package com.example.kiranastorejar.service;

import com.example.kiranastorejar.repository.*;
import com.example.kiranastorejar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void recordTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setType(request.getType());
        transaction.setAmount(request.getAmount());
        if(request.getCurrency()!=null){
            try {
                String currencyString = request.getCurrency();
                transaction.setCurrency(Transaction.CurrencyType.valueOf(currencyString));
            } catch(IllegalArgumentException e){
                throw new IllegalStateException("Invalid currency: " + request.getCurrency());
            }
        }
        transaction.setTimeStamp(request.getTimestamp());
        transactionRepository.save(transaction);
    }

    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }
}