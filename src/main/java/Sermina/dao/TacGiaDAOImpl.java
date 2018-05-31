package Sermina.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.model.Employee;
import Sermina.model.TacGia;

@Repository
public class TacGiaDAOImpl implements TacGiaDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addTacGia(TacGia employee) {
		// TODO Auto-generated method stub
		
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TacGia> getAllTacGia() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from TacGia").list();
	}

	@Override
	public void deleteTacGia(int TacGiaId) {
		// TODO Auto-generated method stub
		TacGia tacgia = (TacGia) sessionFactory.getCurrentSession().load(
                TacGia.class, TacGiaId);
        if (null != tacgia) {
            this.sessionFactory.getCurrentSession().delete(tacgia);
        }
		
	}

	@Override
	public TacGia updateTacGia(TacGia tacgia) {
		sessionFactory.getCurrentSession().update(tacgia);
        return tacgia;
	}

	@Override
	public TacGia getTacGia(int TacGiaid) {
		return (TacGia) sessionFactory.getCurrentSession().get(TacGia.class, TacGiaid);
	}

}
