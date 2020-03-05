package in.nit.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class WhUserUtils {


	public void generatePie(String path,List<Object[]> data) {
		//1.create dataset
		DefaultPieDataset dataset=new DefaultPieDataset();
		for(Object[] arr:data) {
			dataset.setValue(arr[0].toString(), Double.valueOf(arr[1].toString()));
		}
		//2.create JFree
		JFreeChart jFree=ChartFactory.createPieChart3D("WhUser", dataset, true, true, true);
		//3.Save Image as Jpeg
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/whuserpie.jpg"), jFree, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void generateBar(String path,List<Object[]> list) {
		//1.create dataset
		DefaultCategoryDataset dataset=new DefaultCategoryDataset();
		for(Object[] arr:list) {
			dataset.setValue(Double.valueOf(arr[1].toString()), arr[0].toString(),"");
		}
		//2.create JFreeObject
		JFreeChart jFree=ChartFactory.createBarChart("Uom","Type", "Count", dataset);
		//3.save Image
		try {
			ChartUtils.saveChartAsJPEG(new File(path+"/resources/images/whuserbar.jpg"), jFree, 400, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
