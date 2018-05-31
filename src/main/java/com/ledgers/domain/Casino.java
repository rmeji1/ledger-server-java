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
//	@Column(name ="casino_Id")
	@JsonProperty("id")
    private Long id;
	@JsonProperty("name")
	private String name; 
	@JsonProperty("longitude")
	private float longitude;
	@JsonProperty("latitude")
	private float latitude;	
	@JsonProperty("podium")
	private BigDecimal podium ;
	
	@Getter @Setter private String casinoCode ;
	public Casino() {
		
	}
	public Casino(String name, float longitude, float latitude, BigDecimal podium, String casinoCode) {
		super();
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.podium = podium;
		this.casinoCode = casinoCode ;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	
	public BigDecimal getPodium() {
		return podium;
	}
	public void setPodium(BigDecimal podium) {
		this.podium = podium;
	}
}
