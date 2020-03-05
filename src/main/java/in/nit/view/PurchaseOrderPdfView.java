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

import in.nit.model.PurchaseOrder;

public class PurchaseOrderPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //download file
		response.addHeader("Content-Disposition","attachment;filename=puchaseOrder.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO PURCHASE ORDER");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		//creating table with no of columns
		PdfPTable t=new PdfPTable(6);
		t.addCell("ID");t.addCell("CODE");
		t.addCell("REF. NUM");t.addCell("QUALITY CHECK");
		t.addCell("DEF. STATUS");t.addCell("DESCRIPTION");
		//adding data to table
		for(PurchaseOrder ps:list) {
			t.addCell(ps.getOrdId().toString());
			t.addCell(ps.getOrdCode());
			t.addCell(ps.getRefNum());
			t.addCell(ps.getQualityCheck());
			t.addCell(ps.getDefStatus());
			t.addCell(ps.getDesc());
		}
		
		//add element to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new  Date().toString()));
	}

}
