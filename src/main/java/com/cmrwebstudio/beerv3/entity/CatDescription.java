package com.cmrwebstudio.beerv3.entity;

import com.cmrwebstudio.beerv3.entity.CatDescription;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CatDescription {
	private int catId;
	private String catName;
	private String catDesc;
}

