package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ProductRepo;
import com.example.demo.models.JwtAuthenticationResponse;
import com.example.demo.models.Product;
import com.example.demo.models.SignUpRequest;
import com.example.demo.models.SigninRequest;
import com.example.demo.models.UserDto;
import com.example.demo.service.AuthenticationService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

	@Autowired
	private ProductRepo productdao;
	@Autowired
	private AuthenticationService authenticationService;

	@PostMapping("/signup")
	public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody SignUpRequest request) {
		return ResponseEntity.ok(authenticationService.signup(request));
	}

	@PostMapping("/signin")
	public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody SigninRequest request) {
		return ResponseEntity.ok(authenticationService.signin(request));
	}

//    @PostMapping("/createNewUser")
//	ResponseEntity<Object> saveUser(@RequestParam String name, @RequestParam String age, HttpServletResponse response,
//			@RequestBody Product user) {
//		ResponseEntity<Product> userDto = create(user);
//		if (name == null || age == null || name.length() > 32 || age.length() < 16) {
//			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
//		} else {
//			productdao.save(userDto);
//		}
//		return new ResponseEntity<>(userDto, HttpStatus.CREATED);
//
//	}
////	@PostMapping("/save")
////	ResponseEntity<Object>  saveUser(@RequestParam String name ,  @RequestParam String age ,HttpServletResponse response) {
////		if(name==null || age ==null || name.length()>32 || age.length() <16) {
////		    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
////		}else {
////		productsService.saveProduct();
////		}
////		return ;
////
////	}

//	@PostMapping
//	public ResponseEntity<Product> create(@RequestBody UserDto user) {
//		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, value = "createNewUser")
	ResponseEntity<Object> saveUser(@RequestBody UserDto user) {

//		ResponseEntity<Product> userDto = create(user);
		if (user.getName().isEmpty() ||

				user.getName() == null || user.getAge() == null

				|| user.getName().length() > 32 || user.getAge() < 16) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			productdao.save(user);
		}
		return new ResponseEntity<>(user, HttpStatus.CREATED);

	}
}
