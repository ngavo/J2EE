package Sermina.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.dto.GetSachForHomeSach;
import Sermina.dto.GetSachForNewHDX;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.model.TheLoai;


@Repository
public class SachDAOImpl implements SachDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Sach> listSach() {
		// TODO Auto-generated method stub
		List<Sach> listSach = sessionFactory.getCurrentSession().createQuery("from Sach as s order by s.id desc").list();
		return listSach;
	}
	
	@Override
	public List<GetSachForHomeSach> listSachHomeSach()
	{
		
		
		//List<Sach> listSach = sessionFactory.getCurrentSession().createQuery("from Sach as s order by s.id desc").list();
		Query Nha = sessionFactory.getCurrentSession().createSQLQuery("select sach.id as id, sach.tensach as tensach, sach.gianhap as gianhap, sach.giaban as giaban, nhaxuatban.tennhaxuatban from sach inner join nhaxuatban on sach.id_nhaxuatban = nhaxuatban.id order by sach.id desc");
		
		return LayListSachForHome(Nha.list());
		
	}
	
	public List<GetSachForHomeSach> LayListSachForHome(List listObject)
	{
		int lenghttObject = listObject.size();
		
		List<GetSachForHomeSach> listSach = new ArrayList<GetSachForHomeSach>();
		
		for(int i=0;i<lenghttObject;i++)
		{
			GetSachForHomeSach sachsoluong = new GetSachForHomeSach();
			Object[] k =	(Object[]) listObject.get(i);
			String n = Arrays.toString(k);
			String sub = n.substring(1, n.length()-1);
			String[] lisSub= sub.split(",");
			sachsoluong.setId(Integer.parseInt(lisSub[0].trim()));
			sachsoluong.setTenSach((lisSub[1].trim()));
			sachsoluong.setGiaNhap(Long.parseLong(lisSub[2].trim()));
			sachsoluong.setGiaBan(Long.parseLong(lisSub[3].trim()));
			sachsoluong.setTenNhaXuatBan(lisSub[4].trim());
			listSach.add(sachsoluong);
		}
		return listSach;
	}
	
	@Override
	public NhaXuatBan FinNXBWithName(String name)
	{
		Query nxb = sessionFactory.getCurrentSession().createQuery("from NhaXuatBan where TenNhaXuatBan=:name");
		nxb.setParameter("name", name);
		
		NhaXuatBan nx = (NhaXuatBan) nxb.uniqueResult();
		return nx;
		
		
		
	}
	
	@Override
	public void InsertSach(Sach sach)
	{
		sessionFactory.getCurrentSession().save(sach);
	}
	
	@Override
	public TheLoai FinTheLoaiWithName(String name)
	{
		Query theloai = sessionFactory.getCurrentSession().createQuery("from TheLoai where TenTheLoai=:name");
		theloai.setParameter("name", name);
		TheLoai tl = (TheLoai)theloai.uniqueResult();
		return tl;
		
		
	}
	
	@Override
	public void deleteSach(int id)
	{
		Sach sach = (Sach)sessionFactory.getCurrentSession().load(Sach.class, id);
		if(sach!=null)
		{
			this.sessionFactory.getCurrentSession().delete(sach);
		}
	}
	
	
	@Override
	public Sach findSach(int id)
	{
		Sach sach = (Sach)sessionFactory.getCurrentSession().load(Sach.class, id);
		return sach;
		
		
		
	}
	
	@Override
	public void UpdateSach(Sach sach)
	{
		
		sessionFactory.getCurrentSession().update(sach);
	}
	
	@Override
	public List<Sach> findSachWothIdNXB(int nxb)
	{
		Query listSach = sessionFactory.getCurrentSession().createSQLQuery("select sach.id as id, sach.tensach as tensach, sach.gianhap as gianhap, theloai.tentheloai from sach inner join theloai on sach.id_theloai = theloai.id where sach.id_nhaxuatban=:idnxb").setParameter("idnxb", nxb);
		
		List<Sach> ls = (List<Sach>)listSach.list();
		return ls;
		
		
	}
	
	@Override
	public List<GetDataForFinHoaDonNhapSachForEdit> finHoaDonNhapSachForEdit(int id)
	{
		/*Query hoadonnhapsach = sessionFactory.getCurrentSession().createSQLQuery("select hoadonnhap_sach.idsach, sach.tensach as tensach, sach.gianhap as gianhap, theloai.tentheloai,hoadonnhap_sach.soluong from sach inner join theloai on sach.id_theloai = theloai.id where sach.id_nhaxuatban=:idnxb").setParameter("idnxb", nxb);*/
		
		Query hoadonnhapsach = sessionFactory.getCurrentSession().createSQLQuery("select hoadonnhap_sach.idsach, hoadonnhap_sach.soluong from hoadonnhap_sach where hoadonnhap_sach.idhdn=:id").setParameter("id", id);
		
		
		
		return  getSachFromList(hoadonnhapsach.list());
	}
	
	
	
	public List<GetDataForFinHoaDonNhapSachForEdit> getSachFromList(List listObject)
	{
		int lenghttObject = listObject.size();
		
		List<GetDataForFinHoaDonNhapSachForEdit> listSach = new ArrayList<GetDataForFinHoaDonNhapSachForEdit>();
		
		for(int i=0;i<lenghttObject;i++)
		{
			GetDataForFinHoaDonNhapSachForEdit sachsoluong = new GetDataForFinHoaDonNhapSachForEdit();
			Object[] k =	(Object[]) listObject.get(i);
			String n = Arrays.toString(k);
			String sub = n.substring(1, n.length()-1);
			String[] lisSub= sub.split(",");
			sachsoluong.setIdSach(Integer.parseInt(lisSub[0].trim()));
			sachsoluong.setSoLuong(Long.parseLong(lisSub[1].trim()));
			listSach.add(sachsoluong);
		}
		return listSach;
	}
	
	@Override
	public void DeleteHoaDonNhapSachWithIdHDn(int id)
	{
		sessionFactory.getCurrentSession().createSQLQuery("delete from hoadonnhap_sach where hoadonnhap_sach.idhdn=:id").setParameter("id", id).executeUpdate();
	}
	
	

}
