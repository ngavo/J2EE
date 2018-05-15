package Sermina.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.model.TheLoai;

@Repository
public class TheLoaiDAOImpl implements TheLoaiDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTheLoai(TheLoai theLoai) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TheLoai> getAllTheLoai() {
		return sessionFactory.getCurrentSession().createQuery("from TheLoai").list();
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
