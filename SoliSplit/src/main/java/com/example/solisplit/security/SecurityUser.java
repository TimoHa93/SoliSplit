package com.example.solisplit.security;

import java.util.Set;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.solisplit.domain.Authority;
import com.example.solisplit.domain.User;

public class SecurityUser extends User implements UserDetails {

	private static final long serialVersionUID = -6251926425481756484L;
	
//	public SecurityUser () {}
	
	public SecurityUser(User user) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodePassword = passwordEncoder.encode(user.getPassword());
		this.setAuthorities(user.getAuthorities());
		this.setGroups(user.getGroups());
		this.setId(user.getId());
		this.setPassword(encodePassword);
		this.setUsername(user.getUsername());
	}
	
	@Override
	public Set<Authority> getAuthorities() {
		return super.getAuthorities();
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
}
