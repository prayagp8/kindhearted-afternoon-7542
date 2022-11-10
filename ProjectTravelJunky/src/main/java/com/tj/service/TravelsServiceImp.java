package com.tj.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tj.exception.TravelsException;
import com.tj.model.Travels;
import com.tj.repository.TravelsDao;

@Service
public class TravelsServiceImp implements TravelsService{

	@Autowired
	private TravelsDao tDao;
	
	
	@Override
	public Travels addTravels(Travels travels) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> trav = tDao.findById(travels.getTravelsId());

		if(trav!=null) {
			throw new TravelsException("Travels already exists..");
		}

		return tDao.save(travels);
	}

	@Override
	public Travels updateTravels(Travels travels, Integer id) throws TravelsException {
		// TODO Auto-generated method stub
		Optional<Travels> trav = tDao.findById(travels.getTravelsId());

		if(trav==null) {
			throw new TravelsException("Travels not exists..");
		}
		return tDao.save(travels);
	}

	@Override
	public Travels removeTravels(Integer id) throws TravelsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Travels searchTravels(Integer id) throws TravelsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		// TODO Auto-generated method stub
		return null;
	}



}
