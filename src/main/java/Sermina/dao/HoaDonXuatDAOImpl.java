package Sermina.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Sermina.dto.GetSachForNewHDX;
import Sermina.dto.GetSachKhacHangDaMua;
import Sermina.model.HoaDonXuat_Sach;

@Repository
public class HoaDonXuatDAOImpl implements HoaDonXuatDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public List<GetSachForNewHDX> SachConTonKhoDeXuatNew()
	{
		
		List<GetSachForNewHDX> result = TinhToanDeXuatXemSachConTonKho(SachNhap(),SachDaBan());
		
		return result;
		
	}
	
	
	public List<GetSachForNewHDX> TinhToanDeXuatXemSachConTonKho(List<GetSachForNewHDX> SachNhap,List<GetSachForNewHDX> SachBan )
	{
		List<GetSachForNewHDX> tonkhos = new ArrayList<GetSachForNewHDX>();
		for(int i=0;i<SachNhap.size();i++)
		{
			GetSachForNewHDX tonkho = new GetSachForNewHDX();
			tonkho.setIdSach(SachNhap.get(i).getIdSach());
			tonkho.setSoLuong(SachNhap.get(i).getSoLuong());
			tonkho.setTenSach(SachNhap.get(i).getTenSach());
			tonkho.setGiaBan(SachNhap.get(i).getGiaBan());
			for(int j=0;j<SachBan.size();j++)
			{
				if(SachNhap.get(i).getIdSach()==SachBan.get(j).getIdSach())
				{
					tonkho.setSoLuong(SachNhap.get(i).getSoLuong()-SachBan.get(j).getSoLuong());
				}
			}
			
			tonkhos.add(tonkho);
		}
		
		return tonkhos;
	}
	
	
	public List<GetSachForNewHDX> SachNhap()
	{
		List k = sessionFactory.getCurrentSession().createQuery("select  s.sach.id,sum(s.SoLuong), s.sach.TenSach, s.sach.GiaBan from HoaDonNhap_Sach s group by s.sach.id ").list();
		List<GetSachForNewHDX> result =getSachFromList(k);
		return result;
		
	}
	
	
	
	
	public List<GetSachForNewHDX> SachDaBan()
	{
		List k = sessionFactory.getCurrentSession().createQuery("select  s.sach.id,sum(s.SoLuong), s.sach.TenSach,s.sach.GiaBan from HoaDonXuat_Sach s group by s.sach.id ").list();
		List<GetSachForNewHDX> result =getSachFromList(k);
		return result;
	}
	
	public List<GetSachForNewHDX> getSachFromList(List listObject)
	{
		int lenghttObject = listObject.size();
		
		List<GetSachForNewHDX> listSach = new ArrayList<GetSachForNewHDX>();
		
		for(int i=0;i<lenghttObject;i++)
		{
			GetSachForNewHDX sachsoluong = new GetSachForNewHDX();
			Object[] k =	(Object[]) listObject.get(i);
			String n = Arrays.toString(k);
			String sub = n.substring(1, n.length()-1);
			String[] lisSub= sub.split(",");
			sachsoluong.setIdSach(Integer.parseInt(lisSub[0].trim()));
			sachsoluong.setSoLuong(Long.parseLong(lisSub[1].trim()));
			sachsoluong.setTenSach(lisSub[2].trim());
			sachsoluong.setGiaBan(Long.parseLong(lisSub[3].trim()));
			listSach.add(sachsoluong);
		}
		return listSach;
	}
	
	public List<GetSachKhacHangDaMua> SachKhachHangDaMua(int idhdx)
	{
		Query hdxs = sessionFactory.getCurrentSession().createQuery("from HoaDonXuat_Sach  s where s.hoadonxuat.id=:id");
		
		hdxs.setParameter("id", idhdx);
		
		List<HoaDonXuat_Sach> result = hdxs.list();
		
		List<GetSachKhacHangDaMua> getSach = new ArrayList<GetSachKhacHangDaMua>();
		
		for (HoaDonXuat_Sach hoaDonXuat_Sach : result) {
			
			GetSachKhacHangDaMua sachmua = new GetSachKhacHangDaMua();
			
			sachmua.setIdSach(hoaDonXuat_Sach.getSach().getId());
			sachmua.setSoLuong(hoaDonXuat_Sach.getSoLuong());
			
			getSach.add(sachmua);
		}
		
		return getSach;
		
	}
	
	 public void DeleteHoaDonXuatSach(int idhdx)
	{
		Query hdxs = sessionFactory.getCurrentSession().createQuery("delete HoaDonXuat_Sach  s where s.hoadonxuat.id=:id");
		hdxs.setParameter("id", idhdx);
		
		hdxs.executeUpdate();
		
	}
	

}
