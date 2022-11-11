package com.tj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tj.model.Package;

public interface PackageDAO extends JpaRepository<Package, Integer>{

}
