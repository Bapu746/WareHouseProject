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

import in.nit.model.Grn;

public class GrnPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//download file
		response.addHeader("Content-Disposition", "attachment;filename=Grn.pdf");
		//create element
		Paragraph p=new Paragraph("Grn DATA");
		//add element to document
		document.add(p);
		//read data from list
		@SuppressWarnings("unchecked")
		List<Grn> list=(List<Grn>) model.get("list");
		//creating table element add no of column
		PdfPTable t=new PdfPTable(4);
		t.addCell("ID");
		t.addCell("CODE"); t.addCell("TYPE");
	    t.addCell("DESCRIPTION");
		for(Grn om:list) {
			t.addCell(om.getGrnId().toString());
			t.addCell(om.getGrnCode());
			t.addCell(om.getGrnType());
			t.addCell(om.getGrnDesc());
		}
		document.add(t);
		//print date and time
		document.add(new Paragraph(new Date().toString()));
	}
}
