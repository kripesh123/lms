package com.texas.librarymanagementsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.texas.librarymanagementsystem.entity.Customer;

public interface CustomerService {

	Page<Customer> findPaginated(int page, int size);
	List<Customer> findAll();
}
