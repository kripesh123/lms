package com.texas.librarymanagementsystem.service;

import org.springframework.data.domain.Page;

import com.texas.librarymanagementsystem.entity.Customer;

public interface CustomerService {

	Page<Customer> findPaginated(int page, int size);
}
