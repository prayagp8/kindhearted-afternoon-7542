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

		// for user login
		@PostMapping("/userlogin")
		public String loginCustomerr(@Valid @RequestBody LoginDTO customerDTO) throws Exception {
			return customerLoginServiceImpl.logIntoAccount(customerDTO);
		}

		// for user logout
		@PostMapping("/userlogout")
		public String logOutCustomerr(@RequestParam(required = false) String key) throws LoginException {
			return customerLoginServiceImpl.logOutFromAccount(key);
		}

		// for admin login
		@PostMapping("/adminlogin")
		public String logInAdmin(@Valid @RequestBody LoginDTO adminDTO) throws LoginException {
			return adminLogInServiceImpl.logIntoAccount(adminDTO);
		}

		// for admin logout
		@PostMapping("/adminlogout")
		public String logOutAdmin(@RequestParam(required = false) String key) throws LoginException {
			return adminLogInServiceImpl.logOutFromAccount(key);
		}


	}
