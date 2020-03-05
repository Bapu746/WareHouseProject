package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition","attachment;filename=whuser.xlsx");
		Sheet s=workbook.createSheet("Whuser");
		//construct row-0
		setHeader(s);
		//read Model data
		@SuppressWarnings("unchecked")
		List<WhUserType> list=(List<WhUserType>) model.get("list");
		System.out.println(list);
		setBody(list,s);
	}

	private void setBody(List<WhUserType> list, Sheet s) {
		int count=1;
		for(WhUserType wh:list)		{
			Row r=	 s.createRow(count++);
			r.createCell(0).setCellValue(wh.getUserId());
			r.createCell(1).setCellValue(wh.getUserType());
			r.createCell(2).setCellValue(wh.getUserCode());
			r.createCell(3).setCellValue(wh.getUserFor());
			r.createCell(4).setCellValue(wh.getUserEmail());
			r.createCell(5).setCellValue(wh.getUserContact());
			r.createCell(6).setCellValue(wh.getUserIdType());
			r.createCell(7).setCellValue(wh.getIfOther());
			r.createCell(8).setCellValue(wh.getUserIdNum());
		} 
	}

	private void setHeader(Sheet s) {
		Row r=   s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("TYPE");
		r.createCell(2).setCellValue("CODE");
		r.createCell(3).setCellValue("USER FOR");
		r.createCell(4).setCellValue("EMAIL");
		r.createCell(5).setCellValue("CONTACT");
		r.createCell(6).setCellValue("ID TYPE");
		r.createCell(7).setCellValue("IF OTHER");
		r.createCell(8).setCellValue("ID NUMBER");	
		
	}

}
