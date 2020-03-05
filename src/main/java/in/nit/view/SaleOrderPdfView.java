package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.SaleOrder;

public class SaleOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //download file
		response.addHeader("Content-Disposition","attachment;filename=saleorder.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO SALE ORDER");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		//creating table with no of columns
		PdfPTable t=new PdfPTable(7);
		t.addCell("ID");t.addCell("ORDER CODE");t.addCell("REF. NUM");
		t.addCell("STOCK MODE");t.addCell("STOCK SOURCE");t.addCell("DEF. STATUS");
		t.addCell("DESCRIPTION");
		//adding data to table
		for(SaleOrder sale:list) {
			t.addCell(sale.getOrdId().toString());
			t.addCell(sale.getOrdCode());
			t.addCell(sale.getRefNum());
			t.addCell(sale.getStockMode());
			t.addCell(sale.getStockSource());
			t.addCell(sale.getDefStatus());
			t.addCell(sale.getDesc());
			
		}
		
		//add element to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new  Date().toString()));
	}

}
