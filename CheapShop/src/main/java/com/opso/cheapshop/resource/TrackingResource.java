
package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrackingResource extends AuditModel {

	private long id;

	private String date;

	private String description;

	private String place;

}