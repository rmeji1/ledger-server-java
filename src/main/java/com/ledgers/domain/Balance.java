package com.ledgers.domain;

import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

public class Balance {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Getter @Setter private Long id; 
	@Getter @Setter String forGame ;
	@Getter @Setter BigDecimal balance ;
}
