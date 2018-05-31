package Sermina.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.model.KhachHang;
import Sermina.model.NhaXuatBan;

@Repository
public class KhachHangDAOImpl implements KhachHangDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public KhachHang findKhachHangWithName(String name)
	{
		Query nxb = sessionFactory.getCurrentSession().createQuery("from KhachHang where HoTen=:name");
		nxb.setParameter("name", name);
		
		KhachHang nx = (KhachHang) nxb.uniqueResult();
		return nx;
	}


	@Override
	public void addKhachHang(KhachHang KhachHang) {
		sessionFactory.getCurrentSession().saveOrUpdate(KhachHang);
		
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<KhachHang> getAllKhachHang() {
		return sessionFactory.getCurrentSession().createQuery("from KhachHang").list();
	}

	@Override
	public void deleteKhachHang(int ID) {
		KhachHang KhachHang = (KhachHang) sessionFactory.getCurrentSession().load(
                KhachHang.class, ID);
        if (null != KhachHang) {
            this.sessionFactory.getCurrentSession().delete(KhachHang);
        }
		
	}

	@Override
	public KhachHang updateKhachHang(KhachHang KhachHang) {
		sessionFactory.getCurrentSession().update(KhachHang);
        return KhachHang;
	}

	@Override
	public KhachHang getKhachHang(int ID) {
		return (KhachHang) sessionFactory.getCurrentSession().get(KhachHang.class, ID);
	}

}
