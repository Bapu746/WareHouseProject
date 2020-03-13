package in.nit.service.impl;

import java.util.List;

import in.nit.dao.IShippingDao;
import in.nit.model.Shipping;
import in.nit.service.IShippingService;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ShippingServiceImpl implements IShippingService {

	@Autowired
	private IShippingDao dao;
	
	@Transactional
	public Integer saveShipping(Shipping ob) {
		return dao.saveShipping(ob);
	}
	@Transactional(readOnly = true)
	public List<Shipping> getAllShipping() {
		List<Shipping> list=dao.getAllShipping();
		Collections.sort(list, (o1,o2)-> o1.getShpId()-o2.getShpId());
		return list;
	}
	@Transactional
	public void deleteShipping(Integer id) {
		dao.deleteShipping(id);
	}
	@Transactional(readOnly = true)
	public Shipping getOneShipping(Integer id) {
		return dao.getOneShipping(id);
	}
	
	@Transactional
	public void updateShipping(Shipping sp) {
		dao.updateShipping(sp);
	}

}