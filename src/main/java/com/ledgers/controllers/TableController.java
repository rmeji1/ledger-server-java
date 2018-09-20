package com.ledgers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.domain.Ledger;
import com.ledgers.domain.Table;
import com.ledgers.repos.TableRepo;
import java.util.Optional;

@RestController
public class TableController {
	@Autowired 
	TableRepo repo ;
	
	@RequestMapping(value = "/tables/{casino_id}" , method = RequestMethod.GET)
	public List<Table> getTableFromCasino(@PathVariable("casino_id") Long casino_id) {
		return repo.findByCasinoId(casino_id); 
	}
	
	@RequestMapping(value = "/tables/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Long> updateTable(@PathVariable("id") Long id, @RequestBody Table tableDetails) {
		try {
			Optional<Table> optionalTable = repo.findById(id);
			Table table = optionalTable.orElseThrow(NullPointerException::new) ;
			if (table.getBalance() != tableDetails.getBalance()) {
				table.setBalance(tableDetails.getBalance());
			}
			if (table.getActiveGames() != tableDetails.getActiveGames()) {
				table.setActiveGames(tableDetails.getActiveGames());
			}
			if (table.getBalances() != tableDetails.getBalances()) {
				table.setBalances(tableDetails.getBalances());
			}
			repo.save(table) ;
			return new ResponseEntity<Long>(table.getId(), HttpStatus.ACCEPTED) ;
		}catch(NullPointerException e) {
			return new ResponseEntity<Long>(HttpStatus.NO_CONTENT) ;
		}catch(IllegalArgumentException ex) {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND) ; 
		}
	}
}
