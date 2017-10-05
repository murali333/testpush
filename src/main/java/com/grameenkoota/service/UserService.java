package com.grameenkoota.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.grameenkoota.dao.UserDao;
import com.grameenkoota.domain.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public User findUser(String name,String password){
		
		User user = userDao.findByUserName(name);
		return user;
		
	}
public void deleteUser(int id){
		
		userDao.delete(id);
		
	}

}
