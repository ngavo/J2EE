package Sermina.dao;

import java.util.List;

import Sermina.dto.GetSachForNewHDX;
import Sermina.dto.GetSachKhacHangDaMua;

public interface HoaDonXuatDAO {
	
	public List<GetSachForNewHDX> SachConTonKhoDeXuatNew();
	public List<GetSachForNewHDX> SachDaBan();
	
	public List<GetSachKhacHangDaMua> SachKhachHangDaMua(int idhdx);
	public void DeleteHoaDonXuatSach(int idhdx);

}
