package in.nit.dao;

import java.util.List;

import in.nit.model.ShipmentType;

public interface IShipmentTypeDao {
	Integer saveShipmentType(ShipmentType ob);
	List<ShipmentType> getAllShipmentTypes();
     void deleteShipmentType(Integer id);
     ShipmentType getOneShipmentType(Integer id);
     void updateShipmentType(ShipmentType ob);
     List<Object[]> getOneShipmentModeCount();
     List<Object[]> getShipmentIdAndCode();
     
}
