package com.ledgers.repos;

import org.springframework.data.repository.CrudRepository;

import com.ledgers.domain.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Long> {

}
