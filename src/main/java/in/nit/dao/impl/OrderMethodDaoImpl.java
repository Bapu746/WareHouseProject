package in.nit.dao.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import in.nit.dao.IOrderMethodDao;
import in.nit.model.OrderMethod;
@Repository
public class OrderMethodDaoImpl implements IOrderMethodDao {
	@Autowired
	private HibernateTemplate ht;

	@Override
	public Integer saveOrderMethod(OrderMethod ob) {

		return (Integer)ht.save(ob);
	}

	@Override
	public List<OrderMethod> getAllOrderMethod() {
		List<OrderMethod> list=ht.loadAll(OrderMethod.class);
		Collections.sort(list, (o1,o2)->o1.getOrdId()-o2.getOrdId());
		return list;
	}

	@Override
	public void deleteOrderMethod(Integer id) {
		ht.delete(new OrderMethod(id));
	}
	@Override
	public OrderMethod getOneOrderMethod(Integer id) {
		return ht.get(OrderMethod.class,id);
	}
	@Override
	public void updateOrder(OrderMethod ob) {
      ht.update(ob);		
	}
@SuppressWarnings({ "deprecation", "unchecked" })
@Override
	public List<Object[]> getOneOrderMethodTypeCount() {
		return (List<Object[]>) ht.find("select ordType,count(ordType) from in.nit.model.OrderMethod group by ordType");
	}	

}
