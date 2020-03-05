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

import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
import in.nit.utils.OrderMethodUtils;
import in.nit.view.OrderMethodExcelView;
import in.nit.view.OrderMethodPdfView;


@RequestMapping("/order")
@Controller
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private OrderMethodUtils util;
	@RequestMapping("/register")
	public String showOrderMethod(Model model) {
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodReg";
	}
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveOrder(@ModelAttribute OrderMethod om,Model model) {
		Integer id=service.saveOrderMethod(om);
		System.out.println(om);
		String message="Order Method '"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("orderMethod", new OrderMethod());
		return "OrderMethodReg";
	}
	@RequestMapping("/all")
	public String getAllOrderMethod(Model model) {
		List<OrderMethod> list=service.getAllOrderMethod();
		System.out.println(list);
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/delete")
	public String deleteShipment(@RequestParam("ordid")Integer id,Model model) {
		service.deleteOrderMethod(id);
		String message="Order Method '"+id+"' deleted";
		model.addAttribute("message",message);
		model.addAttribute("opr","DEL");
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);
		return "OrderMethodData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("orid")Integer id,Model model) {
		OrderMethod ob=service.getOneOrderMethod(id);
		model.addAttribute("orderMethod", ob);
		return "OrderMethodEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String updateOneOrder(@ModelAttribute OrderMethod orderMethod,Model model) {
		service.updateOrder(orderMethod);
		String message="Order Method '"+orderMethod.getOrdId()+"' updated";
		model.addAttribute("message", message);
		List<OrderMethod> list=service.getAllOrderMethod();
		model.addAttribute("list",list);

		return "OrderMethodData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("orid")Integer id,Model model) {
		OrderMethod ob=service.getOneOrderMethod(id);
		model.addAttribute("ob",ob);
		return "OrderMethodView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="oid",required=false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodExcelView());
		//fetching data from DB
		if(id==null) {
			List<OrderMethod> list=service.getAllOrderMethod();
			m.addObject("list",list);
			return m;
		}
		else {
			List<OrderMethod> list=List.of(service.getOneOrderMethod(id));
			m.addObject("list",list);
			return m;
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="oid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new OrderMethodPdfView());
		if(id==null) {
			//fetching data from DB	
			List<OrderMethod> list=service.getAllOrderMethod();
			return  m.addObject("list",list);	 
		}
		else {
			OrderMethod ob=service.getOneOrderMethod(id);
			return m.addObject("list", List.of(ob));
		}
	}
	@RequestMapping("/chart")
	public String showChart() {
		String path=context.getRealPath("/");
		System.out.println( path);
	   List<Object[]> data=	service.getOneOrderMethodTypeCount();
		util.generatePie(path, data);
		util.generateBar(path, data);
		return "OrderMethodChart";
	}
}
