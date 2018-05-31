/**
 * 
 */
package com.ledgers.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

/**
 * @author robert
 *
 */
@Entity
public class Table {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = Access.READ_ONLY)
	@Getter @Setter private Long id;
	
	@JsonProperty(access = Access.WRITE_ONLY)  
	@Getter @Setter private Long casinoId;
	@Getter @Setter private int number ; // Table number
	
	@OneToMany
	@JoinColumn(name="PART_ID")
	@Getter @Setter private List<Game> games;
	
	@Getter @Setter private BigDecimal balance;
	
	@org.hibernate.annotations.Type(
	        type = "org.hibernate.type.SerializableToBlobType"
//	        parameters = { @Parameter( name = "classname", value = "java.util.HashMap" ) }
	)
	@Getter @Setter private HashMap<String,BigDecimal> balances ;
	
//	@Getter @Setter private List<Balance> newBalances ;
	
	@Getter @Setter private boolean open ; // true if activeGames less than games.size() 
	@Getter @Setter private int activeGames ;
	
	public Table() {
		
	}
	
	public Table(Long casinoId, int number, ArrayList<Game> games, BigDecimal balance, boolean open, int activeGames, HashMap<String,BigDecimal> balances) {
		super();
		this.casinoId = casinoId;
		this.number = number;
		this.games = games;
		this.balance = balance;
		this.open = open;
		this.activeGames = activeGames;
		this.balances = balances; 
	}

	@Override
	public String toString() {
		return "Table \n[\n\tid = " + id + ", \n\tcasinoId = " + casinoId + ", \n\tnumber = " + number
				+ ", \n\tgames = " + games + ", \n\tbalance = " + balance + ", \n\tbalances = " + balances
				+ ", \n\topen = " + open + ", \n\tactiveGames = " + activeGames + "\n]";
	}
	
}
