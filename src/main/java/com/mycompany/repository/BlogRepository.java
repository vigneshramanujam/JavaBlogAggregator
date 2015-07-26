package com.mycompany.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mycompany.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

}
