package com.tj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BookingException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.model.Booking;
import com.tj.model.Hotel;
import com.tj.model.Package;
import com.tj.model.PaymentDetails;
import com.tj.repository.BookingDAO;
import com.tj.repository.HotelDAO;
import com.tj.repository.PackageDAO;
import com.tj.repository.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PackageDAO pDao;
	
	@Autowired
	private PaymentDao paymentDao;
	
	@Autowired
	private BookingDAO bDao;
	
	@Autowired
	private HotelDAO hDao;
	
	@Override
	public PaymentDetails payment(PaymentDetails paymentDetail, Integer packageId, Integer bookingId, Integer hotelId) throws PackageException, BookingException, HotelException{
	 Package p  = pDao.findById(packageId).orElseThrow(()->new PackageException("package not booked!!"));
	 Booking b =  bDao.findById(bookingId).orElseThrow(()->new BookingException("booking doesn't exsist !!"));
	 Hotel h =  hDao.findById(hotelId).orElseThrow(()->new HotelException("hotel not booked !!"));
	 
	 
	 paymentDetail.setPackages(p);
	 p.setPayment(paymentDetail);
	 

	 
	 return paymentDao.save(paymentDetail);
	}

	@Override
	public List<PaymentDetails> veiwAllPayments() throws PaymentException {
		List<PaymentDetails> pList = paymentDao.findAll();
		if(pList.size()==0) {
			throw new PaymentException("No payment record is available!!");
		}else {
			return pList;
		}
		
	}
	

}
