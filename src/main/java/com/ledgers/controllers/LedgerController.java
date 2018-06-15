package com.ledgers.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		LocalDateTime now = LocalDateTime.now() ;
		String timeNowString = now.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
		startTime.setStartDateTime(timeNowString);
		
		ledger.setLedgerDate(startTime);
		ledger.setActive(true) ;
		Ledger ledgerSaved = ledgerRepo.save(ledger);
		ledgerSaved.setLedgerId(String.format("%s%05d", 
				ledger.getCasinoDetails().getCasinoCode(),
				ledger.getId()));
				
		ledgerSaved = ledgerRepo.save(ledgerSaved);
		
		return ledgerSaved.getId();
	}
	
	@PutMapping("/ledger/{ledgerId}")
	public Ledger pushLedger(@PathVariable("ledgerId") Long ledgerId,
			@RequestParam("endingBalance") String endingBalance) {
		BigDecimal endingBal = new BigDecimal(endingBalance);
		Ledger ledger = ledgerRepo.findOne(ledgerId);
		ledger.setEndingBalance(endingBal);
		ledger.getLedgerDate().setEndDateTime(
				LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
				);	
		ledger.setActive(false);
		ledger = ledgerRepo.save(ledger);
		return ledger ;
	}
	
	@PutMapping(value="/ledger/emp/{ledgerId}")
    public int handleEmployeeFileUpload(@PathVariable("ledgerId") long ledgerId ,@RequestParam("file") MultipartFile file) {
		Ledger ledger = ledgerRepo.findOne(ledgerId);
		System.out.println("Got ledger with id: " + ledger.getLedgerId());
		try {
			ledger.setEmployeeSignature(file.getBytes());
			ledgerRepo.save(ledger);
			System.out.println("Saved the ledger.");
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0 ;
		}
      }


	@PutMapping(value="/ledger/man/{ledgerId}")
    public int handleManagerFileUpload(@PathVariable("ledgerId") long ledgerId ,@RequestParam("file") MultipartFile file) {
		Ledger ledger = ledgerRepo.findOne(ledgerId);
		System.out.println("Got ledger with id: " + ledger.getLedgerId());
		try {
			ledger.setManagerSignature(file.getBytes());
			ledgerRepo.save(ledger);
			System.out.println("Saved the ledger.");
			return 1;
		} catch (IOException e) {
			e.printStackTrace();
			return 0 ;
		}
      }
}
