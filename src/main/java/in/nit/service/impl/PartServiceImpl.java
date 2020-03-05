package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IPartDao;
import in.nit.model.Part;
import in.nit.service.IPartService;
@Service
public class PartServiceImpl implements IPartService {
    @Autowired
	private IPartDao dao;
	@Override
	@Transactional
	public Integer savePart(Part part) {
		return dao.savePart(part);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Part> getAllParts() {
		return dao.getAllParts();
	}

	@Override
	@Transactional
	public void deletePart(Integer id) {
        dao.deletePart(id);
	}

	@Override
	@Transactional(readOnly=true)
	public Part getOnePart(Integer id) {
		return dao.getOnePart(id);
	}

	@Override
	@Transactional
	public void updatePart(Part ob) {
        dao.updatePart(ob);
	}

}
