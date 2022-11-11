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
	
			return tDao.save(travels);
		
	}

	@Override
	public Travels updateTravels(Travels travels) throws TravelsException {

		Travels trav=tDao.findById(travels.getTravelsId())
				.orElseThrow(()->new TravelsException("Travels not exists.."));
		return tDao.save(travels);
	}

	@Override
	public Travels removeTravels(Integer id) throws TravelsException {
		
		Travels trav=tDao.findById(id)
				.orElseThrow(()->new TravelsException("Travels not exists.."));
		
		tDao.delete(trav);
		return trav;
		
	}

	@Override
	public Travels searchTravels(Integer id) throws TravelsException {
		Travels trav=tDao.findById(id)
				.orElseThrow(()->new TravelsException("Travels not exists.."));
		return trav;
	}

	@Override
	public List<Travels> viewTravels() throws TravelsException {
		List<Travels> list=tDao.findAll();
		
		if(list.size()==0)
		{
			throw new TravelsException("Travels not found..");
		}
		
		return list;
		
	}



}
