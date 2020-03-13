package in.nit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.Shipping;
import in.nit.service.IShippingService;
import in.nit.view.ShippingExcelView;
import in.nit.view.ShippingPdfView;

@Controller
@RequestMapping("/shipping")
public class ShippingController {
	@Autowired
	private IShippingService service;
	
	//1.Show Reg page
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("shipping",new Shipping());
	return "ShippingRegisterPage";
	}
	//2.on click save Operation
	@RequestMapping(value = "/save",method =POST)
	public String saveOneShipping(@ModelAttribute Shipping shipping,Model m) {
		Integer id=service.saveShipping(shipping);
		String msg="Shipping "+id+" Saved";
		m.addAttribute("msg",msg);
		m.addAttribute("shipping",new Shipping());
	return "ShippingRegisterPage";
	}
	//3.show all data
	@RequestMapping("/all")
	public String getAllShipping(Model model) {
		List<Shipping> list=service.getAllShipping();
		model.addAttribute("list",list);
	return "ShippingData";
	}
	//4.delete one order
	@RequestMapping("/delete")
	public String deleteShipping(@RequestParam("sid")Integer id,Model m) {
		service.deleteShipping(id);
		String msg="ShippingOrder "+id+" Deleted";
		m.addAttribute("msg", msg);
		
		List<Shipping> list=service.getAllShipping();
		m.addAttribute("list",list);
	return "ShippingData";
	}
	//5.show edit page
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("sid")Integer id,Model m) {
		Shipping Shipping=service.getOneShipping(id);
		m.addAttribute("shipping",Shipping);
		return "ShippingEditPage";
	}
	//6.on click update operation
	@RequestMapping(value="/update" ,method=POST)
	public String updateShipping(@ModelAttribute Shipping shipping,Model m) {
		service.updateShipping(shipping);
		String msg="Shipping Order "+shipping.getShpId()+" Updated";
		m.addAttribute("msg",msg);
		
		List<Shipping> list=service.getAllShipping();
		m.addAttribute("list",list);
		return "ShippingData";
	}
	//7.view one Order
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("sid")Integer id,Model m) {
		Shipping om=service.getOneShipping(id);
		System.out.println(om);
		m.addAttribute("ob",om);
		return "ShippingView";
	}
	//Excel Export
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="sid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new ShippingExcelView());
		if(id==null) {
		//fething all data 
		List<Shipping> list=service.getAllShipping();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Shipping	om=service.getOneShipping(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
	//Pdf Export
	@RequestMapping("/pdf")
	public ModelAndView showPDf(@RequestParam(value="sid",required = false)Integer id) {
		ModelAndView mv=new ModelAndView();
		mv.setView(new ShippingPdfView());
		if(id==null) {
		//fething all data 
		List<Shipping> list=service.getAllShipping();
		mv.addObject("list",list);
		}else {
			//fetch one data
		Shipping	om=service.getOneShipping(id);
		mv.addObject("list",Arrays.asList(om));
		}
		return mv;
	}
}
