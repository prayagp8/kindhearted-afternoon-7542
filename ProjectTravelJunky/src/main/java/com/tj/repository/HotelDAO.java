package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tj.model.Hotel;

@Repository
public interface HotelDAO extends JpaRepository<Hotel, Integer>{

}
