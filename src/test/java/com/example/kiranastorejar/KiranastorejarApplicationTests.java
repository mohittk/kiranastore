package com.example.kiranastorejar;


import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.kiranastorejar.service.TransactionService;
import com.example.kiranastorejar.entity.Transaction;
import com.example.kiranastorejar.model.TransactionRequest;
import com.example.kiranastorejar.repository.TransactionRepository;


@SpringBootTest
class KiranastorejarApplicationTests {

	@Mock
	private TransactionRepository transactionRepository;

	@InjectMocks
	private TransactionService transactionService;

	@Test
	public void testForRecordTransaction() {
		TransactionRequest request = new TransactionRequest();
		transactionService.recordTransaction(request);
		verify(transactionRepository).save(Mockito.any(Transaction.class));
	}


}
