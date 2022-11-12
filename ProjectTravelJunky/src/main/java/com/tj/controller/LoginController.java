package com.tj.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.LoginException;
import com.tj.model.LoginDTO;
import com.tj.service.AdminLoginServiceImpl;
import com.tj.service.CustomerLoginServiceImpl;

@RestController
public class LoginController {

		@Autowired
		private CustomerLoginServiceImpl customerLoginServiceImpl;

		@Autowired
		private AdminLoginServiceImpl adminLogInServiceImpl;

	

		


	}
