package com.tj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tj.model.Travels;

@Repository
public interface TravelsDao extends JpaRepository<Travels, Integer>{
	
	public Optional<Travels> findById(Integer id);

}
