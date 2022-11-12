package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BusException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.model.Bus;
import com.tj.model.Route;
import com.tj.model.TicketDetails;
import com.tj.repository.BusDao;
import com.tj.repository.RouteDao;
import com.tj.repository.TicketDetailsDAO;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao rDao;
	@Autowired
	private BusDao bDao;
	@Autowired
	private TicketDetailsDAO tDao;


	@Override
	public Route addRoute(Route route) throws RouteException {

//		Optional<Route> exsistingRoute = rDao.findById(route.getRouteId());

			return rDao.save(route);
		
	}

	@Override
	public Route ticketBook(Integer routeId, Integer busId, Integer tickedId) throws RouteException, BusException, TicketException {
		Optional<Route> exsistingRoute = rDao.findById(routeId);
		Optional<Bus> exsistingBus = bDao.findById(busId);
		Optional<TicketDetails> exsistingTicket = tDao.findById(tickedId);

		if(exsistingRoute.isPresent()) {
			if(exsistingBus.isPresent()) {
				if(exsistingTicket.isPresent()) {
					Route route = exsistingRoute.get();
					Bus bus = exsistingBus.get();
					TicketDetails ticket = exsistingTicket.get();
//					route.setBus(bus);
					ticket.setStatus("booking confirmed!!");
					ticket.setRoute(route);
					route.setTicketDetails(ticket);
					
					return rDao.save(route);

				}else {
					throw new TicketException("ticket is not available!!!");
				}



			}else {
				throw new BusException("No bus is available for this bus id "+busId);
			}

		}else {
			throw new RouteException("This route is not available!!");
		}


	}

	@Override
	public Route removeRoute(Integer routeId) throws RouteException {

		Optional<Route> exsistingRoute=rDao.findById(routeId);
		if (!exsistingRoute.isPresent()) {
			throw new RouteException("This Route is not present in database to delete.");
		}
		rDao.delete(exsistingRoute.get());
		return exsistingRoute.get();
	}

	@Override
	public Route searchRoute(Integer routeId) throws RouteException {

		Optional<Route> exsistingRoute = rDao.findById(routeId);

		if(!exsistingRoute.isPresent()) {
			throw new RouteException("This route is not present!!");
		}else {
			return exsistingRoute.get();
		}

	}

	@Override
	public List<Route> viewRouteList() throws RouteException {

		List<Route> exsistingRouteList = rDao.findAll();

		if(exsistingRouteList.size()==0) {
			throw new RouteException("No route is present to travel!!");
		}else {
			return exsistingRouteList;
		}
	}

	@Override
	public Route updateRoute(Route route) throws RouteException {
		Optional<Route> exsistingRoute = rDao.findById(route.getRouteId());
		
		if(exsistingRoute.isPresent()) {
			Route updatedRoute = rDao.save(route);
			return updatedRoute;
			
		}else {
			throw new RouteException("No such route is present to update!!");
		}
		
	}

}
