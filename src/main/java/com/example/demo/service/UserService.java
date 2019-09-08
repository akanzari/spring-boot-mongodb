package com.example.demo.service;

import java.util.List;
import com.example.demo.model.User;

public interface UserService {
	
	User save(User user);

	List<User> findUsersByName(String name);

	List<User> findUsersByAgeBetween(int ageGT, int ageLT);

	List<User> findUsersByRegexpName(String regexp);

	List<User> findByName(String name);

	List<User> findByNameLikeOrderByAgeAsc(String name);

	List<User> findByAgeBetween(int ageGT, int ageLT);

	List<User> findByNameStartingWith(String regexp);

	List<User> findByNameEndingWith(String regexp);

	List<User> findNameAndId();

	List<User> findNameAndAgeExcludeId();

}