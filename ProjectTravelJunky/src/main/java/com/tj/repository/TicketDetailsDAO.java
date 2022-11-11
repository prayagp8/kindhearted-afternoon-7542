package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.TicketDetails;

public interface TicketDetailsDAO extends JpaRepository<TicketDetails, Integer>{

}
