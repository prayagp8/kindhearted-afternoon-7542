package com.tj.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.exception.TravelsException;
import com.tj.model.Bus;
import com.tj.model.Customer;
import com.tj.model.Hotel;
import com.tj.model.Package;
import com.tj.model.PaymentDetails;
import com.tj.model.Route;
import com.tj.model.TicketDetails;
import com.tj.model.Travels;
import com.tj.service.BusService;
import com.tj.service.CustomerService;
import com.tj.service.HotelService;
import com.tj.service.PackageService;
import com.tj.service.PaymentService;
import com.tj.service.ReportService;
import com.tj.service.RouteService;
import com.tj.service.TicketService;
import com.tj.service.TravelsService;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private HotelService hotelService;

	@Autowired
	private CustomerService cService;

	@Autowired
	private TravelsService tservice;
	
	@Autowired
	private RouteService rService;
	
	@Autowired
	private ReportService reportService;

	@Autowired
	private BusService busService;
	
	@Autowired
	private PackageService packageService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private TicketService ticketService;

///////////////////////////Customer Controller Part

	@PostMapping("/customers")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

		Customer c = cService.createCustomer(customer);

		return new ResponseEntity<Customer>(c, HttpStatus.OK);

	}

	@PutMapping("/customers/{key}")
	public ResponseEntity<Customer> updateCustomerDetailsHandler(@Valid @RequestBody Customer costumer,
			@PathVariable("key") String key) throws CustomerException {

		Customer updateCu = cService.updateCustomer(costumer, key);

		return new ResponseEntity<>(updateCu, HttpStatus.OK);

	}

///////////////////////////Travel Controller Part
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
	
	@GetMapping("/route/routes")
	public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
		List<Route> routeList = rService.viewRouteList();
		return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);
		
	}
	
	@GetMapping("/route/routesbyid/{id}")
	public ResponseEntity<Route> searchRoute(@PathVariable("id")Integer routeId) throws RouteException{
		
		Route r = rService.searchRoute(routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
///////////////////////////Package Controller Part	
	
	
	@GetMapping("/allpackage")
	public ResponseEntity<List<Package>> viewAllPackage() throws PackageException{
		List<Package> list = packageService.viewAllPackage();
		return new ResponseEntity<List<Package>>(list,HttpStatus.OK);
	}
	
	@GetMapping("/viewpackage/{pid}")
	public ResponseEntity<Package> viewPackage(@PathVariable("pid") Integer id) throws PackageException{
		Package package1= packageService.searchPackage(id);
		return new ResponseEntity<Package>(package1,HttpStatus.OK);
	}
	
///////////////////////////Payment Controller Part	
	
	@PostMapping("/payment/{pId}/{bId}/{hId}")
	public ResponseEntity<PaymentDetails> payment(@RequestBody PaymentDetails paymentD ,@PathVariable("pId") Integer packageId, @PathVariable("bId") Integer bookingId, @PathVariable("hId") Integer hotelId) throws PackageException, PaymentException, BookingException, HotelException {
		PaymentDetails payment  = paymentService.payment(paymentD, packageId, bookingId, hotelId);
		
		return new ResponseEntity<PaymentDetails>(payment,HttpStatus.ACCEPTED);
		
		
	}
	
	
///////////////////////////Ticket Controller Part	
	
	@PostMapping("ticket/{paymentId}")
	public ResponseEntity<TicketDetails> addticket(@RequestBody TicketDetails ticket, @PathVariable("paymentId") Integer paymentId) throws TicketException, PaymentException{
		
		TicketDetails t = ticketService.addticket(ticket, paymentId);
		
		return new ResponseEntity<TicketDetails>(t,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/ticket/{tId}")
	public ResponseEntity<TicketDetails> CancelTicket(@PathVariable("tId") Integer ticketId) throws TicketException {
		
		TicketDetails t = ticketService.deleteTicket(ticketId);
		
		return new ResponseEntity<TicketDetails>(t,HttpStatus.OK);
	}
	
///////////////////////////Hotel Controller Part
	
	@GetMapping("/hotels")
	public ResponseEntity<List<Hotel>> viewAllHoltels() throws HotelException {
		List<Hotel> hList = hotelService.viewAllHotels();
		return new ResponseEntity<List<Hotel>>(hList,HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hId}/{pId}")
	public ResponseEntity<Package> addHotel(@PathVariable("hId") Integer hotelId, @PathVariable("pId") Integer packageId) throws HotelException, PackageException{
		
	         Package p = hotelService.addPackage(hotelId, packageId);
	         
	         return new ResponseEntity<Package>(p,HttpStatus.OK);
	}
	
	@GetMapping("/hotels/{hotelId}")
	public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
		return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
	}
	

///////////////////////////Bus Controller Part
	
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

}
