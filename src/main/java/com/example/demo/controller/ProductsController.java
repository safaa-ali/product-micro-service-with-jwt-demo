package com.example.demo.controller;

//import java.awt.PageAttributes.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepo;
import com.example.demo.exception.ProductNotfoundException;
import com.example.demo.models.Product;
import com.example.demo.models.ProductType;
import com.example.demo.service.ProductsService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletResponse;


@RestController()
public class ProductsController {

	@Autowired
	private ProductRepo productdao;
	@Autowired
	private ProductsService productsService;

	
	@PostMapping("/save")
	String save( @RequestBody Product product) {
		productsService.saveProduct(product);
		return "product saved successfully !";
	}

	@GetMapping("/products")
	List<Product> getAllProducts() {
		return productsService.getAllProducts();
	}

	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateEmployee(@PathVariable long id, @RequestBody Product employeeDetails) {

		Product updateEmployee = productdao.findById(id)
				.orElseThrow(() -> new ProductNotfoundException("Product not exist with id: " + id));

		updateEmployee.setProductName(employeeDetails.getProductName());

		productdao.save(updateEmployee);

		return ResponseEntity.ok(updateEmployee);
	}

	@DeleteMapping("/delete/{id}")
	String deleteProduct(@PathVariable Long id) {
		productdao.deleteById(id);

		productdao.findById(id).orElseThrow(() -> new ProductNotfoundException("Product not exist with id: " + id));

		return "product deleted successfully !";

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
