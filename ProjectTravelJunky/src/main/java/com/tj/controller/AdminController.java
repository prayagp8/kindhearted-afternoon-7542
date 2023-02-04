package com.tj.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.AdminException;
import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.FeedbackException;
import com.tj.exception.HotelException;
import com.tj.exception.LoginException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.exception.ReportException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.exception.TravelsException;
import com.tj.model.Admin;
import com.tj.model.Booking;
import com.tj.model.Bus;
import com.tj.model.Customer;
import com.tj.model.Feedback;
import com.tj.model.Hotel;
import com.tj.model.LoginDTO;
import com.tj.model.Package;
import com.tj.model.PaymentDetails;
import com.tj.model.Report;
import com.tj.model.Route;
import com.tj.model.TicketDetails;

import com.tj.service.AdminLoginServiceImpl;
import com.tj.service.AdminService;
import com.tj.service.BookingService;
import com.tj.service.BusService;
import com.tj.service.CustomerService;
import com.tj.service.FeedbackService;
import com.tj.service.HotelService;
import com.tj.service.PackageService;
import com.tj.service.PaymentService;
import com.tj.service.ReportService;
import com.tj.service.RouteService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminLoginServiceImpl adminLogInServiceImpl;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private FeedbackService feedbackService;


	@Autowired
	private CustomerService cService;

	@Autowired
	private ReportService reportService;






	@Autowired
	private PackageService packageService;

	@Autowired
	private PaymentService paymentService;


	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private AdminService aService;



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
	
	@PostMapping("/admin")
	public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminException {
		
		return new ResponseEntity<Admin>(aService.addAdmin(admin),HttpStatus.ACCEPTED);
	}


	
	/////////////////////////// Report Controller Part

	@GetMapping("/report/reports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}
	@PostMapping("/report/reports")
	public ResponseEntity<Report> addReport(@Valid @RequestBody Report report) throws ReportException {
		return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/report/reports/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable("reportId") Integer reportId) throws ReportException {
		return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
	}

	@GetMapping("/report/reports/{reportId}")
	public ResponseEntity<Report> findByReportId(@PathVariable("reportId") Integer reportId) throws ReportException {
		return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
	}





	///////////////payment controller////////////////
	@GetMapping("payment/payments")
	public ResponseEntity<List<PaymentDetails>> veiwAllPayments() throws PaymentException{
		List<PaymentDetails> pList = paymentService.veiwAllPayments();
		return new ResponseEntity<List<PaymentDetails>>(pList,HttpStatus.OK);
	}





	///////////////////////////feedback Controller Part

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
	}

	@GetMapping("/feedbackcustomer/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId)
			throws FeedbackException, CustomerException {

		List<Feedback> feedBacks = feedbackService.findByCustomerId(customerId);

		return new ResponseEntity<List<Feedback>>(feedBacks, HttpStatus.OK);

	}

	@GetMapping("/feedbacks/{feedbackId}")
	public ResponseEntity<Feedback> findByFeeedbackId(@PathVariable("feedbackId") Integer feedbackId)
			throws FeedbackException {
		return new ResponseEntity<Feedback>(feedbackService.findByFeeedbackId(feedbackId), HttpStatus.OK);
	}



	///////////////////////////booking Controller Part

	@DeleteMapping("/cancelbooking/{id}")
	public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.cancelBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}


	@GetMapping("/viewbooking/{id}")
	public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
		Booking booking= bookingService.viewBooking(id);
		return new ResponseEntity<Booking>(booking,HttpStatus.OK);
	}

	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
		List<Booking> list = bookingService.viewAllBookings();
		return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
	}





	

	
	

}
