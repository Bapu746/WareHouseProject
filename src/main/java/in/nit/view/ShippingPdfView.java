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

import in.nit.model.Shipping;

public class ShippingPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Shipping.pdf");
		//create element
		Paragraph p=new Paragraph("SHIPPING DATA");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<Shipping> list=(List<Shipping>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(8);
		t.addCell("ID"); t.addCell("CODE");
		t.addCell("REF NUM"); t.addCell("CONTACT DETAIL");
		t.addCell("SALE CODE"); t.addCell("BILL ADDRESS");
		t.addCell("SHIPPING ADDRESS");t.addCell("DESCRIPTION");
		for(Shipping om:list) {
			t.addCell(om.getShpId().toString());
			t.addCell(om.getShpCode());
			t.addCell(om.getShpRefNum());
			t.addCell(om.getShpContDetails());
			t.addCell(om.getShpSaleCode());
			t.addCell(om.getShpBillAddrs());
			t.addCell(om.getShpShipAddrs());
			t.addCell(om.getShpDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}
}

