package com.tj.service;

import java.util.List;

import com.tj.exception.AdminException;
import com.tj.exception.ReportException;
import com.tj.model.Admin;
import com.tj.model.Report;

public interface AdminService {

	public List<Report> viewAllReports() throws ReportException;
	
	public Admin addAdmin(Admin admin) throws AdminException;
	
}
