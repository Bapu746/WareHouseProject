package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IUomDao;
import in.nit.model.Uom;
@Repository
public class UomDaoImpl implements IUomDao {
	@Autowired
	private HibernateTemplate ht;
	@Override
	public Integer savaUom(Uom ob) {
		return (Integer)ht.save(ob); 
	}

	@Override
	public List<Uom> getAllUoms() {
		return ht.loadAll(Uom.class);
	}

	@Override
	public void deleteUom(Integer id) {
		ht.delete(new Uom(id));
	}
	@Override
	public Uom getOneUom(Integer id) {
		return ht.get(Uom.class,id);
	}
	@Override
	public void updateUom(Uom ob) {
      ht.update(ob);		
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getOneUomTypeCount() {
		return (List<Object[]>) ht.find("select uomType,count(uomType) from in.nit.model.Uom group by uomType");
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Object[]> getUomIdAndUomModel() {
		String hql="select uomId,uomModel from in.nit.model.Uom";
		return (List<Object[]>) ht.find(hql);
	}

}
