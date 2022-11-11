package com.tj.service;

import java.util.List;

import com.tj.exception.BusException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.model.Route;


public interface RouteService {

	public Route addRoute(Route route) throws RouteException;
	public Route ticketBook(Integer routeId,Integer busId,Integer tickedId) throws RouteException,BusException,TicketException;
	public Route removeRoute(Integer routeId) throws RouteException;
	public Route searchRoute(Integer routeId) throws RouteException;
	public List<Route> viewRouteList() throws RouteException;
	public Route updateRoute(Route route) throws RouteException;
}
