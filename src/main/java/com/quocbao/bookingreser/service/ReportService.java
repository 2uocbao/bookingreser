package com.quocbao.bookingreser.service;

import java.time.LocalDate;

import com.quocbao.bookingreser.response.ReportResponse;

public interface ReportService {

	public ReportResponse reportByTime(LocalDate start, LocalDate end, String entity, Long id);
}
