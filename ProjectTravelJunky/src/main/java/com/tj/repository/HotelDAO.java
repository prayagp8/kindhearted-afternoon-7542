package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.Hotel;

public interface HotelDAO extends JpaRepository<Hotel, Integer>{

}
