package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.ProductRepo;
import com.example.demo.models.Product;

import jakarta.annotation.PostConstruct;

@Service
@Transactional
public class ProductsService {
	@Autowired
	private ProductRepo productRepo;
	public Product saveProduct(@RequestBody Product product) {

		return productRepo.save(product);

	}

	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

}
