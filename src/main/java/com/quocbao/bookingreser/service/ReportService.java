package com.quocbao.bookingreser.service;

import com.quocbao.bookingreser.response.ReportResponse;

public interface ReportService {

	public ReportResponse detailPort(Long id);
	
	public ReportResponse reportRevenue(Long companyId);
	
	public ReportResponse reportFood(Long foodId);
	
	public ReportResponse reportThreeMonths(Long id);
	
	public ReportResponse reportOneYear();
	
	public ReportResponse reportCustomerSlot(Long companyId);
	
	public ReportResponse reportWarehouse(Long companyId);
	
	public ReportResponse reportEmployeePoint(Long employeeId);
	
	public ReportResponse reportMaterial(Long materialId);
	
	public ReportResponse reportEmployeeRevenue(Long employeeId);
}
