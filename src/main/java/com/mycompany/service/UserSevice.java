package com.mycompany.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.mycompany.entity.Blog;
import com.mycompany.entity.Item;
import com.mycompany.entity.User;
import com.mycompany.repository.BlogRepository;
import com.mycompany.repository.ItemRepository;
import com.mycompany.repository.UserRepository;

@Service
public class UserSevice {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List<User> findAll(){
		return userRepository.findAll();
	}

	public User findOne(Integer id) {
		return userRepository.findOne(id);
	}

	@Transactional
	public User findOneWithBlogs(Integer id) {
		// TODO Auto-generated method stub
		User user=findOne(id);
		List<Blog> blogs=blogRepository.findByUser(user);
		
		for(Blog blog:blogs){
			List<Item> items=itemRepository.findByBlog(blog,new PageRequest(0, 10, Direction.DESC, "publishedDate"));
			blog.setItems(items);
		}
		user.setBlogs(blogs);
		return user;
	}
	
}

