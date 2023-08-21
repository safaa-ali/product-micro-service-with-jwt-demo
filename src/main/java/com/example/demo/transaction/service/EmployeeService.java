package com.example.demo.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.transaction.entity.Address;
import com.example.demo.transaction.entity.Employee;
import com.example.demo.transaction.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AddressService addressService;

	@Transactional
	public Employee addEmployee(Employee employee) throws Exception {
		Employee employeeSavedToDB = this.employeeRepository.save(employee);

		Address address = new Address();
		address.setId(123L);
		address.setAddress("Varanasi");
		address.setEmployee(employee);

		// calling addAddress() method
		// of AddressService class
		this.addressService.addAddress(address);
		return employeeSavedToDB;
	}
}
