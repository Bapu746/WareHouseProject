package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Uom;
import in.nit.service.IUomService;
import in.nit.utils.UomUtils;
import in.nit.view.UomExcelView;
import in.nit.view.UomPdfView;;
@Controller
@RequestMapping("/uom")
public class UomController {
	@Autowired
	private IUomService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private UomUtils util;
	@RequestMapping("/register")
	public String showUomRegPage(Model model) {
		model.addAttribute("uom",new Uom());
		return "UomRegister";
	}
	@RequestMapping(value="/save" ,method=POST)
	public String saveUom(@ModelAttribute Uom ob,Model model) {
		Integer id=service.savaUom(ob);
		String message="Uom '"+id+"' saved";
		model.addAttribute("message",message);
		return "UomRegister";
	}
	@RequestMapping("/all")
	public String getAllUoms(Model model) {
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list", list);
		return "UomData";
	}
	@RequestMapping("/delete")
	public String deleteUom(@RequestParam("umid")Integer id,Model model){
		service.deleteUom(id);
	    List<Uom> list=service.getAllUoms();
	    model.addAttribute("list",list);
		return "UomData";
		}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("umid")Integer id,Model model) {
		Uom ob=service.getOneUom(id);
		model.addAttribute("uom", ob);
		return "UomEdit";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("umid")Integer id,Model model) {
		Uom ob=service.getOneUom(id);
		model.addAttribute("ob",ob);
		return "UomView";
	}
	@RequestMapping(value="/update",method=POST)
	public String updateUom(@ModelAttribute Uom uom,Model model) {
		service.updateUom(uom);
		String message="UOM '"+uom.getUomId()+"' updated";
		model.addAttribute("message", message);
		List<Uom> list=service.getAllUoms();
		model.addAttribute("list",list);

		return "UomData";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="uid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomExcelView());
		//fetching data from DB
		if(id==null) {
		List<Uom> list=service.getAllUoms();
		m.addObject("list",list);
		return m;
		}
		else {
			m.addObject("list",List.of(service.getOneUom(id)));
			return m;
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="uid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new UomPdfView());
		if(id==null) {
		//fetching data from DB	
		  List<Uom> list=service.getAllUoms();
		  return  m.addObject("list",list);	 

	}
		else {
			Uom um=service.getOneUom(id);
			return m.addObject("list", List.of(um));
		}
	}
	@RequestMapping("/chart")
	public String showChart() {
		String path=context.getRealPath("/");
		System.out.println( path);
	   List<Object[]> data=	service.getOneUomTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "UomChart";
	}
}
