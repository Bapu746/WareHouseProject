package in.nit.service;

import java.util.List;

import in.nit.model.OrderMethod;

public interface IOrderMethodService {
	 Integer saveOrderMethod(OrderMethod ob);
	 List<OrderMethod> getAllOrderMethod();
	void deleteOrderMethod(Integer id);
	OrderMethod getOneOrderMethod(Integer id);
	void updateOrder(OrderMethod ob);
	 List<Object[]> getOneOrderMethodTypeCount();
	 List<Object[]> getIdAndOrderCode(String ordMode);

}
