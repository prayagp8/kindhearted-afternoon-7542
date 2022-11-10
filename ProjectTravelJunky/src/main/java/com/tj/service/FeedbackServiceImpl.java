package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.FeedbackException;
import com.tj.model.Feedback;
import com.tj.repository.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	@Override
	public Feedback addFeedback(Feedback feedback) throws FeedbackException {
		Feedback feedback2 = feedbackDao.save(feedback);
		if (feedback2 == null) {
			throw new FeedbackException("Feedback can not be added.");
		}
		return feedback2;
	}

	@Override
	public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException {
		Optional<Feedback> opt = feedbackDao.findById(feedbackId);
		if (opt == null) {
			throw new FeedbackException("Feedback does not exists with Feedback Id : " + feedbackId);
		}
		return opt.get();
	}

	@Override
	public Feedback findByCustomerId(Integer customerId) throws FeedbackException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Feedback> viewAllFeedbacks() throws FeedbackException {
		List<Feedback> feedbacks = feedbackDao.findAll();
		if (feedbacks.isEmpty()) {
			throw new FeedbackException("No feedback exists.");
		}
		return feedbacks;
	}

}
