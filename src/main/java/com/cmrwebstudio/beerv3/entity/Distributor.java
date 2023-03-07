package com.cmrwebstudio.beerv3.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.cmrwebstudio.beerv3.entity.Distributor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Distributor {

	@NotNull
	int dist_pk;
	
	@NotNull
	@Length(max = 25)
	String dist_name;
	
	@Length(max = 40)
	String website;

}
