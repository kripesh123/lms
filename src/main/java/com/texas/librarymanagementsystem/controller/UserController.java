package com.texas.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.texas.librarymanagementsystem.controller.exception.LoginException;
import com.texas.librarymanagementsystem.entity.User;
import com.texas.librarymanagementsystem.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.API_VER;
import static com.texas.librarymanagementsystem.controller.utils.ApiConstants.USER_PATH;

import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping(API_VER + USER_PATH)
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> json) {
        if(json.get("username") == "" || json.get("password") == "") {
            throw new LoginException("Please fill in username and password");
        }

        String userName = json.get("username");
        String password = json.get("password");

        User user= userService.findByUsername(userName);
        if (user==null) {
            throw new LoginException("User name not found.");
        }

        String pwd = user.getPassword();

        if(!password.equals(pwd)) {
            throw new LoginException("Invalid login. Please check your name and password");
        }

        String a= Jwts.builder().setSubject(userName).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
        return a;
    }

}
