package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.Bus;

public interface BusDao extends JpaRepository<Bus, Integer> {

}
