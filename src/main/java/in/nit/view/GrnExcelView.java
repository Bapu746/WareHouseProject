package in.nit.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.nit.model.Grn;

public class GrnExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
			//change file name
			response.addHeader("Content-Disposition", "attachment;filename=Grn.xlsx");
			Sheet s=workbook.createSheet("Grn");
			//construct row(0)
			setHead(s);
			//read model Data
			@SuppressWarnings("unchecked")
			List<Grn> list=(List<Grn>) model.get("list");
			setBody(list,s);
		}


		private void setHead(Sheet s) {
			Row r=s.createRow(0);
			r.createCell(0).setCellValue("ID");
			r.createCell(1).setCellValue("CODE");
			r.createCell(2).setCellValue("TYPE");
			r.createCell(4).setCellValue("DESCRIPTION");
		}
		private void setBody(List<Grn> list, Sheet s) {
			int count=1;
			for(Grn om:list) {
				Row r=s.createRow(count++);
				r.createCell(0).setCellValue(om.getGrnId());
				r.createCell(1).setCellValue(om.getGrnCode());
				r.createCell(2).setCellValue(om.getGrnType());
				r.createCell(3).setCellValue(om.getGrnDesc());
			}
		}

}

