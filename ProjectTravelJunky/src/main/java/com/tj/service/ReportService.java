package com.tj.service;

import java.util.List;

import com.tj.exception.AdminException;
import com.tj.exception.ReportException;
import com.tj.model.Report;

public interface ReportService {

	public Report addReport(Report report) throws ReportException;

	public Report deleteReport(Integer reportId) throws ReportException;

	public Report findByReportId(Integer reportId) throws ReportException;

	public List<Report> viewAllReports() throws ReportException;
		
}
