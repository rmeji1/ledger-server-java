package com.ledgers.repos;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.ledgers.domain.Table;

public interface TableRepo extends CrudRepository<Table, Long> {
	public List<Table> findByCasinoId(Long id);
	
	//@Modifying
	//@Transactional
	//@Query("update Table t set t.podium = t.podium + ?1 where t.id = ?2")
	//public int updatePodium(BigDecimal podium, Long id);
}

// Make an addition or subtraction
// User press 100 dollars then addition
// Popup ask manager for id
// Once id is done 
// Make call to server POST /transaction/podium
	// { 
	// 		transaction_type : addition or subtraction
	// 		amount : bigdecimal dollars 
	//       table_id: table_id  Long
	// 		casino_id: casino_id Long
	//      manager: id
	// }
// find manager first if can't send error response 
//in the transaction service  is should be transactional 
// update the casino podium balance
	// UPDATE Casino SET podium= podium + (:1 * -1) WHERE casino = :2
// Update the table balance 
	// UPDATE Table SET podium=podium+:1 WHERE tableId = :2
//	Save transaction
	//transRepo.save()