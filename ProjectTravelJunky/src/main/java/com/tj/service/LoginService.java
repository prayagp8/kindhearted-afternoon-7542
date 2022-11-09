package com.tj.service;

import com.tj.exception.LoginException;
import com.tj.model.LoginDTO;

public interface LoginService {

	public String logIntoAccount(LoginDTO dto) throws LoginException;
	
	public String logOutFromAccount(String key) throws LoginException;
}
