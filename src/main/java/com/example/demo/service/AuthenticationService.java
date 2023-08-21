package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.models.JwtAuthenticationResponse;
import com.example.demo.models.SignUpRequest;
import com.example.demo.models.SigninRequest;

//@Service
public interface AuthenticationService {
	JwtAuthenticationResponse signup(SignUpRequest request);

	JwtAuthenticationResponse signin(SigninRequest request);
}
