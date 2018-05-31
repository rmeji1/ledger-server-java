package com.ledgers.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.domain.Casino;
import com.ledgers.domain.Ledger;
import com.ledgers.domain.Table;
import com.ledgers.domain.Transaction;
import com.ledgers.repos.CasinoRepo;
import com.ledgers.repos.LedgerRepo;
import com.ledgers.repos.TableRepo;
import com.ledgers.repos.TransactionRepo;

@RestController
public class TransactionController {

	@Autowired 
	TransactionRepo repo ;
	
	@Autowired
	CasinoRepo casinoRepo ;
	
	@Autowired
	LedgerRepo ledgerRepo ;
	
	@Autowired
	TableRepo tableRepo ;
	
	@RequestMapping(value ="/transaction", method = RequestMethod.POST)
	@Transactional
	public Ledger saveTransaction(@RequestBody Transaction transaction) {
		Ledger ledger = ledgerRepo.findOne(transaction.getLedgerId()) ;
		//Table table = tableRepo.findOne(ledger.getTableDetails().getTableId()) ;

		// use ledger to get casino when we are ready to include casino podium
		
		if (ledger.getTransactions() == null) {
			ledger.setTransactions(new ArrayList<Transaction>());
		}
		switch(transaction.getType()) {
		case ADDITION :
			//table.setBalance(table.getBalance().add(transaction.getAmount()));
			BigDecimal totalAddition = ledger.getAdditionsTotal().add(transaction.getAmount());
			ledger.setAdditionsTotal(totalAddition);
			break;
		case SUBTRACTION:
			BigDecimal totalSubtraction = ledger.getSubtractionTotal().add(transaction.getAmount());
			ledger.setSubtractionTotal(totalSubtraction);
			break;
		}
		transaction = repo.save(transaction);
		ledger.getTransactions().add(transaction);
		ledger = ledgerRepo.save(ledger);
		return ledger ;
	}
}
