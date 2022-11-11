package com.tj.service;

import java.util.List;

import com.tj.exception.CustomerException;
import com.tj.exception.FeedbackException;
import com.tj.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback, Integer customerId) throws FeedbackException,CustomerException;

	public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException;

	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException,CustomerException;

	public List<Feedback> viewAllFeedbacks() throws FeedbackException;
	
	

}
