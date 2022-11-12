package com.tj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.PaymentException;
import com.tj.exception.TicketException;
import com.tj.model.PaymentDetails;
import com.tj.model.TicketDetails;
import com.tj.repository.PaymentDao;
import com.tj.repository.TicketDetailsDAO;

import com.tj.model.Package;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	private PaymentDao pDao;
	
	@Autowired
	private TicketDetailsDAO tDao;

	@Override
	public TicketDetails addticket(TicketDetails ticket, Integer paymentId) throws TicketException, PaymentException {
		
		 PaymentDetails p = pDao.findById(paymentId).orElseThrow(()->new PaymentException("payment is not done!!"));
		 Package pack = p.getPackages();
		ticket.setPayment(p);
		pack.setTicketDetails(ticket);
		p.setTicket(ticket);
		
		
	
		
		return tDao.save(ticket);
	}

	@Override
	public List<TicketDetails> viewAllTicket() throws TicketException {
		 List<TicketDetails> tList = tDao.findAll();
		 
		 if(tList.size()==0) {
			 throw new TicketException("no ticked is booked!!");
		 }else {
			 return tList;
		 }
		
	}

	@Override
	public TicketDetails deleteTicket(Integer ticketId) throws TicketException {
		 TicketDetails t= tDao.findById(ticketId).orElseThrow(()->new TicketException("Incorrect ticket Id!!"));
		
		
		 t.setStatus("booking cancelled!!");
		 tDao.save(t);
		
		 return t;
		
	}

}
