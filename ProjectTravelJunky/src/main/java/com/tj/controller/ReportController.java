package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.AdminException;
import com.tj.exception.ReportException;
import com.tj.model.Report;
import com.tj.service.ReportService;

@RestController
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping("/reports")
	public ResponseEntity<Report> addReport(@RequestBody Report report) throws ReportException {
		return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/reports/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable Integer reportId) throws ReportException {
		return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
	}

	@GetMapping("/reports/{reportId}")
	public ResponseEntity<Report> findByReportId(@PathVariable Integer reportId) throws ReportException {
		return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
	}

	@GetMapping("/reports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}

	@GetMapping("/reportsbyadmin/{id}")
	public ResponseEntity<List<Report>> getReportByAdminId(@PathVariable("id") Integer aid)
			throws AdminException, ReportException {

		return new ResponseEntity<List<Report>>(reportService.viewReportByAdminId(aid), HttpStatus.OK);

	}

}
