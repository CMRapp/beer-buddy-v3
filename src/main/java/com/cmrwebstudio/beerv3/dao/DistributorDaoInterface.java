package com.cmrwebstudio.beerv3.dao;

import java.util.List;
import java.util.Optional;

import com.cmrwebstudio.beerv3.entity.Distributor;

public interface DistributorDaoInterface {

	List<Distributor> fetchDistributors();

	Optional<Distributor> addNewDistributor(String distName, String website);
	
	Optional<Distributor> updateDistributor(int dist_pk, String distName, String website);

	Optional<Distributor> deleteDistributor(int dist_pk);

}
