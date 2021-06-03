package com.springjpa.car.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.springjpa.car.accountmanagement.model.User;
import com.springjpa.car.accountmanagement.repository.UserRespository;

@Service
public class UserService {
	@Autowired
	UserRespository userRepository;

	public User createUser(User user) {
		return userRepository.save(user);

	}

	public User findByCarName() {
		return null;
	}

	public Page<User> findAll(PageRequest pageable) {
		return userRepository.findAll(pageable);
	}

	public List<User> getAllUsers(Sort by) {
		return userRepository.findAll(by);
	}

	public List<User> getAllUsersGreterThan(Long userId) {
		return userRepository.findByUserIdGreaterThan(userId);
	}

	public List<User> getByCarName(String carName) {
		return userRepository.findByCarName(carName);
	}

	public List<User> getByModelNoContaining(String modelNo) {
		// TODO Auto-generated method stub
		return userRepository.findByModelnoContaining(modelNo);
	}

	public User getByNameAndEmail(String name, String email) {
		return userRepository.findByNameAndEmail(name, email);
	}

	public User getByNameOrEmail(String name, String email) {
		return userRepository.findByNameOrEmail(name, email);
	}

	public List<User> getByNameStartsWith(String character) {
		// TODO Auto-generated method stub
		return userRepository.findByNameStartsWith(character);
	}

	public List<User> getByEmailLike(String character) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailIsLike(character);
	}

	public User getByEmail(String email) {
		return userRepository.findByEmail(email);
		// TODO Auto-generated method stub
		
	}

}
