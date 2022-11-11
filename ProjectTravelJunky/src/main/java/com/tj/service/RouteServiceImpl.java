package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BusException;
import com.tj.exception.RouteException;
import com.tj.exception.TicketException;
import com.tj.model.Route;

import com.tj.repository.RouteDao;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteDao rDao;


	@Override
	public Route addRoute(Route route) throws RouteException {

		Optional<Route> exsistingRoute = rDao.findById(route.getRouteId());

		if(exsistingRoute.isPresent()) {
			throw new RouteException("This route is already added!!");
		}else {
			return rDao.save(route);
		}
	}

	@Override
	public Route updateRoute(Integer routeId, Integer busId, Integer tickedId)
			throws RouteException, BusException, TicketException {
		// TODO Auto-generated method stub
		return null;
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

}
