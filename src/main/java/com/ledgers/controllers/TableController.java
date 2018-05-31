package com.ledgers.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ledgers.domain.Table;
import com.ledgers.repos.TableRepo;

@RestController
public class TableController {
	@Autowired 
	TableRepo repo ;
	
	@RequestMapping(value = "/tables/{casino_id}" , method = RequestMethod.GET)
	public List<Table> getTableFromCasino(@PathVariable("casino_id") Long casino_id) {
		return repo.findByCasinoId(casino_id); 
	}
	
	@RequestMapping(value = "/tables/{id}", method = RequestMethod.PUT)
	public Long updateTable(@PathVariable("id") Long id, @RequestBody Table tableDetails) {
		Table table = repo.findOne(id);
		if (table.getBalance() != tableDetails.getBalance()) {
			table.setBalance(tableDetails.getBalance());
		}
		if (table.getActiveGames() != tableDetails.getActiveGames()) {
			table.setActiveGames(tableDetails.getActiveGames());
		}
		if (table.getBalances() != tableDetails.getBalances()) {
			table.setBalances(tableDetails.getBalances());
		}
//		table.setActiveGames(tableDetails.getActiveGames());
		repo.save(table) ;
		System.out.println("Table id: " + table.getId());
		System.out.println("Saved updated table now getting ids");

		return table.getId();
	}
}
