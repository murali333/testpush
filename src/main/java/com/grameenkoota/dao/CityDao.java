package com.grameenkoota.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grameenkoota.domain.City;
import com.grameenkoota.domain.User;

public interface CityDao extends  CrudRepository<City,Integer> {
	
	
	

}
