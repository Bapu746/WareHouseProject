package in.nit.service;

import java.util.List;

import in.nit.model.Uom;

public interface IUomService {
	Integer savaUom(Uom ob);
	List<Uom> getAllUoms();
	void deleteUom(Integer id);
	Uom getOneUom(Integer id);
	void updateUom(Uom ob);
	List<Object[]> getOneUomTypeCount();

}
