package com.example.kiranastorejar.controller;


import com.example.kiranastorejar.model.*;
import com.example.kiranastorejar.entity.*;
import com.example.kiranastorejar.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    /**
     * Record a new financial transaction
     * @param request
     */
    @PostMapping("/record")
    public void recordTransaction(@RequestBody TransactionRequest request) {
        transactionService.recordTransaction(request);
    }

    /**
     * Retrieve a list of all financial transactions
     * @return
     */
    @GetMapping("/list")
    public List<Transaction> listTransactions() {
        return transactionService.listTransactions();
    }

    /**
     * Retrieve a list of financial transactions by date
     * @return
     */
    @GetMapping("/grouped-list")
    public Map<String, List<Map<String, Object>>> groupTransactionsByDate() {
        return transactionService.groupTransactionsByDate();
    }
}