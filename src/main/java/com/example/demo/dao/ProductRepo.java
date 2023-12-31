package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Product;
import com.example.demo.models.UserDto;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

	void save(UserDto user);

}
