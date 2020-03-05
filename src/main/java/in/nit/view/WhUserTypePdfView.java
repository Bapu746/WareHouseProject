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

import in.nit.model.WhUserType;

public class WhUserTypePdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
           //download file
		response.addHeader("Content-Disposition","attachment;filename=whusertype.pdf");
		//create element
		Paragraph p=new Paragraph("WELCOME TO WHUSER TYPE");
		//add element to document
		document.add(p);
		//read data from model
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		//creating table with no of columns
		PdfPTable t=new PdfPTable(9);
		t.addCell("ID");t.addCell("TYPE");
		t.addCell("CODE");t.addCell("USER FOR");
		t.addCell("EMAIL");t.addCell("CONTACT");
		t.addCell("ID TYPE");t.addCell("IF OTHER");
		t.addCell("ID NUM");
		//adding data to table
		for(WhUserType wh: list) {
			t.addCell(wh.getUserId().toString());
			t.addCell(wh.getUserType());
			t.addCell(wh.getUserCode());
			t.addCell(wh.getUserFor());
			t.addCell(wh.getUserEmail());
			t.addCell(wh.getUserContact());
			t.addCell(wh.getUserIdType());
			t.addCell(wh.getIfOther());
			t.addCell(wh.getUserIdNum());
			
		}
		
		//add element to document
		document.add(t);
		//print date and time
	}
       



}
