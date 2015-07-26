package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.entity.User;

public interface UserRepository extends JpaRepository<User,Integer>{

}
