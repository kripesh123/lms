package com.texas.librarymanagementsystem.controller.admin;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.texas.librarymanagementsystem.entity.Mock;

import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.ADMIN_PATH;
import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.TEST_PATH;

@RestController
@RequestMapping(ADMIN_PATH + TEST_PATH)
public class AdminController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Mock> test(){
		return new ResponseEntity<Mock>(new Mock("This is admin"),HttpStatus.OK);
	}
}
