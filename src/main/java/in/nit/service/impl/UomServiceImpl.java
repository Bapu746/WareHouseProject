package in.nit.service.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
import in.nit.service.IUomService;
@Service
public class UomServiceImpl implements IUomService {
	@Autowired
	private IUomDao dao;

	@Override
	@Transactional
	public Integer savaUom(Uom ob) {

		return dao.savaUom(ob);
	}

	@Transactional(readOnly = true)
	@Override
	public List<Uom> getAllUoms() {	
		List<Uom> list=dao.getAllUoms();
		Collections.sort(list,(o1,o2)->o1.getUomId()-o2.getUomId());
		return list;
	}

	@Transactional
	@Override
	public void deleteUom(Integer id) {
		dao.deleteUom(id);
	}
	@Transactional(readOnly = true)
	@Override
	public Uom getOneUom(Integer id) {
		return dao.getOneUom(id);
	}
	@Transactional
	public void updateUom(Uom ob) {
        dao.updateUom(ob);
	}
@Override
@Transactional(readOnly = true)
	public List<Object[]> getOneUomTypeCount() {
		return dao.getOneUomTypeCount();
	}
	@Override
	@Transactional(readOnly = true)
	public List<Object[]> getUomIdAndUomModel() {
		return dao.getUomIdAndUomModel();
	}
}
