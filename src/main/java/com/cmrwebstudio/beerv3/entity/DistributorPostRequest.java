package com.cmrwebstudio.beerv3.entity;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.cmrwebstudio.beerv3.entity.DistributorPostRequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributorPostRequest {

		
	@NotNull
	String dist_name;
	
	@Length(max = 50)
	String website;

}
