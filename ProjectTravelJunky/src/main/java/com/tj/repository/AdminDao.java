package com.tj.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tj.model.Admin;

@Repository
public interface AdminDao extends JpaRepository<Admin, Integer> {
	
	public Admin findByMobile(String mobile);
	
}

