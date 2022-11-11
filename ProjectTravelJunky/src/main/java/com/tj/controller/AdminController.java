package com.tj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tj.exception.ReportException;
import com.tj.model.Report;
import com.tj.service.ReportService;

@RestController
public class AdminController {

	@Autowired
	private ReportService reportService;

	@GetMapping("/admin/reports")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}

}
