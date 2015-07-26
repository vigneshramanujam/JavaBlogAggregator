package com.mycompany.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.entity.Blog;
import com.mycompany.entity.Item;
import com.mycompany.entity.Role;
import com.mycompany.entity.User;
import com.mycompany.repository.BlogRepository;
import com.mycompany.repository.ItemRepository;
import com.mycompany.repository.RoleRepository;
import com.mycompany.repository.UserRepository;
@Transactional
@Service
public class InitDBService {

	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BlogRepository blogRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@PostConstruct
	public void init(){
		
		Role roleUser=new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);
		
		Role roleAdmin=new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);
		
		
		User userAdmin=new User();
		userAdmin.setName("admin");
		userAdmin.setPassword("vicki");
		List<Role>roles=new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);
		
		Blog blogJavavids=new Blog();
		blogJavavids.setName("Java Blogs");
		blogJavavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
		blogJavavids.setUser(userAdmin);
		blogRepository.save(blogJavavids);
		
		Item item1=new Item();
		item1.setBlog(blogJavavids);
		item1.setTitle("first");
		item1.setLink("http://www.javavids.com/");
		item1.setPublishedDate(new Date());
		itemRepository.save(item1);
		Item item2=new Item();
		item2.setBlog(blogJavavids);
		item2.setTitle("second");
		item2.setLink("http://www.javavids.com/");
		item2.setPublishedDate(new Date());
		itemRepository.save(item2);
		
		
		
		
	}
	
}
