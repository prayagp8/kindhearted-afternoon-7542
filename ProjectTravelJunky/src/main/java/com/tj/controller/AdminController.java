package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.BusException;
import com.tj.exception.ReportException;
import com.tj.exception.RouteException;
import com.tj.exception.TravelsException;
import com.tj.model.Bus;
import com.tj.model.Report;
import com.tj.model.Route;
import com.tj.model.Travels;
import com.tj.service.BusService;
import com.tj.service.ReportService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private ReportService reportService;
	
	@Autowired
	private BusService busService;

	@GetMapping("/reports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}
	
	@PostMapping("/buses")
	public ResponseEntity<Bus> addBus(@RequestBody Bus bus) throws BusException{
		Bus b = busService.addBus(bus);
		return new ResponseEntity<Bus>(b,HttpStatus.OK);
	}
	
	@GetMapping("/buses")
	public ResponseEntity<List<Bus>> veiwAllBuses() throws BusException{
		List<Bus> bList = busService.veiwAllBuses();
		return new ResponseEntity<List<Bus>>(bList,HttpStatus.OK);
	}
	
	@GetMapping("/addtravels/{busId}/{travelId}")
	public ResponseEntity<Travels> addTravelService(@PathVariable("busId")Integer busId, @PathVariable("travelId") Integer travelId) throws TravelsException, BusException{
		Travels t  = busService.addTravelService(busId, travelId);
		
		return new ResponseEntity<Travels>(t,HttpStatus.OK);
	}
	
	@GetMapping("/addroute/{busId}/{routeId}")
	public ResponseEntity<Route> addRouteServices(@PathVariable("busId")Integer busId, @PathVariable("routeId") Integer routeId) throws BusException, RouteException{
		Route r = busService.addRouteServices(busId, routeId);
		return new ResponseEntity<Route>(r,HttpStatus.OK);
	}
	
	

}
