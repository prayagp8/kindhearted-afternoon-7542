package com.tj.service;

import java.util.List;

import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.RouteException;
import com.tj.exception.TravelsException;
import com.tj.model.Booking;
import com.tj.model.Bus;
import com.tj.model.Route;


public interface BusService {

	public Bus addBus(Bus bus) throws BusException;
	
	public Bus searchBusByid(Integer busId) throws BusException;
	
	public Bus updateBus(Bus bus) throws BusException;
	
	
	public List<Bus> veiwAllBuses() throws BusException;
	

	
	public Bus addRouteServices(Integer busId, Integer routeId) throws BusException,RouteException;
	
	public Bus deleteBus(Integer busId) throws BusException;
	
	
	public Booking addBusToBooking(Integer bId,Integer busId) throws BusException,CustomerException;
}
