package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.OrderMethod;

public class OrderMethodPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
           //download file
		response.addHeader("Content-Disposition","attachment;filename=ordermethod.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO ORDER METHOD");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<OrderMethod> list=(List<OrderMethod>) model.get("list");
		//creating table with no of columns
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");t.addCell("MODE");
		t.addCell("CODE");t.addCell("TYPE");
		//adding data to table
		for(OrderMethod ob: list) {
			t.addCell(ob.getOrdId().toString());
			t.addCell(ob.getOrdMode());
			t.addCell(ob.getOrdCode());
			t.addCell(ob.getOrdType());
			
		}
		
		//add element to document
		document.add(t);
		//print date and time
	}
       



}
