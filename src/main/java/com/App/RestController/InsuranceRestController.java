package com.App.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.App.Reports.ExcelReportGenerator;
import com.App.Reports.PdfReportGenerator;
import com.App.bindings.request.SearchRequest;
import com.App.bindings.response.PlanResponse;
import com.App.service.InsurancePlanService;

@RestController
public class InsuranceRestController {
	@Autowired
	private InsurancePlanService service;
	
	@GetMapping("/pdf")
	public void generatePdf(HttpServletResponse response) throws IOException
	{
		 response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans_" + currentDateTime + ".pdf";
	        response.setHeader(headerKey, headerValue);
		
			List<PlanResponse> searchPlans = service.searchPlans(null);
			PdfReportGenerator generator = new PdfReportGenerator();
			generator.exportPdf(searchPlans, response);
	}
	
	@GetMapping("/excel")
	public void generateExcel(HttpServletResponse response) throws IOException
	{
		 response.setContentType("application/octet-stream");
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	         
	        String headerKey = "Content-Disposition";
	        String headerValue = "attachment; filename=plans_" + currentDateTime + ".xlsx";
	        response.setHeader(headerKey, headerValue);
		
			List<PlanResponse> searchPlans = service.searchPlans(null);
			ExcelReportGenerator generator = new ExcelReportGenerator();
			generator.export(searchPlans, response);
	}
	
	@PostMapping("/plans")
	public ResponseEntity<List<PlanResponse>> getPlans(
			@RequestBody SearchRequest request)
	{
		List<PlanResponse> searchPlans = service.searchPlans(request);
		return new ResponseEntity<List<PlanResponse>>(searchPlans, HttpStatus.OK); 
	}
	
	@GetMapping("/plannames")
	public ResponseEntity<List<String>> getPlanNames()
	{
		List<String> planNames = service.getUniquePlanNames();
		return ResponseEntity.ok(planNames);
	}
	
	@GetMapping("/planstatus")
	public ResponseEntity<List<String>> getPlanStatus()
	{
		List<String> planStatus = service.getUniquePlanStatus();
		return ResponseEntity.ok(planStatus);
	}
}
