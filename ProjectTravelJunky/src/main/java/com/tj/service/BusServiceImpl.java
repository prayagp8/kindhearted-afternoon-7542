package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.tj.exception.BusException;
import com.tj.exception.CustomerException;
import com.tj.exception.ReportException;
import com.tj.exception.RouteException;
import com.tj.exception.TravelsException;
import com.tj.model.Booking;
import com.tj.model.Bus;
import com.tj.model.Customer;
import com.tj.model.Report;
import com.tj.model.Route;
import com.tj.repository.BookingDAO;
import com.tj.repository.BusDao;
import com.tj.repository.CustomerDao;
import com.tj.repository.RouteDao;


@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao bDao;

	@Autowired
	private RouteDao rDao;
	
	@Autowired
	private BookingDAO bookingDAO;

	@Override
	public Bus addBus(Bus bus) throws BusException {
		return bDao.save(bus);
	}

	@Override
	public List<Bus> veiwAllBuses() throws BusException {
		List<Bus> busList = bDao.findAll();

		if (busList.size() == 0) {
			throw new BusException("There is no bus registered!!");
		} else {
			return busList;
		}

	}


	@Override
	public Bus addRouteServices(Integer busId, Integer routeId) throws BusException, RouteException {

		Bus b = bDao.findById(busId).orElseThrow(() -> new BusException("bus not found with this bus id :" + busId));

		Route r = rDao.findById(routeId)
				.orElseThrow(() -> new RouteException("route not found with this route id :" + routeId));

		b.setRoute(r);
		
		

	

		return 	bDao.save(b);

	}

	@Override
	public Bus deleteBus(Integer busId) throws BusException {

		Optional<Bus> findedBus = bDao.findById(busId);

		if (findedBus.isPresent()) {
			Bus buss = findedBus.get();
			bDao.deleteById(busId);
			return buss;
		} else {
			throw new BusException("Bus Not Avalebale By Bus Id: " + busId);
		}
	}

	@Override
	public Bus searchBusByid(Integer busId) throws BusException {


		Optional<Bus> opt = bDao.findById(busId);
		if (opt == null) {
			throw new BusException("Bus does not exists with Report Id : " + busId);
		}
		return opt.get();
	}

	@Override
	public Bus updateBus(Bus bus) throws BusException {
		Bus b=bDao.findById(bus.getBusId())
				.orElseThrow(()->new BusException("Bus not exists.."));
		return bDao.save(bus);
	}

	@Override
	public Booking addBusToBooking(Integer bId , Integer busId) throws BusException, CustomerException {
		Booking booking = bookingDAO.findById(bId).orElseThrow(()->new CustomerException("booking not found!!"));
		Bus bus = bDao.findById(busId).orElseThrow(()->new BusException("bus not found!!"));
		
		booking.setBus(bus);
	
		
		
		return bookingDAO.save(booking);
	}

	

}
