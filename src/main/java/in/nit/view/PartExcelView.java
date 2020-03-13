package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Part;

public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition","attachment;filename=part.xlsx");
		Sheet s=workbook.createSheet("part");
		//construct row-0
		setHeader(s);
		//read Model data
		@SuppressWarnings("unchecked")
		List<Part> list=(List<Part>) model.get("list");
		System.out.println(list);
		setBody(list,s);
	}

	private void setBody(List<Part> list, Sheet s) {
		int count=1;
		for(Part part:list)		{
			Row r=	 s.createRow(count++);
			r.createCell(0).setCellValue(part.getPartId());
			r.createCell(1).setCellValue(part.getPartCode());
			r.createCell(2).setCellValue(part.getWidth());
			r.createCell(3).setCellValue(part.getLength());
			r.createCell(4).setCellValue(part.getHeight());
			r.createCell(5).setCellValue(part.getBaseCurrency());
			r.createCell(6).setCellValue(part.getUomOb().getUomModel());
			r.createCell(7).setCellValue(part.getOrdSaleOb().getOrdCode());
			r.createCell(8).setCellValue(part.getOrdPurOb().getOrdCode());
			r.createCell(9).setCellValue(part.getDesc());
		} 

	}

	private void setHeader(Sheet s) {
		Row r=   s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("WIDTH");
		r.createCell(3).setCellValue("LENGTH");
		r.createCell(4).setCellValue("HEIGHT");	
		r.createCell(5).setCellValue("BASE CURRENCY");	
		r.createCell(6).setCellValue("UOM MODEL");	
		r.createCell(7).setCellValue("ORDER CODE(SALE)");	
		r.createCell(8).setCellValue("ORDER CODE(PURCHASE)");	
		r.createCell(9).setCellValue("DESCRITPTION");	

	}

}
