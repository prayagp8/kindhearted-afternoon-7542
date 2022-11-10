package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.FeedbackException;
import com.tj.model.Feedback;
import com.tj.service.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/feedbacks")
	public ResponseEntity<Feedback> addFeedback(@RequestBody Feedback feedback) throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback), HttpStatus.ACCEPTED);
	}

	@GetMapping("/feedbacks/{feedbackId}")
	public ResponseEntity<Feedback> findByFeeedbackId(@PathVariable Integer feedbackId) throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.findByFeeedbackId(feedbackId), HttpStatus.OK);
	}

	@GetMapping("/feedbacks/{customerId}")
	public ResponseEntity<Feedback> findByCustomerId(@PathVariable Integer customerId) throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.findByCustomerId(customerId), HttpStatus.OK);
	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
	}

}
