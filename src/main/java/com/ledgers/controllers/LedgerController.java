package com.ledgers.controllers;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.domain.Ledger;
import com.ledgers.domain.LedgerDate;
import com.ledgers.repos.LedgerRepo;

@RestController(value="/ledger")
public class LedgerController {

	@Autowired
	LedgerRepo ledgerRepo;
//	Ledger tableDetails=com.ledgers.domain.TableDetails@2b025ff0, ledgerDate=null, active=true]

	@RequestMapping(method=RequestMethod.POST)
	public Long createLedger(@RequestBody Ledger ledger) {
		System.out.println(ledger.toString());
		LedgerDate startTime = new LedgerDate();
		startTime.setStartDateTime(LocalDateTime.now().toString());
		ledger.setLedgerDate(startTime);
		
		Ledger ledgerSaved = ledgerRepo.save(ledger);
		ledgerSaved.setLedgerId(String.format("%s%05d", 
				ledger.getCasinoDetails().getCasinoCode(),
				ledger.getId()));
				
		ledgerSaved = ledgerRepo.save(ledgerSaved);
//		System.out.println("Start time "+startTime);
//		System.out.printf("%03d\n", ledgerSaved.getId());
		return ledgerSaved.getId();
	}

}
