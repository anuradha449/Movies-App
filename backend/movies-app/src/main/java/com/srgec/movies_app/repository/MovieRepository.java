package com.srgec.movies_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.srgec.movies_app.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer>{
    
}
