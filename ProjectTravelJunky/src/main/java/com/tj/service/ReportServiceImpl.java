package com.tj.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tj.exception.AdminException;
import com.tj.exception.ReportException;
import com.tj.model.Admin;
import com.tj.model.Report;
import com.tj.repository.AdminDao;
import com.tj.repository.ReportDao;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;

	@Override
	public Report addReport(Report report) throws ReportException {
		Report report2 = reportDao.save(report);
		if (report2 == null) {
			throw new ReportException("Report can not be added.");
		}
		return report2;
	}

	@Override
	public Report deleteReport(Integer reportId) throws ReportException {
		Optional<Report> opt = reportDao.findById(reportId);
		if (opt == null) {
			throw new ReportException("Report can not be deleted.");
		}
		Report report = opt.get();
		reportDao.delete(report);
		return report;
	}

	@Override
	public Report findByReportId(Integer reportId) throws ReportException {
		Optional<Report> opt = reportDao.findById(reportId);
		if (opt == null) {
			throw new ReportException("Report does not exists with Report Id : " + reportId);
		}
		return opt.get();
	}

	@Override
	public List<Report> viewAllReports() throws ReportException {
		List<Report> reports = reportDao.findAll();
		if (reports.isEmpty()) {
			throw new ReportException("No report exists.");
		}
		return reports;
	}	

}
