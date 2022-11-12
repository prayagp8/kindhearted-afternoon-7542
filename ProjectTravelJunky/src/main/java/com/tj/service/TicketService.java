package com.tj.service;

import java.util.List;

import com.tj.exception.PaymentException;
import com.tj.exception.TicketException;
import com.tj.model.PaymentDetails;
import com.tj.model.TicketDetails;

public interface TicketService {
	
	public TicketDetails addticket(TicketDetails ticket, Integer paymentId) throws TicketException,PaymentException;
	
	public List<TicketDetails> viewAllTicket() throws TicketException;
	
	public TicketDetails deleteTicket(Integer ticketId) throws TicketException;

}
