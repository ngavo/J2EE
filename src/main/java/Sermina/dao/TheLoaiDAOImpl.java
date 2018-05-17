package Sermina.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.model.Employee;
import Sermina.model.TheLoai;

@Repository
public class TheLoaiDAOImpl implements TheLoaiDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addTheLoai(TheLoai theLoai) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(theLoai);		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<TheLoai> getAllTheLoai() {
		return sessionFactory.getCurrentSession().createQuery("from TheLoai").list();
	}

	@Override
	public void deleteTheLoai(int ID) {
		// TODO Auto-generated method stub
		TheLoai theLoai = (TheLoai) sessionFactory.getCurrentSession().load(
				TheLoai.class, ID);
        if (null != theLoai) {
            this.sessionFactory.getCurrentSession().delete(theLoai);
        }
	}

	@Override
	public TheLoai updateTheLoai(TheLoai theLoai) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(theLoai);
        return theLoai;
	}

	@Override
	public TheLoai getTheLoai(int ID) {
		// TODO Auto-generated method stub
		return (TheLoai) sessionFactory.getCurrentSession().get(TheLoai.class, ID);
	}

}
