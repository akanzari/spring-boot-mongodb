package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> findUsersByName(String name) {
		return userRepository.findUsersByName(name);
	}

	@Override
	public List<User> findUsersByAgeBetween(int ageGT, int ageLT) {
		return userRepository.findUsersByAgeBetween(ageGT, ageLT);
	}

	@Override
	public List<User> findUsersByRegexpName(String regexp) {
		return userRepository.findUsersByRegexpName(regexp);
	}

	@Override
	public List<User> findByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public List<User> findByNameLikeOrderByAgeAsc(String name) {
		return userRepository.findByNameLikeOrderByAgeAsc(name);
	}

	@Override
	public List<User> findByAgeBetween(int ageGT, int ageLT) {
		return userRepository.findByAgeBetween(ageLT, ageLT);
	}

	@Override
	public List<User> findByNameStartingWith(String regexp) {
		return userRepository.findByNameStartingWith(regexp);
	}

	@Override
	public List<User> findByNameEndingWith(String regexp) {
		return userRepository.findByNameEndingWith(regexp);
	}

	@Override
	public List<User> findNameAndId() {
		return userRepository.findNameAndId();
	}

	@Override
	public List<User> findNameAndAgeExcludeId() {
		return userRepository.findNameAndAgeExcludeId();
	}

}