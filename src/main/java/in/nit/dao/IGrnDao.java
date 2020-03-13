package in.nit.dao;

import java.util.List;

import in.nit.model.Grn;
public interface IGrnDao {
	Integer saveGrn(Grn ob);
	List<Grn> getAllGrn();
	void deleteGrn(Integer id);
	Grn getOneGrn(Integer id);
	void updateGrn(Grn sp);
}