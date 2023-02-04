package com.tj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.BookingException;
import com.tj.exception.BusException;
import com.tj.exception.HotelException;
import com.tj.exception.PackageException;
import com.tj.exception.PaymentException;
import com.tj.model.Booking;
import com.tj.model.Customer;
import com.tj.model.PaymentDetails;
import com.tj.model.Wallet;
import com.tj.repository.BookingDAO;
import com.tj.repository.PaymentDao;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	BookingDAO bookingDAO;
	
	@Autowired
	PaymentDao paymentDao;

	@Override
	public PaymentDetails payment(Integer bookingId)
			throws PackageException, PaymentException, BookingException, HotelException,BusException {
		Booking b = bookingDAO.findById(bookingId).orElseThrow(()->new BookingException("Invalid booking Id!!"));

		if(b.getBus()==null) {
			throw new BusException("bus not added in the booking add bus for package confirmation!");
		}
		if(b.getPackages()==null) {
			throw new PackageException("package is not selected please select package before any payment!");
		}

		b.setBookingAmt(b.getPackages().getNoOfDays()*b.getPackages().getHotel().getHotelPrice()+b.getBus().getFare());

		PaymentDetails pd = new PaymentDetails();
		pd.setAddress(b.getCustomer().getAddress());
		pd.setBooking(b);
		pd.setName(b.getCustomer().getName());
		pd.setTime(LocalDate.now());
		pd.setTotalAmount(b.getBookingAmt());
		if(pd.getBooking().getCustomer().getWallet().getWalletBalance()>pd.getBooking().getBookingAmt()) {
			b.setStatus("Booking confiremed!!");
			pd.setStatus("payment done!");

			pd.getBooking().getCustomer().getWallet()
			.setWalletBalance(pd.getBooking()
					.getCustomer().getWallet()
					.getWalletBalance()-pd.getBooking().getBookingAmt());
			
			PaymentDetails p =  paymentDao.save(pd);
			Wallet w = pd.getBooking().getCustomer().getWallet();
			
			return p;
		}else {
			throw new PaymentException("not sufficieant balance in user wallet!!");
		}





		
	}

	@Override
	public List<PaymentDetails> veiwAllPayments() throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

}
