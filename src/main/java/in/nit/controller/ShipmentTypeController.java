package in.nit.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
import in.nit.utils.ShipmentTypeUtils;
import in.nit.view.ShipmentTypeExcelView;
import in.nit.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipment")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private ShipmentTypeUtils util;

	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}

	@RequestMapping(value="/save",method=POST)
	public String saveShipment(@ModelAttribute ShipmentType shipmentType,Model model) {
		Integer id=service.saveShipmentType(shipmentType);
		String message="Shipment type '"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("shipmentType",new ShipmentType());
		return "ShipmentTypeRegister";
	}
	@RequestMapping("/all")
	public String getAllShipmentTypes(Model model){
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("sid")Integer id,Model model) {
		service.deleteShipmentType(id);
		String message="Shipment '"+id+"' deleted";
		model.addAttribute("message",message);
		model.addAttribute("opr","DEL");
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id,Model model) {
		ShipmentType sh=service.getOneShipmentType(id);
		model.addAttribute("shipmentType",sh);
		return "ShipmentTypeEdit";
	}
	@RequestMapping(value="/update",method=POST)
	public String updateShipmentType(@ModelAttribute ShipmentType shipmentType,Model model) {
		service.updateShipmentType(shipmentType);
		String message="Shipment Type '"+shipmentType.getShipId()+"' updated";
		model.addAttribute("message",message);
		List<ShipmentType> list=service.getAllShipmentTypes();
		model.addAttribute("list",list);
		return "ShipmentTypeData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("sid")Integer id,Model model) {
		ShipmentType ob=service.getOneShipmentType(id);
		model.addAttribute("ob",ob);
		return "ShipmentTypeView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="sid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypeExcelView());
		//fetching data from DB
		if(id==null) {
		List<ShipmentType> list=service.getAllShipmentTypes();
		return m.addObject("list",list);	
	}
		else {
			List<ShipmentType> list=List.of(service.getOneShipmentType(id));
			System.out.println(list);
			return m.addObject("list",list);
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="sid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new ShipmentTypePdfView());
		if(id==null) {
		//fetching data from DB	
		  List<ShipmentType> list=service.getAllShipmentTypes();
		  return  m.addObject("list",list);	 

	}
		else {
			ShipmentType st=service.getOneShipmentType(id);
			return m.addObject("list", List.of(st));
		}
	}
	@RequestMapping("/chart")
	public String showChart() {
		String path=context.getRealPath("/");
		System.out.println( path);
	   List<Object[]> data=	service.getOneShipmentModeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "ShipmentTypeChart";
	}
}


