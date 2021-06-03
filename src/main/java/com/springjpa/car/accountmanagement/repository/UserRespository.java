package com.springjpa.car.accountmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springjpa.car.accountmanagement.model.User;

public interface UserRespository extends JpaRepository<User, Long> {
	
	List<User>findByUserIdGreaterThan(Long userId);
    List<User> findByCarName(String carName);
    List<User>findByModelnoContaining(String modelno);
	List<User> findByNameStartsWith(String name);
	List<User> findByEmailIsLike (String email);
	User findByNameAndEmail(String name, String email);
	User findByNameOrEmail(String name, String email);
	User findByEmail(String email);

}
