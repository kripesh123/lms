package com.texas.librarymanagementsystem.controller;

import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.API_VER;
import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.USER_PATH;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.texas.librarymanagementsystem.controller.exception.CustomerNotFoundException;
import com.texas.librarymanagementsystem.dao.CustomerDAO;
import com.texas.librarymanagementsystem.entity.Customer;
import com.texas.librarymanagementsystem.service.CustomerService;

@RestController
@RequestMapping("customer")
public class CustomerController {
	

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(method=RequestMethod.GET,
			value="/customers",
			params = { "page", "size" })
	public Page<Customer> getAll(@RequestParam("page") int page, @RequestParam("size") int size){
		
		Page<Customer> result = customerService.findPaginated(page, size);
		if(page > result.getTotalPages()) {
			throw new CustomerNotFoundException();
		}
		return result;
	}

}
