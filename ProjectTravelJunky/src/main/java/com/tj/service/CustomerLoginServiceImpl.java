package com.tj.service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.LoginException;
import com.tj.model.Customer;
import com.tj.model.LoginDTO;
import com.tj.model.currentUserSession;
import com.tj.repository.CustomerDao;
import com.tj.repository.SessionDao;

import net.bytebuddy.utility.RandomString;

@Service
public class CustomerLoginServiceImpl implements LoginService{

	@Autowired
	private CustomerDao cDao;
	@Autowired
	private SessionDao sDao;
	
	@Override
	public String logIntoAccount(LoginDTO dto) throws LoginException {
		
		Customer exsistingCustomer = cDao.findByMobileNo(dto.getMobileNo());
		
		if(exsistingCustomer == null) {
			throw new LoginException("please enter valid mobile number!");
		}
		
		 Optional<currentUserSession> validCustomerSessionopt = sDao.findById(exsistingCustomer.getCustomerId());
		 
		 if(validCustomerSessionopt.isPresent()) {
			 throw new LoginException("user already logged in with this number");
		 }
		 
		 if(exsistingCustomer.getCostumerpassword().equals(dto.getPassword())){
			 
			 String key = RandomString.make(6);
			 
			 currentUserSession currentUserSession = new currentUserSession(exsistingCustomer.getCustomerId(), key, LocalDateTime.now());
			 
			 sDao.save(currentUserSession);
			 return currentUserSession.toString();
		 }else {
			 throw new LoginException("Please enter valid password");
		 }
		 
	
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		currentUserSession validCustomerSession = sDao.findByUuid(key);
		
		if(validCustomerSession == null) {
			 throw new LoginException("user not logged in with this number");
		}
		
		sDao.delete(validCustomerSession);
	
		return "Logged Out !";
	}

}
