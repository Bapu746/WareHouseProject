package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
import in.nit.service.IOrderMethodService;
@Service
public class OrderMethodServiceImpl implements IOrderMethodService {
	@Autowired
	private IOrderMethodDao dao;

	@Override
	@Transactional
	public Integer saveOrderMethod(OrderMethod ob) {
		return dao.saveOrderMethod(ob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderMethod> getAllOrderMethod() {
		System.out.println(dao.getAllOrderMethod());

		return dao.getAllOrderMethod();
	}

	@Override
	@Transactional
	public void deleteOrderMethod(Integer id) {
		dao.deleteOrderMethod(id);
	}
	@Transactional(readOnly = true)
	public OrderMethod getOneOrderMethod(Integer id) {
		return dao.getOneOrderMethod(id);
	}
	@Transactional
	public void updateOrder(OrderMethod ob) {
		dao.updateOrder(ob);
	}
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getOneOrderMethodTypeCount() {
		return dao.getOneOrderMethodTypeCount();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getIdAndOrderCode(String ordMode) {
		return dao.getIdAndOrderCode(ordMode);
	}
}
