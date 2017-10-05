package com.grameenkoota.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grameenkoota.dao.CityDao;
import com.grameenkoota.domain.City;
import com.grameenkoota.domain.User;
import com.grameenkoota.service.UserService;

@RestController
@RequestMapping("/user")
public class UserRest {
	@Autowired
	private UserService userService;
	
	@Autowired
	private CityDao cityDao;
	
	
	private static String UPLOADED_FOLDER = "E://AngularNodeTuorial//FileUpload//";
	//private static String UPLOADED_FOLDER = "localhost:8081//datarest//";
	
	
	@RequestMapping(value="/",method = RequestMethod.GET)
	    public String homepage(){
	        return "index";
	    }

	
	
	@CrossOrigin
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity createUser(@RequestBody User user) {
		User user1 = null;
		if (user != null) {
			user1 = userService
					.findUser(user.getUserName(), user.getPassword());
			System.out.println("use object::" + user1);
		}
		if (user1 != null) {
			return new ResponseEntity<User>(user1, HttpStatus.OK);
		}

		return new ResponseEntity<String>("login failed", HttpStatus.NOT_FOUND);
	}

	@CrossOrigin
	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(Integer id) {
		System.out.println("Id::" + id);
		// id =4;
		userService.deleteUser(id);
		return new ResponseEntity<String>("user successfully deleted",
				HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity delete(@PathVariable Integer id) {
		System.out.println("Id::" + id);
		userService.deleteUser(id);
		return new ResponseEntity<String>("user successfully deleted",
				HttpStatus.OK);
	}

	@CrossOrigin
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile uploadfile) {

		if (uploadfile.isEmpty()) {
			return new ResponseEntity("please select a file!", HttpStatus.OK);
		}

		try {

			saveUploadedFiles(Arrays.asList(uploadfile));

		} catch (IOException e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity("Successfully uploaded - "
				+ uploadfile.getOriginalFilename(), new HttpHeaders(),
				HttpStatus.OK);

	}

	private void saveUploadedFiles(List<MultipartFile> files)
			throws IOException {

		for (MultipartFile file : files) {

			if (file.isEmpty()) {
				continue; // next pls
			}

			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);

		}

	}
	
	
	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET, value = "/city")
	public ResponseEntity<List<City>> getCitiyList() {
		Iterable<City> cityList = cityDao.findAll();
		
		System.out.println("cityList::"+cityList);
		return new ResponseEntity(cityList,
				HttpStatus.OK);
	}

}
