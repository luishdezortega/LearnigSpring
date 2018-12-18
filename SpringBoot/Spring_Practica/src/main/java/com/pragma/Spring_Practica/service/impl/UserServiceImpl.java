package com.pragma.Spring_Practica.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.pragma.Spring_Practica.modelo.User;
import com.pragma.Spring_Practica.repository.UserRepository;
import com.pragma.Spring_Practica.service.UserService;



@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	 	
	@Autowired
	private UserRepository userRepository;
	
	private static List<User> users;
	
	@Override
	public User findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	}

	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.save(user);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<User>) userRepository.findAll();
	}

	@Override
	public void deleteAllUsers() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return findByName(user.getUsername())!=null;
	}
	


}
