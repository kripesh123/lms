package com.texas.librarymanagementsystem.controller.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("admin/test")
public class AdminController {

	public String test(){
		return "mock";
	}
}
