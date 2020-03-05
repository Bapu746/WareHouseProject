package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.ISaleOrderDao;
import in.nit.model.SaleOrder;
import in.nit.service.ISaleOrderService;
@Service
public class SaleOrderServiceImpl implements ISaleOrderService {
	@Autowired
	private ISaleOrderDao dao;

	@Override
	@Transactional
	public Integer saveSaleOrder(SaleOrder sob) {
		return dao.saveSaleOrder(sob);
	}

	@Override
	@Transactional(readOnly=true)
	public List<SaleOrder> getAllSaleOrders() {
		return dao.getAllSaleOrders();
	}

	@Override
	@Transactional
	public void deleteSaleOrder(Integer id) {
		dao.deleteSaleOrder(id);
	}

	@Override
	@Transactional(readOnly = true)
	public SaleOrder getOneSaleOrder(Integer id) {
		return dao.getOneSaleOrder(id);
	}

	@Override
	@Transactional
	public void updateSaleOrder(SaleOrder ob) {
		dao.updateSaleOrder(ob);
	}

}
