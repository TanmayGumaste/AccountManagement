package com.springjpa.car.accountmanagement.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springjpa.car.accountmanagement.exception.UserAlreadyExistException;
import com.springjpa.car.accountmanagement.model.User;
import com.springjpa.car.accountmanagement.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userservice;

	
	/*
	 * @GetMapping public List<User> getAllUsers() { return null;
	 * 
	 * }
	 */
	 

	@PostMapping("/create")
	public User createUser(@Valid @RequestBody User user) {
		User exist=userservice.getByEmail(user.getEmail());
		if(null!=user) {
			throw new  UserAlreadyExistException(exist.getEmail()+" Already Exist");
		
		}else 
			return userservice.createUser(user);
		

	}

	@GetMapping("/carname/{carName}")
	public List<User> getByCarName(@PathVariable String carName) {

		return userservice.getByCarName(carName);
	}
	
	@GetMapping("/modelno/{modelNo}")
	public List<User> getByModelnoContaining(@PathVariable String modelNo) {

		return userservice.getByModelNoContaining(modelNo);
	}
	@GetMapping("/getByNameAndEmail")
	public User getByNameAndEmail(@RequestParam String name,@RequestParam String email) {
		return userservice.getByNameAndEmail(name,email);
	}
	
	@GetMapping("/getByNameOrEmail")
	public User getByNameOrEmail(@RequestParam String name,@RequestParam String email) {
		return userservice.getByNameOrEmail(name,email);
	}
	
	@GetMapping("/getByNameStartsWith")
	public List<User> getByNameStartsWith(@RequestParam String character) {
		return userservice.getByNameStartsWith(character);
	}
	@GetMapping("/getByEmailIsLike")
	public List<User> getByEmailLike(@RequestParam String character) {
		return userservice.getByEmailLike(character);
	}
	
	
	@GetMapping
	public ResponseEntity<Map<String, Object>> getAllUsersByPagination(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "0") int size) {

		try {
			List<User> carCustomers = new ArrayList<User>();
			PageRequest pageable = PageRequest.of(page, size);
			Page<User> pageCars;
			pageCars = userservice.findAll(pageable);
			carCustomers = pageCars.getContent();
			Map<String, Object> response = new HashMap<>();
			response.put("users", carCustomers);
			response.put("currentpage", pageCars.getNumber());
			response.put("currentpage", pageCars.getTotalElements());
			response.put("currentpage", pageCars.getTotalPages());

			return new ResponseEntity<>(response, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/all/sort")
	public List<User> getAllUsersBySort() {
		return userservice.getAllUsers(Sort.by("name"));

	}
	
	@GetMapping("/all/sort/desc")
	public List<User> getAllUsersBySortDesc() {
		return userservice.getAllUsers(Sort.by("age").descending());

	}
	
	@GetMapping("/all/id/greaterthan/{userId}")
	public List<User> getAllUsersGreterThanAndOrderByCarName(@PathVariable Long userId) {
		return userservice.getAllUsersGreterThan(userId);

	}

	
	

}
