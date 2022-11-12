package com.tj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.AdminException;
import com.tj.exception.ReportException;
import com.tj.model.Admin;
import com.tj.model.Report;
import com.tj.repository.AdminDao;
import com.tj.repository.ReportDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private AdminDao aDao;

	@Override
	public List<Report> viewAllReports() throws ReportException {
		List<Report> reports = reportDao.findAll();
		if (reports.isEmpty()) {
			throw new ReportException("No report exists.");
		}
		return reports;
	}

	@Override
	public Admin addAdmin(Admin admin) throws AdminException {
		
		if(admin.getMobile().equals("12345")&& admin.getPassword().equals("12345")) {
			
			return aDao.save(admin);
		}else {
			throw new AdminException("invalid admin credentials!!!");
		}
		

	}

}
