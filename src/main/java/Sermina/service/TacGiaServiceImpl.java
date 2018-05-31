package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.TacGiaDAO;
import Sermina.model.TacGia;

@Service
@Transactional
public class TacGiaServiceImpl implements TacGiaService {

	@Autowired
	private TacGiaDAO tacgiaDAO; 
	
	@Override
	public void addTacGia(TacGia tacgia) {
		// TODO Auto-generated method stub
		tacgiaDAO.addTacGia(tacgia);
	}

	@Override
	public List<TacGia> getAllTacGia() {
		return tacgiaDAO.getAllTacGia();
	}

	@Override
	public void deleteTacGia(int tacgiaId) {
		// TODO Auto-generated method stub
		tacgiaDAO.deleteTacGia(tacgiaId);
		
	}

	@Override
	public TacGia getTacGia(int tacgiaid) {
		// TODO Auto-generated method stub
		return tacgiaDAO.getTacGia(tacgiaid);
	}

	@Override
	public TacGia updateTacGia(TacGia tacgia) {
		// TODO Auto-generated method stub
		return tacgiaDAO.updateTacGia(tacgia);
	}

}
