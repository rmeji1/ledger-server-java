package com.ledgers.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ledgers.domain.Ledger;

public interface LedgerRepo extends CrudRepository<Ledger, Long> {
	public Ledger findByLedgerId(String ledgerId);
	public List<Ledger> findByActiveAndTableDetailsCasino(boolean active, Long casino);
}
