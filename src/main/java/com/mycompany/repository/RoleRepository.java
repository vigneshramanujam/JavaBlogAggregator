package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
