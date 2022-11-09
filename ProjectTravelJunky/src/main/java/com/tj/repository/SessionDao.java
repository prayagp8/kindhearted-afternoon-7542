package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tj.model.currentUserSession;

@Repository
public interface SessionDao extends JpaRepository<currentUserSession, Integer> {


	public currentUserSession findByUuid(String uuid);
}
