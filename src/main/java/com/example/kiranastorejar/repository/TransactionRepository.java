package com.example.kiranastorejar.repository;

import com.example.kiranastorejar.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
    
}
