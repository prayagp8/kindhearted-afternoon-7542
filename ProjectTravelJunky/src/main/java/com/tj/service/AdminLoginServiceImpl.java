package com.tj.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.LoginException;
import com.tj.model.Admin;
import com.tj.model.Customer;
import com.tj.model.LoginDTO;
import com.tj.model.currentUserSession;
import com.tj.repository.AdminDao;
import com.tj.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class AdminLoginServiceImpl implements LoginService {

	@Autowired
	private AdminDao adminDao;
	@Autowired
	private SessionDao sessionDao;


	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		Admin exsistingCustomer = adminDao.findByMobile(dto.getMobileNo());

		if(exsistingCustomer == null) {
			throw new LoginException("please enter valid mobile number!");
		}

		Optional<currentUserSession> validAdminSessionopt = sessionDao.findById(exsistingCustomer.getAdminId());

		if(validAdminSessionopt.isPresent()) {
			throw new LoginException("user already logged in with this number!!!");
		}

		if(exsistingCustomer.getPassword().equals(dto.getPassword())){

			String key = RandomString.make(6);

			currentUserSession currentUserSession = new currentUserSession(exsistingCustomer.getAdminId(), key, LocalDateTime.now());

			sessionDao.save(currentUserSession);
			return currentUserSession.toString();

		}else {
			throw new LoginException("Please enter valid password!!");
		}
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		currentUserSession validAdminSession = sessionDao.findByUuid(key);

		if(validAdminSession == null) {
			throw new LoginException("user not logged in with this number");
		}

		sessionDao.delete(validAdminSession);

		return "Logged Out !";
	}

}
