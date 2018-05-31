package com.ledgers.domain;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class TableDetails {

	@Getter @Setter private Long casino ; 
	@Getter @Setter private String gega; 
	@Getter @Setter private Long tableId; 
	@Getter @Setter private int number;
	@Getter @Setter private String game;
	
	
	
//	@Column(name="gega") 
//	private String gega ;
//	
//	@Column(name="game_table") 
//	private String gameTable ;
//	
//	@Column(name="beginning_balance")
//	private BigDecimal beginningBalance ;
//	
//	@Column(name="ending_balance")
//	private BigDecimal endingBalance ;
//	
//	@Column(name="additions_total")
//	private BigDecimal additionsTotal ;
//	
//	@Column(name="subtraction_totals")
//	private BigDecimal subtractionTotals ;
//	
//	@JsonIgnore
//	@Column(name="transactions")
//	@OneToMany(fetch=FetchType.EAGER)
//	private List<Transaction> transactions ;
//	
//	public TableDetails() {}
//
//	public String getGega() {
//		return gega;
//	}
//
//	public void setGega(String gega) {
//		this.gega = gega;
//	}
//
//	public String getGameTable() {
//		return gameTable;
//	}
//
//	public void setGameTable(String gameTable) {
//		this.gameTable = gameTable;
//	}
//
//	public BigDecimal getBeginningBalance() {
//		return beginningBalance;
//	}
//
//	public void setBeginningBalance(BigDecimal beginningBalance) {
//		this.beginningBalance = beginningBalance;
//	}
//
//	public BigDecimal getEndingBalance() {
//		return endingBalance;
//	}
//
//	public void setEndingBalance(BigDecimal endingBalance) {
//		this.endingBalance = endingBalance;
//	}
//
//	public BigDecimal getAdditionsTotal() {
//		return additionsTotal;
//	}
//
//	public void setAdditionsTotal(BigDecimal additionsTotal) {
//		this.additionsTotal = additionsTotal;
//	}
//
//	public BigDecimal getSubtractionTotals() {
//		return subtractionTotals;
//	}
//
//	public void setSubtractionTotals(BigDecimal subtractionTotals) {
//		this.subtractionTotals = subtractionTotals;
//	}

//	public Set<Transaction> getTransactions() {
//		return transactions;
//	}
//
//	public void setTransactions(Set<Transaction> transactions) {
//		this.transactions = transactions;
//	}
//	
	

}
