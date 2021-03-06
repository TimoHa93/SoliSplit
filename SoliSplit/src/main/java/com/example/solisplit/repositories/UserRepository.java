package com.example.solisplit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.solisplit.domain.User;
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername (String username);
}
