package com.ledgers.repos;

import org.springframework.data.repository.CrudRepository;

import com.ledgers.domain.Ledger;

public interface LedgerRepo extends CrudRepository<Ledger, Long> {
	public Ledger findByLedgerId(String ledgerId);
}
