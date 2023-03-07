package com.cmrwebstudio.beerv3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import com.cmrwebstudio.beerv3.entity.Distributor;

/** The DistributorController interfaces with the DAO (Data Access Object) layers for all Distributor methods.
 *  
 *  The RequestMapping annotation is used to inform Spring the following data will be mapped
 *  to the URI listed
 *  @author cmrapp *
 */
@RequestMapping("/distributors")

public class DistributorController implements DistributorControllerInt{

	//list all distributors
		@Override
		public List<Distributor> fetchDistributor() {
			return null;
		}
		
		//add a distributor
		@Override
		public Optional<Distributor> addNewDistributor(String dist_name, String website) {
			return null;
		}
		
		//update a distributor
		@Override
		public Optional<Distributor> updateDistributor(int dist_pk, String dist_name, String website) {
			return null;
		}
		
		//delete a distributor
		@Override
		public Optional<Distributor> deleteDistributor(int dist_pk) {
			return null;
		}
	
}
