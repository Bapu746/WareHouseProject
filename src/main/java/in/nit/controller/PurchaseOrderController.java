package in.nit.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.nit.model.PurchaseOrder;
import in.nit.service.IPurchaseOrderService;
import in.nit.service.IShipmentTypeService;
import in.nit.view.PuchaseOrderExcelView;
import in.nit.view.PurchaseOrderPdfView;

@Controller
@RequestMapping("/purchase")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	
	@Autowired
	private IShipmentTypeService shipmentService; 
	private void commonUi(List<Object[]> list) {
		
		
	}
	@RequestMapping("/register")
	public String showRegPage(Model model) {
		PurchaseOrder po=new PurchaseOrder();
		po.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		return "PurchaseOrderRegister";
	}

	@RequestMapping(value="/save",method=POST)
	public String savePurchaseOrder(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {
		Integer id=service.savaPurchaseOrder(purchaseOrder);
		String message="Purchase Order '"+id+"'saved";
		model.addAttribute("message", message);
		PurchaseOrder po=new PurchaseOrder();
		po.setDefStatus("OPEN");
		model.addAttribute("purchaseOrder",po);
		return "PurchaseOrderRegister";
	}
	@RequestMapping("/all")
	public String getAllPurchaseOrders(Model model){
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("pid")Integer id,Model model) {
		service.deletePurchaseOrder(id);;
		String message="PurchaseOrder '"+id+"' deleted";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	@RequestMapping("/edit")
	public String showEditPage(@RequestParam("pid")Integer id,Model model) {
	    PurchaseOrder sh=service.getOnePurchaseOrder(id);
		model.addAttribute("purchaseOrder",sh);
		return "PurchaseOrderEdit";
	}
	@RequestMapping(value="/update",method=POST)
	public String updateShipmentType(@ModelAttribute PurchaseOrder purchaseOrder,Model model) {
		service.updatePurchaseOrder(purchaseOrder);
		String message="Purchase Order '"+purchaseOrder.getOrdId()+"' updated";
		model.addAttribute("message",message);
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		model.addAttribute("list",list);
		return "PurchaseOrderData";
	}
	@RequestMapping("/view")
	public String showViewPage(@RequestParam("pid")Integer id,Model model) {
		PurchaseOrder ob=service.getOnePurchaseOrder(id);
		model.addAttribute("ob",ob);
		return "PurchaseOrderView";
	}
	@RequestMapping("/excel")
	public ModelAndView showExcel(@RequestParam(value="pid",required = false)Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PuchaseOrderExcelView());
		//fetching data from DB
		if(id==null) {
		List<PurchaseOrder> list=service.getAllPurchaseOrders();
		return m.addObject("list",list);	
	}
		else {
			List<PurchaseOrder> list=List.of(service.getOnePurchaseOrder(id));
			return m.addObject("list",list);
		}
	}
	@RequestMapping("/pdf")
	public ModelAndView showPdf(@RequestParam(value="pid",required = false) Integer id) {
		ModelAndView m=new ModelAndView();
		m.setView(new PurchaseOrderPdfView());
		if(id==null) {
		//fetching data from DB	
		  List<PurchaseOrder> list=service.getAllPurchaseOrders();
		  return  m.addObject("list",list);	 

	}
		else {
			PurchaseOrder ob=service.getOnePurchaseOrder(id);
			return m.addObject("list", List.of(ob));
		}
	}
	
}


