package Sermina.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.dto.GetSachForNewHDX;

@Repository
public class TonKhoDAOImpl implements TonKhoDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public int GetTenNhaXuatBanSach(int idSach)
	{
		List vs = sessionFactory.getCurrentSession().createSQLQuery("select id_nhaxuatban from sach where id=:idSach").setParameter("idSach", idSach).list();
		int idHXB = getSachFromList(vs);
		return idHXB;
		
	}
	
	public int GetTenTheLoai(int idSach)
	{
		List vs = sessionFactory.getCurrentSession().createSQLQuery("select id_theloai from sach where id=:idSach").setParameter("idSach", idSach).list();
		int idHXB = getSachFromList(vs);
		return idHXB;
	}
	
	public int getSachFromList(List listObject)
	{
		int lenghttObject = listObject.size();
		
		int id_nxb = 0;
		Object k =  listObject.get(0);
		id_nxb = Integer.parseInt(k.toString());
		return id_nxb;
	}

}
