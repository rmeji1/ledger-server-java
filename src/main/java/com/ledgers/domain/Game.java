package com.ledgers.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

/**
 * @author robert
 *
 */
@Entity
public class Game {
	@Getter @Setter @Id 	@GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty(access = Access.WRITE_ONLY)  
	private Long id ;
//	@JsonProperty(access = Access.WRITE_ONLY)  
	@Getter @Setter private Long casinoId ;
	@Getter @Setter private String description ;
	@Getter @Setter private String gega ;
	
	
	public Game() {
		
	}
	/**
	 * @param casinoId
	 * @param description
	 * @param gega
	 */
	public Game(Long casinoId, String description, String gega) {
		super();
		this.casinoId = casinoId;
		this.description = description;
		this.gega = gega;
	}
	@Override
	public String toString() {
		return "Game [id=" + id + ", casinoId=" + casinoId + ", description=" + description + ", gega=" + gega + "]";
	}
	
	
}
