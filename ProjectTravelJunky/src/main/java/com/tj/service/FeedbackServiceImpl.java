package com.tj.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.CustomerException;
import com.tj.exception.FeedbackException;
import com.tj.model.Customer;
import com.tj.model.Feedback;
import com.tj.repository.CustomerDao;
import com.tj.repository.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDao feedbackDao;

	@Autowired
	private CustomerDao customerDao;

	@Override
	public Feedback addFeedback(Feedback feedback, Integer customerId) throws FeedbackException, CustomerException {
		Optional<Customer> findedCustomer = customerDao.findById(customerId);

		if (findedCustomer.isPresent()) {

			Customer cus = findedCustomer.get();
			
			feedback.setSubmitDate(LocalDate.now());
			
			cus.getFeedbackList().add(feedback);
			
			return feedbackDao.save(feedback);

			
		} else {
			throw new CustomerException("Customer is Not avalible By Id: " + customerId);
		}

	}

	@Override
	public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException {
		Optional<Feedback> opt = feedbackDao.findById(feedbackId);
		if (opt.isPresent()) {
			throw new FeedbackException("Feedback does not exists with Feedback Id : " + feedbackId);
		}
		return opt.get();
	}

	@Override
	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException, CustomerException {

		Optional<Customer> findedCust = customerDao.findById(customerId);
		if (findedCust.isPresent()) {

			Customer cus = findedCust.get();
			List<Feedback> cfidfect = cus.getFeedbackList();
			if (cfidfect.size() > 0) {
				return cfidfect;
			} else {
				throw new FeedbackException("No FeedBack is present By Customer Id; " + customerId);
			}

		} else
			throw new CustomerException("Customer not find by customer Id: " + customerId);

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
