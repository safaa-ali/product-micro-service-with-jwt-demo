package com.example.demo.transaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.transaction.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}