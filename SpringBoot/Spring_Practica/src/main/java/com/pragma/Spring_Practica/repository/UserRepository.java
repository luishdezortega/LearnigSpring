package com.pragma.Spring_Practica.repository;

import org.springframework.data.repository.CrudRepository;

import com.pragma.Spring_Practica.modelo.User;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String name);
}
