package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Part;
import in.nit.service.IPartService;
import in.nit.view.PartExcelView;
import in.nit.view.PartPdfView;
@Controller
@RequestMapping("/part")
public class PartController {
	@Autowired
	private IPartService service;
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("part",new Part());
		return "PartRegister";
	}
	@RequestMapping(value="/save",method=POST)
	public String savePart(@ModelAttribute Part  part,Model model) {
		Integer id=service.savePart(part);
		String message="Part '"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("part",new Part());
		return "PartRegister";
	}
	@RequestMapping("/all")
	public String getAllPart(Model model){
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}
	@RequestMapping("/delete")
	public String deletePart(@RequestParam("prtid")Integer id,Model model) {
		service.deletePart(id);
		String message="Part '"+id+"' deleted";
		model.addAttribute("message",message);
		model.addAttribute("opt","DEL");
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("prtid")Integer id,Model model) {
		Part part=service.getOnePart(id);
		model.addAttribute("part",part);
		return "PartEdit";
	}
	@RequestMapping(value="/update",method=POST)
	public String updatePart(@ModelAttribute Part part,Model model) {
		service.updatePart(part);
		String message="Part '"+part.getPartId()+"' updated";
		model.addAttribute("message",message);
		List<Part> list=service.getAllParts();
		model.addAttribute("list",list);
		return "PartData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("prtid")Integer id,Model model) {
       Part part=service.getOnePart(id);
		model.addAttribute("part",part);
		return "PartView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="prtid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PartExcelView());
		//fetching data from DB
		if(id==null) {
		List<Part> list=service.getAllParts();
		return m.addObject("list",list);	
	}
		else {
			List<Part> list=List.of(service.getOnePart(id));
			return m.addObject("list",list);
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="prtid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PartPdfView());
		if(id==null) {
		//fetching data from DB	
		  List<Part> list=service.getAllParts();
		  return  m.addObject("list",list);	 

	}
		else {
			Part part=service.getOnePart(id);
			return m.addObject("list", List.of(part));
		}
	}

}
