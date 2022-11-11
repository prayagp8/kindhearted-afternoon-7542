package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tj.exception.BusException;
import com.tj.exception.RouteException;
import com.tj.exception.TravelsException;
import com.tj.model.Bus;
import com.tj.model.Route;
import com.tj.model.Travels;
import com.tj.repository.BusDao;
import com.tj.repository.RouteDao;
import com.tj.repository.TravelsDao;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao bDao;
	@Autowired
	private TravelsDao tDao;
	@Autowired
	private RouteDao rDao;
	
	@Override
	public Bus addBus(Bus bus) throws BusException {
		return bDao.save(bus);
	}

	@Override
	public List<Bus> veiwAllBuses() throws BusException {
		 List<Bus> busList= bDao.findAll();
		 
		 if(busList.size()==0) {
			 throw new BusException("There is no bus registered!!");
		 }else {
			 return busList;
		 }
		
	}

	@Override
	public Travels addTravelService(Integer busId, Integer travelsId) throws TravelsException, BusException {
		Optional<Bus> exsistingBus = bDao.findById(busId);
		Optional<Travels> exsistingTravels = tDao.findById(travelsId); 
		
		if(exsistingBus.isPresent()) {
			if(exsistingTravels.isPresent()) {
				Bus b = exsistingBus.get();
				b.setTravels(exsistingTravels.get());
				bDao.save(b);
				return exsistingTravels.get();
				
			}else {
				throw new TravelsException("no travel service is with this id "+travelsId);
			}
			
		}else {
			throw new BusException("no bus is available with this id "+busId);
		}
		
		
	}

	@Override
	public Route addRouteServices(Integer busId, Integer routeId) throws BusException, RouteException {
		
		  Bus b = bDao.findById(busId).orElseThrow(()-> new BusException("bus not found with this bus id :"+busId) );
		  
		  Route r  = rDao.findById(routeId).orElseThrow(()-> new RouteException("route not found with this route id :"+routeId) );
		  
		  b.setRoute(r);
		  r.setBus(b);
		  
		  bDao.save(b);
		  
		  
		  return r;
		  
	}


	
}
