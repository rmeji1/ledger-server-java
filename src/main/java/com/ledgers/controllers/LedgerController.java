package com.ledgers.controllers;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
		
		ZoneId zoneId = ZoneId.of("America/New_York");
		LocalDateTime now = LocalDateTime.now(zoneId) ;
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
		Optional<Ledger> optionalLedger = ledgerRepo.findById(ledgerId);
		if (optionalLedger.isPresent()) {
			Ledger ledger = optionalLedger.get() ;
			ledger.setEndingBalance(endingBal);
			ZoneId zoneId = ZoneId.of("America/New_York");
			ledger.getLedgerDate().setEndDateTime(
					LocalDateTime.now(zoneId).format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT))
					);	
			ledger.setActive(false);
			ledger = ledgerRepo.save(ledger);
			return ledger ;
		}
		return null ;
	}
	
	@PutMapping(value="/ledger/{empType}/{ledgerId}")
    public boolean handleEmployeeFileUpload(@PathVariable("empType") String employeeType, @PathVariable("ledgerId") long ledgerId ,@RequestParam("file") MultipartFile file) {
		Optional<Ledger> optionalLedger = ledgerRepo.findById(ledgerId);
		if( optionalLedger.isPresent() ) {
			Ledger ledger = optionalLedger.get();
			System.out.println("Got ledger with id: " + ledger.getLedgerId());
			try {
				if ( employeeType.equals("emp")) {
					ledger.setEmployeeSignature(file.getBytes());
				}else if ( employeeType.equals("man")) {
					ledger.setManagerSignature(file.getBytes());
				} else {
					throw new IOException("Invalid Employlee type path variable.");
				}
				ledgerRepo.save(ledger);
				System.out.println("Saved the ledger.");
				return true;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false ;
    }
	
	@GetMapping(value="/ledger/active/{casinoId}")
	public List<Ledger> getActiveLedgerForCasino(@PathVariable("casinoId") Long casinoId) {
		return ledgerRepo.findByActiveAndTableDetailsCasino(true, casinoId);
	}
}
