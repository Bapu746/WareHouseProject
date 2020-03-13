package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IGrnDao;
import in.nit.model.Grn;
import in.nit.service.IGrnService;
@Service
public class GrnServiceImpl implements IGrnService{
	@Autowired
	private IGrnDao dao;
	
	@Transactional
	public Integer saveGrn(Grn ob) {
		return dao.saveGrn(ob);
	}
	@Transactional(readOnly = true)
	public List<Grn> getAllGrn() {
		List<Grn> list=dao.getAllGrn();
		Collections.sort(list, (o1,o2)-> o1.getGrnId()-o2.getGrnId());
		return list;
	}
	@Transactional
	public void deleteGrn(Integer id) {
		dao.deleteGrn(id);
	}
	@Transactional(readOnly = true)
	public Grn getOneGrn(Integer id) {
		return dao.getOneGrn(id);
	}
	
	@Transactional
	public void updateGrn(Grn sp) {
		dao.updateGrn(sp);
	}

}
