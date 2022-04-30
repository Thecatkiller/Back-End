package com.opso.cheapshop.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveTrackingResource {
	@NotNull
	@NotBlank
	@Size(max = 50)
	private String date;

	@NotNull
	@NotBlank
	@Size(max = 250)
	private String description;

	@NotNull
	@NotBlank
	private String place;

}