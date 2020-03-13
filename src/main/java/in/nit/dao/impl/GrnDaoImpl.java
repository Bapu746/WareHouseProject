package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IGrnDao;
import in.nit.model.Grn;
@Repository
public class GrnDaoImpl implements IGrnDao {

	@Autowired
	HibernateTemplate ht;
	
	@Override
	public Integer saveGrn(Grn ob) {
		return (Integer) ht.save(ob);
	}
	@Override
	public List<Grn> getAllGrn() {
		return ht.loadAll(Grn.class);
	}
	@Override
	public void deleteGrn(Integer id) {
		ht.delete(new Grn(id));
	}
	@Override
	public Grn getOneGrn(Integer id) {
		return ht.get(Grn.class, id);
	}
	@Override
	public void updateGrn(Grn sp) {
		ht.update(sp);
	}

}

