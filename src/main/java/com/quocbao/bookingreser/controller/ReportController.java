package com.quocbao.bookingreser.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quocbao.bookingreser.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	ReportService reportService;

	@GetMapping("/reportCompany/{companyId}")
	public ResponseEntity<Object> reportCompany(@PathVariable Long companyId, @RequestParam("start") LocalDate start,
			@RequestParam("end") LocalDate end) {
		return new ResponseEntity<>(reportService.reportByTime(start, end, "company", companyId), HttpStatus.OK);
	}

	@GetMapping("/reportEmployee/{employeeId}")
	public ResponseEntity<Object> reportEmployee(@PathVariable Long employeeId, @RequestParam("start") LocalDate start,
			@RequestParam("end") LocalDate end) {
		return new ResponseEntity<>(reportService.reportByTime(start, end, "employee", employeeId), HttpStatus.OK);
	}

	@GetMapping("/reportFood/{foodId}")
	public ResponseEntity<Object> reportFood(@PathVariable Long foodId, @RequestParam("start") LocalDate start,
			@RequestParam("end") LocalDate end) {
		return new ResponseEntity<>(reportService.reportByTime(start, end, "food", foodId), HttpStatus.OK);
	}

	@GetMapping("/reportMaterial/{materialId}")
	public ResponseEntity<Object> reportMaterial(@PathVariable Long materialId, @RequestParam("start") LocalDate start,
			@RequestParam("end") LocalDate end) {
		return new ResponseEntity<>(reportService.reportByTime(start, end, "material", materialId), HttpStatus.OK);
	}
}
