package com.tj.service;

import java.util.List;

import com.tj.exception.TravelsException;
import com.tj.model.Travels;


public interface TravelsService {

	public Travels addTravels(Travels travels) throws TravelsException;
	public Travels updateTravels(Travels travels) throws TravelsException;
	public Travels removeTravels(Integer id) throws TravelsException;
	public Travels searchTravels(Integer id) throws TravelsException;
	public List<Travels> viewTravels() throws TravelsException;
}
