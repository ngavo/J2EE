package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.NXBDAO;
import Sermina.model.NhaXuatBan;

@Service
@Transactional
public class NXBServiceImpl implements NXBService{
	@Autowired
    private NXBDAO nxbDAO;
	
	@Override
	public void addNXB(NhaXuatBan NXB) {
		// TODO Auto-generated method stub
		nxbDAO.addNXB(NXB);
	}

	@Override
	public List<NhaXuatBan> getAllNXB() {
		// TODO Auto-generated method stub
		return nxbDAO.getAllNXB();
	}

	@Override
	public void deleteNXB(int ID) {
		// TODO Auto-generated method stub
		nxbDAO.deleteNXB(ID);
	}

	@Override
	public NhaXuatBan getNXB(int ID) {
		// TODO Auto-generated method stub
		return nxbDAO.getNXB(ID);
	}

	@Override
	public NhaXuatBan updateNXB(NhaXuatBan NXB) {
		// TODO Auto-generated method stub
		return nxbDAO.updateNXB(NXB);
	}

}
