package com.cmrwebstudio.beerv3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.cmrwebstudio.beerv3.entity.Distributor;

public interface DistributorControllerInt {

	//list all distributors
		@GetMapping("/all_distributors")
		@ResponseStatus(code = HttpStatus.OK)
		List<Distributor> fetchDistributor();
		
		//add a distributor
		@PostMapping("/add_distributor")
		@ResponseStatus(code = HttpStatus.CREATED)
		Optional<Distributor> addNewDistributor(
				@RequestParam(required = true) String dist_name,
				@RequestParam(required = true) String website);
		
		//update a distributor
		@PostMapping("/update_distributor")
		@ResponseStatus(code = HttpStatus.CREATED)
		Optional<Distributor> updateDistributor(
				@RequestParam(required = true) int dist_pk,
				@RequestParam(required = true) String dist_name,
				@RequestParam(required = true) String website);
		
		//delete a distributor
		@DeleteMapping("/delete_distributor")
		@ResponseStatus(code= HttpStatus.CREATED)
		Optional<Distributor> deleteDistributor(
				@RequestParam(required = true) int dist_pk);
}
