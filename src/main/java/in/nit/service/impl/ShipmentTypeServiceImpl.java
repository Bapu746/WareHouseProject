package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IShipmentTypeDao;
import in.nit.model.ShipmentType;
import in.nit.service.IShipmentTypeService;
@Service
public class ShipmentTypeServiceImpl  implements IShipmentTypeService{

	@Autowired
	private IShipmentTypeDao dao;
	@Override
	@Transactional
	public Integer saveShipmentType(ShipmentType ob) {
		// TODO Auto-generated method stub
		return dao.saveShipmentType(ob);
	}
	@Override
	@Transactional(readOnly=true)
	public List<ShipmentType> getAllShipmentTypes() {

		return dao.getAllShipmentTypes();
	}
	@Override
	@Transactional
	public void deleteShipmentType(Integer id) {
		dao.deleteShipmentType(id);

	}
	@Transactional(readOnly =true )
	public ShipmentType getOneShipmentType(Integer id) {
		return dao.getOneShipmentType(id);
	}
	@Transactional
	public void updateShipmentType(ShipmentType ob) {
        dao.updateShipmentType(ob);		
	}
	@Override
	@Transactional(readOnly =true )
	public List<Object[]> getOneShipmentModeCount() {
		return dao.getOneShipmentModeCount();
	}
}
