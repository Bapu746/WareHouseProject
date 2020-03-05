package in.nit.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.WhUserType;
import in.nit.service.IWhUserTypeService;
import in.nit.utils.WhUserUtils;
import in.nit.view.WhUserTypeExcelView;
import in.nit.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private WhUserUtils util;
	
	@RequestMapping("/register")
	public String whUserReg(Model model) {
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveWHUserType(@ModelAttribute WhUserType wHUserType,Model model) {
		Integer id=service.saveWhUserType(wHUserType);
		String message="WhUser type '"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("whUserType", new WhUserType());
		return "WhUserTypeReg";
	}
	@RequestMapping("/all")
	public String getAllOrderMethod(Model model) {
		List<WhUserType> list=service.getAllWhUserTypes();		
		model.addAttribute("list",list);
		System.out.println(list);
		return "WhUserTypeData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("uid")Integer id,Model model) {
		service.deleteWhUserType(id);
		String message="WhUser type  '"+id+"' deleted";
		model.addAttribute("message",message);
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list",list);
		return "WhUserTypeData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("uid")Integer id,Model model) {
		WhUserType ob=service.getOneWhUserType(id);
		model.addAttribute("whUserType", ob);
		return "WhUserTypeEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateWHUserType(@ModelAttribute WhUserType wHUserType,Model model) {
		service.updateWhUserType(wHUserType);
		String message="WhUser type '"+wHUserType.getUserId()+"'updated";
		model.addAttribute("message", message);
		List<WhUserType> list=service.getAllWhUserTypes();
		model.addAttribute("list", list);
		return "WhUserTypeData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("uid")Integer id,Model model) {
		WhUserType wh=service.getOneWhUserType(id);
		model.addAttribute("ob",wh);
		return "WhUserTypeView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="uid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypeExcelView());
		//fetching data from DB
		if(id==null) {
		List<WhUserType> list=service.getAllWhUserTypes();
		m.addObject("list",list);
		return m;
	}
		else {
			return m.addObject("list",List.of(service.getOneWhUserType(id)));
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new WhUserTypePdfView());
		if(id==null) {
		//fetching data from DB	
		  List<WhUserType> list=service.getAllWhUserTypes();
		  return  m.addObject("list",list);	 

	}
		else {		
			return m.addObject("list", List.of(service.getOneWhUserType(id)));
		}
	}
	@RequestMapping("/chart")
	public String showChart() {
		String path=context.getRealPath("/");
		System.out.println( path);
	   List<Object[]> data=	service.getWhUserIdTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "WhUserChart";
	}

}
