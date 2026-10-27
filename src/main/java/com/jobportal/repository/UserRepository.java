package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.User;

public interface UserRepository extends 
   JpaRepository<User, Integer>{

    User findByEmailAndPassword(String email , String password);
}