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
import com.tj.model.Travels;
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
import com.tj.service.TicketService;
import com.tj.service.TravelsService;

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
	private BusService busService;

	@Autowired
	private TravelsService tservice;

	@Autowired
	private RouteService rService;

	@Autowired
	private PackageService packageService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private TicketService ticketService;
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



	///////////////////////////Bus Controller Part

	@PostMapping("/bus/buses")
	public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) throws BusException {
		Bus b = busService.addBus(bus);
		return new ResponseEntity<Bus>(b, HttpStatus.OK);
	}

	@PutMapping("/bus/updatebus")
	public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus) throws BusException {

		Bus b = busService.updateBus(bus);
		return new ResponseEntity<Bus>(b, HttpStatus.OK);

	}
	
	@GetMapping("/bus/search/{busid}")
	public ResponseEntity<Bus> searchBusByBusId(@PathVariable("busid") Integer busId) throws BusException {

		Bus bus = busService.searchBusByid(busId);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/bus/buses")
	public ResponseEntity<List<Bus>> veiwAllBuses() throws BusException {
		List<Bus> bList = busService.veiwAllBuses();
		return new ResponseEntity<List<Bus>>(bList, HttpStatus.OK);
	}

	@DeleteMapping("/bus/deletebus/{busid}")
	public ResponseEntity<Bus> deleteBusByBusId(@PathVariable("busid") Integer busId) throws BusException {

		Bus bus = busService.deleteBus(busId);
		return new ResponseEntity<Bus>(bus, HttpStatus.OK);
	}

	///////////////////////////Travel Controller Part
	@GetMapping("/travel/addtravels/{busId}/{travelId}")
	public ResponseEntity<Travels> addTravelService(@PathVariable("busId") Integer busId,
			@PathVariable("travelId") Integer travelId) throws TravelsException, BusException {
		Travels t = busService.addTravelService(busId, travelId);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);
	}

	@PutMapping("/travel/updatetravel")
	public ResponseEntity<Travels> updateTravels(@Valid @RequestBody Travels travels) throws TravelsException {

		Travels t = tservice.updateTravels(travels);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@DeleteMapping("/travel/removetravel/{id}")
	public ResponseEntity<Travels> removeTravels(@PathVariable("id") Integer id) throws TravelsException {

		Travels t = tservice.removeTravels(id);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@PostMapping("/travel/add")
	public ResponseEntity<Travels> addTravels(@Valid @RequestBody Travels travels) throws TravelsException {

		Travels t = tservice.addTravels(travels);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@GetMapping("/travel/search/{id}")
	public ResponseEntity<Travels> searchTravels(@PathVariable("id") Integer id) throws TravelsException {

		Travels t = tservice.searchTravels(id);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@GetMapping("/travel/view")
	public ResponseEntity<List<Travels>> viewTravels() throws TravelsException {

		List<Travels> list = tservice.viewTravels();
		return new ResponseEntity<List<Travels>>(list, HttpStatus.OK);

	}


	///////////////////////////Route Controller Part

	@GetMapping("/route/addroute/{busId}/{routeId}")
	public ResponseEntity<Route> addRouteServices(@PathVariable("busId") Integer busId,
			@PathVariable("routeId") Integer routeId) throws BusException, RouteException {
		Route r = busService.addRouteServices(busId, routeId);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@PostMapping("/route/routes")
	public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws RouteException {

		Route r = rService.addRoute(route);

		return new ResponseEntity<Route>(r, HttpStatus.OK);

	}

	//	this function is to change status ticket (booking -->booking confirmed)
	@GetMapping("/route/book/{routeId}/{busId}/{ticketId}")
	public ResponseEntity<Route> confirmBooking(@PathVariable("routeId") Integer routeId,
			@PathVariable("busId") Integer busId, @PathVariable("ticketId") Integer ticketId)
					throws RouteException, BusException, TicketException {
		Route r = rService.ticketBook(routeId, busId, ticketId);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@PutMapping("/route/routes")
	public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route) throws RouteException {
		Route r = rService.updateRoute(route);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@DeleteMapping("/route/routes/{routeId}")
	public ResponseEntity<Route> removeRoute(@PathVariable("routeId") Integer routeId) throws RouteException {
		Route r = rService.removeRoute(routeId);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@GetMapping("/routes")
	public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
		List<Route> routeList = rService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);

	}

	@GetMapping("/routesbyid")
	public ResponseEntity<Route> searchRoute(Integer routeId) throws RouteException{

		Route r = rService.searchRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}


	///////////////////////////Customer Controller Part

	@GetMapping("/customers")
	public ResponseEntity<java.util.List<Customer>> getAllCustomer() throws CustomerException{

		java.util.List<Customer> customers=cService.allCustomer();

		return new ResponseEntity<java.util.List<Customer>>(customers,HttpStatus.OK);

	}
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws CustomerException{

		Customer customers=cService.viewCustomer(id);

		return new ResponseEntity<Customer>(customers,HttpStatus.OK);

	}

	@DeleteMapping("/customers/{id}")
	public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id) throws CustomerException{

		Customer customers=cService.deleteCustomerById(id);

		return new ResponseEntity<Customer>(customers,HttpStatus.OK);

	}

	@DeleteMapping("/customers")
	public ResponseEntity<Customer> deleteCustomerByCustomer(@Valid @RequestBody Customer customer) throws CustomerException{

		Customer customers=cService.deleteCustomer(customer);

		return new ResponseEntity<Customer>(customers,HttpStatus.OK);

	}


	///////////////package controller////////////////

	@PostMapping("/package/addpackage")
	public ResponseEntity<Package> addPackage(@Valid @RequestBody Package package1) throws PackageException{
		Package package2=packageService.addPackage(package1);
		return new ResponseEntity<Package>(package2, HttpStatus.CREATED);
	}

	@DeleteMapping("/package/deletepackage/{id}")
	public ResponseEntity<Package> deletePackage(@PathVariable("id") Integer id) throws PackageException{
		Package package1= packageService.deletePackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}

	@GetMapping("/package/allpackage")
	public ResponseEntity<List<Package>> viewAllPackage() throws PackageException{
		List<Package> list = packageService.viewAllPackage();
		return new ResponseEntity<List<Package>>(list,HttpStatus.OK);
	}




	///////////////ticket controller////////////////


	@GetMapping("ticket/tickets")
	public ResponseEntity<List<TicketDetails>> viewAllTicket() throws TicketException{
		List<TicketDetails> tList= ticketService.viewAllTicket();

		return new ResponseEntity<List<TicketDetails>>(tList,HttpStatus.OK);
	}


	///////////////payment controller////////////////
	@GetMapping("payment/payments")
	public ResponseEntity<List<PaymentDetails>> veiwAllPayments() throws PaymentException{
		List<PaymentDetails> pList = paymentService.veiwAllPayments();
		return new ResponseEntity<List<PaymentDetails>>(pList,HttpStatus.OK);
	}



	///////////////hotel controller////////////////

	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> viewAllHoltels() throws HotelException {
		List<Hotel> hList = hotelService.viewAllHotels();
		return new ResponseEntity<List<Hotel>>(hList,HttpStatus.OK);
	}

	@GetMapping("/hotels/{hId}/{pId}")
	public ResponseEntity<Package> addPackage(@PathVariable("hId") Integer hotelId, @PathVariable("pId") Integer packageId) throws HotelException, PackageException{

		Package p = hotelService.addPackage(hotelId, packageId);

		return new ResponseEntity<Package>(p,HttpStatus.OK);
	}

	@DeleteMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
	}

	@PostMapping("/hotels")
	public ResponseEntity<Hotel> addHotel(@Valid @RequestBody Hotel hotel) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.addHotel(hotel), HttpStatus.ACCEPTED);
	}

	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
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
