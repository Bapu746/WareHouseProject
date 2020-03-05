package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.SaleOrder;

public class SaleOrderExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//filename
		response.addHeader("Content-Disposition","attachment;filename=saleorder.xlsx");
		Sheet s=workbook.createSheet("saleorder");
		//construct row-0
		setHeader(s);
		//read Model data
		@SuppressWarnings("unchecked")
		List<SaleOrder> list=(List<SaleOrder>) model.get("list");
		setBody(list,s);
	}

	private void setBody(List<SaleOrder> list, Sheet s) {
		int count=1;
		for(SaleOrder sale:list)		{
			Row r=	 s.createRow(count++);
			r.createCell(0).setCellValue(sale.getOrdId());
			r.createCell(1).setCellValue(sale.getOrdCode());
			r.createCell(2).setCellValue(sale.getRefNum());
			r.createCell(3).setCellValue(sale.getStockMode());
			r.createCell(4).setCellValue(sale.getStockSource());
			r.createCell(5).setCellValue(sale.getDefStatus());
			r.createCell(6).setCellValue(sale.getDesc());
		} 

	}

	private void setHeader(Sheet s) {
		Row r=   s.createRow(0);
		r.createCell(0).setCellValue("ID");
		r.createCell(1).setCellValue("CODE");
		r.createCell(2).setCellValue("REF. NUM");
		r.createCell(3).setCellValue("STOCK MODE");
		r.createCell(4).setCellValue("STOCK SOURCE");	
		r.createCell(5).setCellValue("DEF. STATUS");	
		r.createCell(6).setCellValue("DESCRITPTION");	

	}

}
