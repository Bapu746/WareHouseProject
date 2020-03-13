package in.nit.service;

import java.util.List;

import in.nit.model.Grn;

public interface IGrnService {
	Integer saveGrn(Grn ob);
	List<Grn> getAllGrn();
	void deleteGrn(Integer id);
	Grn getOneGrn(Integer id);
	void updateGrn(Grn sp);

}
