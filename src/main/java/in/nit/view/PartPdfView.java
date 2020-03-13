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

import in.nit.model.Part;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		 //download file
		response.addHeader("Content-Disposition","attachment;filename=part.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO PART");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		//creating table with no of columns
		PdfPTable t=new PdfPTable(10);
		t.addCell("ID");t.addCell("CODE");t.addCell("WIDTH");
		t.addCell("LENGTH");t.addCell("HEIGHT");t.addCell("BASE CURRENCY");
		t.addCell("UOM MODEL");t.addCell("ORDER CODE(SALE)");
		t.addCell("ORDER CODE(PURCHASE)");t.addCell("DESCRIPTION");
		//adding data to table
		for(Part part:list) {
			t.addCell(part.getPartId().toString());
			t.addCell(part.getPartCode());
			t.addCell(part.getWidth().toString());
			t.addCell(part.getHeight().toString());
			t.addCell(part.getLength().toString());
			t.addCell(part.getBaseCurrency());
			t.addCell(part.getUomOb().getUomModel());
			t.addCell(part.getOrdSaleOb().getOrdCode());
			t.addCell(part.getOrdPurOb().getOrdCode());
			t.addCell(part.getDesc());
			
		}
		
		//add element to document
		document.add(t);
		//print date and time
		document.add(new Paragraph(new  Date().toString()));
	}

}
