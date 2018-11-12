package com.example.solisplit.Service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.solisplit.domain.Authority;
import com.example.solisplit.domain.User;
import com.example.solisplit.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User saveUser(User user) {
		
		Authority authority = new Authority();
		authority.setAuthority("ROLE_USER");
		authority.setUser(user);
		
		Set<Authority> authorities = new HashSet<>();
		authorities.add(authority);
		
		user.setAuthorities(authorities);
		user = userRepo.save(user);
		
		return user;
	}
}
