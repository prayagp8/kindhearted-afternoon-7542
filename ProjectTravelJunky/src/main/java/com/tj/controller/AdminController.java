package com.tj.controller;

import java.util.List;

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

import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.ReportException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.exception.TravelsException;
import com.tj.model.Bus;
import com.tj.model.Customer;
import com.tj.model.Report;
import com.tj.model.Route;
import com.tj.model.Travels;
import com.tj.service.BusService;
import com.tj.service.CustomerService;
import com.tj.service.ReportService;
import com.tj.service.RouteService;
import com.tj.service.TravelsService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	
	
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

	/////////////////////////// Report Controller Part

	@GetMapping("/report/reports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}
	@PostMapping("/report/reports")
	public ResponseEntity<Report> addReport(@RequestBody Report report) throws ReportException {
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
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) throws BusException {
		Bus b = busService.addBus(bus);
		return new ResponseEntity<Bus>(b, HttpStatus.OK);
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
	public ResponseEntity<Travels> updateTravels(@RequestBody Travels travels) throws TravelsException {

		Travels t = tservice.updateTravels(travels);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@DeleteMapping("/travel/removetravel/{id}")
	public ResponseEntity<Travels> removeTravels(@PathVariable("id") Integer id) throws TravelsException {

		Travels t = tservice.removeTravels(id);

		return new ResponseEntity<Travels>(t, HttpStatus.OK);

	}

	@PostMapping("/travel/add")
	public ResponseEntity<Travels> addTravels(@RequestBody Travels travels) throws TravelsException {

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
	public ResponseEntity<Route> addRoute(@RequestBody Route route) throws RouteException {

		Route r = rService.addRoute(route);

		return new ResponseEntity<Route>(r, HttpStatus.OK);

	}

	@GetMapping("/route/book/{routeId}/{busId}/{ticketId}")
	public ResponseEntity<Route> bookTicket(@PathVariable("routeId") Integer routeId,
			@PathVariable("busId") Integer busId, @PathVariable("ticketId") Integer ticketId)
			throws RouteException, BusException, TicketException {
		Route r = rService.ticketBook(routeId, busId, ticketId);
		return new ResponseEntity<Route>(r, HttpStatus.OK);
	}

	@PutMapping("/route/routes")
	public ResponseEntity<Route> updateRoute(@RequestBody Route route) throws RouteException {
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
	public ResponseEntity<Customer> deleteCustomerByCustomer(@RequestBody Customer customer) throws CustomerException{
		
		Customer customers=cService.deleteCustomer(customer);
		
		return new ResponseEntity<Customer>(customers,HttpStatus.OK);
		
	}

}
