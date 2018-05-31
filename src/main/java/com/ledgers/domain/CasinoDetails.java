package com.ledgers.domain;

import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable 
public class CasinoDetails {
	@Getter @Setter private String casinoCode ;
	@Getter @Setter private String casinoName ;

	@Override
	public String toString() {
		return "CasinoDetails [casinoName=" + casinoName + "]";
	}
	
}
