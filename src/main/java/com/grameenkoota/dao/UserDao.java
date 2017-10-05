package com.grameenkoota.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grameenkoota.domain.User;

@Repository
public interface  UserDao extends CrudRepository<User,Integer> {
	
	//public User findByUserNameandPassword(String UserName,String password);
	public User findByUserName(String UserName);

}
