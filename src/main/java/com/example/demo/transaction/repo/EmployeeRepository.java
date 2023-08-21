package com.example.demo.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.transaction.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}