package com.ledgers.domain;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Ledger {
	
	
	@JsonProperty(access = Access.READ_WRITE)  
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	@Getter @Setter private Long id;
	
	@Getter @Setter private CasinoDetails casinoDetails ;
	@Getter @Setter private EmpDetails empDetails ;
	@Getter @Setter private TableDetails tableDetails ;
	@Getter @Setter private LedgerDate ledgerDate ; 
	@Getter @Setter private boolean active ;
	@Column(unique=true)
	@Getter @Setter private String ledgerId ;
	@Getter @Setter private BigDecimal beginningBalance;
	@Getter @Setter private BigDecimal endingBalance;
	@Getter @Setter private BigDecimal additionsTotal;
	@Getter @Setter private BigDecimal subtractionTotal;
	@OneToMany
	@Getter @Setter private List<Transaction> transactions; 
	@Getter @Setter @Lob private byte[] employeeSignature ;
	@Getter @Setter @Lob private byte[] managerSignature ;

 	public Ledger() {}	
	
}
