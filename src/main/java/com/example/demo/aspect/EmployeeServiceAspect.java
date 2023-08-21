package com.example.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeServiceAspect {
	@Before(value = "execution(* com.example.demo.service.ProductsService.*(..)) and args(productId, productName, quntity,type)")
	public void beforeAdvice(JoinPoint joinPoint, String productId, String productName, String quntity,String type) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println(
				"Creating Employee with first name - " + productName + ", second name - " + quntity + " and id - " + productId);
	}
}