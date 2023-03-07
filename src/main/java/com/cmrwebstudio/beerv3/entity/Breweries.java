package com.cmrwebstudio.beerv3.entity;

import java.util.Comparator;

import javax.validation.constraints.NotNull;

import com.cmrwebstudio.beerv3.entity.Breweries;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Breweries {
	
	@NotNull
	private int breweryId;
	
	private String breweryName;
	private String country;
	private String website;
	
	public int compareTo(Breweries that) {
		return Comparator
				.comparing(Breweries::getBreweryId)
				.compare(this,  that);
	}

}
