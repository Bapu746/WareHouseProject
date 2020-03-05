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

import in.nit.model.SaleOrder;

import in.nit.service.ISaleOrderService;
import in.nit.view.SaleOrderExcelView;
import in.nit.view.SaleOrderPdfView;

@Controller
@RequestMapping("/sale")
public class SaleOrderController {
   @Autowired
	private ISaleOrderService service;
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		model.addAttribute("saleOrder",new SaleOrder());
		return "SaleOrderRegister";
	}
	@RequestMapping(value="/save",method=POST)
	public String saveSaleOrder(@ModelAttribute SaleOrder saleOrder,Model model) {
		Integer id=service.saveSaleOrder(saleOrder);
		String message="SaleOrder '"+id+"'saved";
		model.addAttribute("message", message);
		model.addAttribute("SaleOrder",new SaleOrder());
		return "SaleOrderRegister";
	}
	@RequestMapping("/all")
	public String getAllSaleOrders(Model model){
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	@RequestMapping("/delete")
	public String deleteSaleOrder(@RequestParam("slid")Integer id,Model model) {
		service.deleteSaleOrder(id);;
		String message="SaleOrder '"+id+"' deleted";
		model.addAttribute("message",message);
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("slid")Integer id,Model model) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("saleOrder",so);
		return "SaleOrderEdit";
	}
	@RequestMapping(value="/update",method=POST)
	public String updateSaleOrder(@ModelAttribute SaleOrder saleOrder,Model model) {
		service.updateSaleOrder(saleOrder);
		String message="SaleOrder  '"+saleOrder.getOrdId()+"' updated";
		model.addAttribute("message",message);
		List<SaleOrder> list=service.getAllSaleOrders();
		model.addAttribute("list",list);
		return "SaleOrderData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("slid")Integer id,Model model) {
		SaleOrder so=service.getOneSaleOrder(id);
		model.addAttribute("sale",so);
		return "SaleOrderView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="slid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderExcelView());
		//fetching data from DB
		if(id==null) {
		List<SaleOrder> list=service.getAllSaleOrders();
		return m.addObject("list",list);	
	}
		else {
			List<SaleOrder> list=List.of(service.getOneSaleOrder(id));
			return m.addObject("list",list);
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="slid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new SaleOrderPdfView());
		if(id==null) {
		//fetching data from DB	
		  List<SaleOrder> list=service.getAllSaleOrders();
		  return  m.addObject("list",list);	 

	}
		else {
			SaleOrder so=service.getOneSaleOrder(id);
			return m.addObject("list", List.of(so));
		}
	}
}
