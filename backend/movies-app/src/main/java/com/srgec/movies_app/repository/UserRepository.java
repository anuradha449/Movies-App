package com.srgec.movies_app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srgec.movies_app.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //find the users by email
    Optional<User> findByEmail(String username);
    //search users by email containing a query string
    List<User> findByNameContaining(String query);
    //search users by email starting with a query string
    List<User> findByNameStartingWith(String query);
    //search users by email ending with a query string
    List<User> findByNameEndingWith(String query); 
    //search users by email containing a query string ignoring case
    List<User> findByNameContainingIgnoreCase(String query); 
} 