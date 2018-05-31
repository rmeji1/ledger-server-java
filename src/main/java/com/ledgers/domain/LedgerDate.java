/**
 * 
 */
package com.ledgers.domain;

import java.time.LocalDateTime;

import javax.persistence.Embeddable
;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author robert
 *
 */

@Embeddable
public class LedgerDate {
	
//	@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	private String startDateTime ;
	private String endDateTime ;
	
	public LedgerDate() {
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(String endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public String toString() {
		return "LedgerDate [startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", getStartDateTime()="
				+ getStartDateTime() + ", getEndDateTime()=" + getEndDateTime() + "]";
	}
	
	
	
}
