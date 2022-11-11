package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.Booking;

public interface BookingDAO extends JpaRepository<Booking, Integer>{

}
