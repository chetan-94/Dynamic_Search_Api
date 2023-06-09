package com.App.Reports;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.App.bindings.response.PlanResponse;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportGenerator {
	public void exportPdf(List<PlanResponse> plans , HttpServletResponse response) throws DocumentException, IOException
	{
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);
        Paragraph p = new Paragraph("List of Plans", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);
        document.add(p);
        
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
        table.setSpacingBefore(10);
        
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("Plan Id", font1));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan Name", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan Holder Name", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Holder SSN", font1));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Plan Status", font1));
        table.addCell(cell);     
        
        for(PlanResponse plan : plans)
        {
        	table.addCell(plan.getPlanId()+"");
        	table.addCell(plan.getPlanName());
        	table.addCell(plan.getPlanHolderName());
        	table.addCell(plan.getPlanHolderSSN()+"");
        	table.addCell(plan.getPlanStatus());
        }
        document.add(table);
        
        document.close();
	}
}
