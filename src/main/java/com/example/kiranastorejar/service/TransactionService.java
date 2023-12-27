package com.example.kiranastorejar.service;

import com.example.kiranastorejar.repository.*;
import com.example.kiranastorejar.entity.*;
import com.example.kiranastorejar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service Class for handling of transactions
 */
@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    /**
     * Function for recording transaction based on the request.
     * @param request the transaction request containing details of the transaction
     */
    public void recordTransaction(TransactionRequest request) {
        Transaction transaction = new Transaction();
        transaction.setId(UUID.randomUUID().toString());
        transaction.setType(request.getType());
        transaction.setAmount(request.getAmount());
        // System.out.println("Timestamp from request: ############" + request.getTimestamp());
        if(request.getCurrency()!=null){
            try {
                String currencyString = request.getCurrency();
                transaction.setCurrency(Transaction.CurrencyType.valueOf(currencyString));
            } catch(IllegalArgumentException e){
                throw new IllegalStateException("Invalid currency: " + request.getCurrency());
            }
        }
        transaction.setTimestamp(new Date());
        transactionRepository.save(transaction);
    }

    /**
     * Retrieves a list of all transactions
     * @return the list of all transactions
     */
    public List<Transaction> listTransactions() {
        return transactionRepository.findAll();
    }


    /**
     * Groups transactions in the database by date
     * @return map containing daily reports with transactions grouped by data.
     */
    public Map<String, List<Map<String, Object>>> groupTransactionsByDate() {
        List<Transaction> transactions = transactionRepository.findAll();

        Map<String, List<Transaction>> groupedTransactions = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> {
                    Date timestamp = transaction.getTimestamp();
                    // System.out.println("########" + timestamp);
                    if (timestamp != null) {
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        return dateFormat.format(timestamp);
                    } else {
                        return "Unknown Date";
                    }
                }));

        List<Map<String, Object>> dailyReports = groupedTransactions.entrySet().stream()
                .map(entry -> {
                    Map<String, Object> dailyReport = new HashMap<>();
                    dailyReport.put("date", entry.getKey());
                    dailyReport.put("transactions", entry.getValue());
                    return dailyReport;
                })
                .collect(Collectors.toList());


        Map<String, List<Map<String, Object>>> result = new HashMap<>();
        result.put("dailyReports", dailyReports);

        return result;
    }
}