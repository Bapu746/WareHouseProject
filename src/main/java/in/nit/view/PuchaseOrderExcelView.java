package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.PurchaseOrder;

public class PuchaseOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition","attachment;filename=purchaseorder.xlsx");
		Sheet s=workbook.createSheet("purchase order");
		//construct row-0
		setHeader(s);
		//read Model data
		@SuppressWarnings("unchecked")
		List<PurchaseOrder> list=(List<PurchaseOrder>) model.get("list");
		setBody(list,s);
	}

	private void setBody(List<PurchaseOrder> list, Sheet s) {
		int count=1;
		for(PurchaseOrder ps:list)		{
			Row r=	 s.createRow(count++);
			r.createCell(0).setCellValue(ps.getOrdId());
			r.createCell(1).setCellValue(ps.getOrdCode());
			r.createCell(2).setCellValue(ps.getRefNum());
			r.createCell(3).setCellValue(ps.getQualityCheck());
			r.createCell(4).setCellValue(ps.getDefStatus());
			r.createCell(5).setCellValue(ps.getDesc());
		} 

	}

	private void setHeader(Sheet s) {
		Row r=   s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("REF. NUM");
		r.createCell(3).setCellValue("QUALITY CHECK");	
		r.createCell(4).setCellValue("DEF. STATUS");	
		r.createCell(5).setCellValue("DESCRIPTION");	

	}

}
