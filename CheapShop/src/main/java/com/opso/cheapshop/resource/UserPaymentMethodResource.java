package com.opso.cheapshop.resource;

import com.opso.cheapshop.domain.model.AuditModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPaymentMethodResource extends AuditModel {

	private Long id;
	private String cardNumber;
	private String ownerName;
	private String dueDate;
	private String cv;

}
