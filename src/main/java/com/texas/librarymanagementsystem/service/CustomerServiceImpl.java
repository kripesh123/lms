package com.texas.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.texas.librarymanagementsystem.dao.CustomerDAO;
import com.texas.librarymanagementsystem.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	@Override
	public Page<Customer> findPaginated(int page, int size) {
		return customerDAO.findAll(new PageRequest(page, size));
	}
	@Override
	public List<Customer> findAll() {
		return customerDAO.findAll();
	}

}
