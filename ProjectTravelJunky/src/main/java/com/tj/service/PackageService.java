package com.tj.service;

import java.util.List;

import com.tj.exception.PackageException;
import com.tj.model.Package;

public interface PackageService {
	public Package addPackage(Package package1)throws PackageException;
	public Package deletePackage(Integer id)throws PackageException;
	public Package searchPackage(Integer id)throws PackageException;
	public List<Package> viewAllPackage()throws PackageException;
}
