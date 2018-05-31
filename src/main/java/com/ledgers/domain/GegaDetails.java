/**
 * 
 */
package com.ledgers.domain;

import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * @author robert
 *
 */
@Embeddable
public class GegaDetails {
	@Getter @Setter @Id private Long id ;
	@Getter @Setter private String description ;
}
