package com.tj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tj.exception.CustomerException;
import com.tj.model.Customer;
import com.tj.model.Feedback;

@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
	
	
	

}
