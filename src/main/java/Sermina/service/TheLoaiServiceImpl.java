package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.TheLoaiDAO;
import Sermina.model.TheLoai;

@Service
@Transactional
public class TheLoaiServiceImpl implements TheLoaiService {

	@Autowired
    private TheLoaiDAO theLoaiDAO;
	
	@Override
	public void addTheLoai(TheLoai theLoai) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TheLoai> getAllTheLoai() {
		// TODO Auto-generated method stub
		return theLoaiDAO.getAllTheLoai();
	}

	@Override
	public void deleteTheLoai(int ID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TheLoai updateTheLoai(TheLoai theLoai) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TheLoai getTheLoai(int ID) {
		// TODO Auto-generated method stub
		return null;
	}

}
