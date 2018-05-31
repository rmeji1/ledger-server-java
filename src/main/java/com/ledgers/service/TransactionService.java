package com.ledgers.service;

import org.springframework.transaction.annotation.Transactional;

import com.ledgers.domain.Transaction;


public class TransactionService {
	
	@Transactional
	public Transaction commitTransaction(Transaction action) {
		
		return null ;
	}
}
