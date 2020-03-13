package in.nit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.Arrays;
import java.util.List;

import in.nit.model.Grn;
import in.nit.service.IGrnService;
import in.nit.view.GrnExcelView;
import in.nit.view.GrnPdfView;

@Controller
@RequestMapping("/grn")
public class GrnController {
	@Autowired
	private IGrnService service;


	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("grn",new Grn());
		return "GrnRegisterPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOneGrn(@ModelAttribute Grn Grn,Model m) {
		Integer id=service.saveGrn(Grn);
		String msg="Grn "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("grn",new Grn());
		return "GrnRegisterPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllGrn(Model model) {
		List<Grn> list=service.getAllGrn();
		model.addAttribute("list",list);
		return "GrnData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deleteGrn(@RequestParam("gid")Integer id,Model m) {
		service.deleteGrn(id);
		String msg="GrnOrder "+id+" Deleted";
		m.addAttribute("msg", msg);

		List<Grn> list=service.getAllGrn();
		m.addAttribute("list",list);
		return "GrnData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("gid")Integer id,Model m) {
		Grn Grn=service.getOneGrn(id);
		m.addAttribute("grn",Grn);
		return "GrnEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateGrn(@ModelAttribute Grn Grn,Model m) {
		service.updateGrn(Grn);
		String msg="Grn Order "+Grn.getGrnId()+" Updated";
		m.addAttribute("msg",msg);

		List<Grn> list=service.getAllGrn();
		m.addAttribute("list",list);
		return "GrnData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("gid")Integer id,Model m) {
		Grn om=service.getOneGrn(id);
		System.out.println(om);
		m.addAttribute("ob",om);
		return "GrnView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="gid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new GrnExcelView());
		if(id==null) {
			//fething all data 
			List<Grn> list=service.getAllGrn();
			mv.addObject("list",list);
		}else {
			//fetch one data
			Grn	om=service.getOneGrn(id);
			mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="gid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new GrnPdfView());
		if(id==null) {
			//fething all data 
			List<Grn> list=service.getAllGrn();
			mv.addObject("list",list);
		}else {
			//fetch one data
			Grn	om=service.getOneGrn(id);
			mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
}