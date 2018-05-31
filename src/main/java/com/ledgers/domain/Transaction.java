package com.ledgers.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

// { 
// 		transaction_type : addition or subtraction
// 		amount : bigdecimal dollars 
//       table_id: table_id  Long
// 		casino_id: casino_id Long
//      manager: id
// }

@Entity
public class Transaction{
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Long id; 
	@Getter @Setter private Long ledgerId ;
	@JsonProperty(access = Access.READ_WRITE)
	@Getter @Setter private Transaction_Type type ;
	@Getter @Setter private BigDecimal amount ;
	@Getter @Setter private String managerInitials ;
	@Getter @Setter private String employeeInitials ;
	
	

//	private Long table_id ;
	//private Long casino_id ;
//	private Long manager_id ;
	//	@ManyToOne(fetch=FetchType.EAGER)
////	@Fetch(FetchMode.JOIN)
//	@JoinColumn(referencedColumnName="id")
//	@JsonProperty("casino")
//	private Casino casino ;
	
//	@JsonIgnore
//	private Long ledger_id;
//	@JsonIgnore
//	private Long employee_id ;

//	public Long getTable_id() {
//		return table_id;
//	}
//
//
//	public void setTable_id(Long table_id) {
//		this.table_id = table_id;
//	}


//	public Long getCasino_id() {
//		return casino_id;
//	}
//
//
//	public void setCasino_id(Long casino_id) {
//		this.casino_id = casino_id;
//	}


//	public Long getManager_id() {
//		return manager_id;
//	}
//
//
//	public void setManager_id(Long manager_id) {
//		this.manager_id = manager_id;
//	}

//	public Long getLedger_id() {
//		return ledger_id;
//	}
//
//
//	public void setLedger_id(Long ledger_id) {
//		this.ledger_id = ledger_id;
//	}
//
//
//	public Long getEmployee_id() {
//		return employee_id;
//	}
//
//
//	public void setEmployee_id(Long employee_id) {
//		this.employee_id = employee_id;
//	}
//
//
//	public Casino getCasino() {
//		return casino;
//	}
//
//
//	public void setCasino(Casino casino) {
//		this.casino = casino;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Transaction [id=" + id + ", type=" + type + ", amount=" + amount + ", table_id=" + table_id
//				+ ", casino_id=" + ", manager_id=" + manager_id + ", manager_initials=" + manager_initials
//				+ ", emp_initials=" + emp_initials + ", casino=" + casino.getName() + ", ledger_id=" + ledger_id
//				+ ", employee_id=" + employee_id + "]" ;
//	}
	
}
