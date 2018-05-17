package Sermina.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.model.NhaXuatBan;

@Repository
public class NXBDAOImpl implements NXBDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void addNXB(NhaXuatBan nxb) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(nxb);	
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<NhaXuatBan> getAllNXB() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from NhaXuatBan").list();
	}

	@Override
	public void deleteNXB(int ID) {
		// TODO Auto-generated method stub
		NhaXuatBan NXB = (NhaXuatBan) sessionFactory.getCurrentSession().load(
				NhaXuatBan.class, ID);
        if (null != NXB) {
            this.sessionFactory.getCurrentSession().delete(NXB);
        }
	}

	@Override
	public NhaXuatBan updateNXB(NhaXuatBan NXB) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(NXB);
        return NXB;
	}

	@Override
	public NhaXuatBan getNXB(int ID) {
		// TODO Auto-generated method stub
		return (NhaXuatBan) sessionFactory.getCurrentSession().get(NhaXuatBan.class, ID);
	}

}
