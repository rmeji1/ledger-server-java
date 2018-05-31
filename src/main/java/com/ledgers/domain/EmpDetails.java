package com.ledgers.domain;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author robert
 *
 */
@Embeddable
public class EmpDetails {
	
	private String name ;
	private String badgeNumber ;
	
	private EmpDetails() {}
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBadgeNumber() {
		return badgeNumber;
	}
	public void setBadgeNumber(String badgeNumber) {
		this.badgeNumber = badgeNumber;
	}
	
	@Override
	public String toString() {
		return "EmpDetails [name=" + name + ", badgeNumber=" + badgeNumber + "]";
	}
}
