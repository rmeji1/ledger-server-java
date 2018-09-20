/**
 * 
 */
package com.ledgers.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * @author robert
 *
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Casino {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonProperty("casinoId") @Getter @Setter private Long id;
	@JsonProperty("casinoCode")	@Getter @Setter private String casinoCode ;
	@JsonProperty("casinoName") @Getter @Setter private String name; 
	@JsonProperty("longitude") @Getter @Setter private float longitude;
	@JsonProperty("latitude") @Getter @Setter private float latitude;	
	@JsonProperty("casinoImageURL") @Getter @Setter private String casinoImageURL ;
//	@JsonIgnore
	@JsonProperty("podium") @Getter @Setter private BigDecimal podium ;

	public Casino() {
		
	}

	public Casino(String casinoCode, String name, float longitude, float latitude, String casinoImageURL,
			BigDecimal podium) {
		super();
		this.casinoCode = casinoCode;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.casinoImageURL = casinoImageURL;
		this.podium = podium;
	}
}
