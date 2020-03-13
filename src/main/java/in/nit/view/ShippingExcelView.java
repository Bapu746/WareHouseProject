package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Shipping;



public class ShippingExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//change file name
			response.addHeader("Content-Disposition", "attachment;filename=Shipping.xlsx");
			Sheet s=workbook.createSheet("Shipping");
			//construct row(0)
			setHead(s);
			//read model Data
			@SuppressWarnings("unchecked")
			List<Shipping> list=(List<Shipping>) model.get("list");
			setBody(list,s);
		}


		private void setHead(Sheet s) {
			Row r=s.createRow(0);
			r.createCell(0).setCellValue("ID");
			r.createCell(1).setCellValue("CODE");
			r.createCell(2).setCellValue("REF NUM");
			r.createCell(3).setCellValue("CONTACT DETAIL");
			r.createCell(4).setCellValue("SALE CODE");
			r.createCell(5).setCellValue("BILL ADDRESS");
			r.createCell(6).setCellValue("SHIPPING ADDRESS");
			r.createCell(7).setCellValue("DESCRIPTION");
		}
		private void setBody(List<Shipping> list, Sheet s) {
			int count=1;
			for(Shipping om:list) {
				Row r=s.createRow(count++);
				r.createCell(0).setCellValue(om.getShpId());
				r.createCell(1).setCellValue(om.getShpCode());
				r.createCell(2).setCellValue(om.getShpRefNum());
				r.createCell(3).setCellValue(om.getShpContDetails());
				r.createCell(4).setCellValue(om.getShpSaleCode());
				r.createCell(5).setCellValue(om.getShpBillAddrs());
				r.createCell(6).setCellValue(om.getShpShipAddrs());
				r.createCell(7).setCellValue(om.getShpDesc());
			}
		}
}