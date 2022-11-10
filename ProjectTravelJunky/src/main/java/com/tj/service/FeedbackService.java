package com.tj.service;

import java.util.List;

import com.tj.exception.FeedbackException;
import com.tj.model.Feedback;

public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback) throws FeedbackException;

	public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException;

	public Feedback findByCustomerId(Integer customerId) throws FeedbackException;

	public List<Feedback> viewAllFeedbacks() throws FeedbackException;

}
