package com.App.Reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.App.bindings.response.PlanResponse;

public class ExcelReportGenerator {
	public void export(List<PlanResponse> responses , HttpServletResponse servletResponse ) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet Sheet = workbook.createSheet("Plans");
		XSSFRow headerRow = Sheet.createRow(0);
		
		XSSFCell createCell0 = headerRow.createCell(0);
		createCell0.setCellValue("Plan_ID");
		
		XSSFCell createCell1 = headerRow.createCell(1);
		createCell1.setCellValue("Plan_Holder_Name");
		
		XSSFCell createCell2 = headerRow.createCell(2);
		createCell2.setCellValue("Plan_Holder_SSN");
		
		XSSFCell createCell3 = headerRow.createCell(3);
		createCell3.setCellValue("Plan_Name");
		
		XSSFCell createCell4 = headerRow.createCell(4);
		createCell4.setCellValue("Plan_Status");
		
		for(int i=0; i<responses.size(); i++)
		{
			PlanResponse planResponse = responses.get(i);
			XSSFRow dataRow = Sheet.createRow(i+1);
			
			XSSFCell createCell00 = dataRow.createCell(0);
			createCell00.setCellValue(planResponse.getPlanId());
			
			 dataRow.createCell(1).setCellValue(planResponse.getPlanName());
			
			XSSFCell createCell02 = dataRow.createCell(2);
			createCell02.setCellValue(planResponse.getPlanHolderSSN());
			
			XSSFCell createCell03 = dataRow.createCell(3);
			createCell03.setCellValue(planResponse.getPlanName());
			
			XSSFCell createCell04 = dataRow.createCell(4);
			createCell04.setCellValue(planResponse.getPlanStatus());
		}
		ServletOutputStream outputStream = servletResponse.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();
	}
}
