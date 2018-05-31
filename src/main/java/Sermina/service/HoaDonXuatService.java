package Sermina.service;

import java.util.List;

import Sermina.dto.GetSachForNewHDX;
import Sermina.dto.GetSachKhacHangDaMua;

public interface HoaDonXuatService {
	
	public List<GetSachForNewHDX> SachConTonKhoDeXuatNew();
	public List<GetSachKhacHangDaMua> SachKhachHangDaMua(int idhdx);
	public void DeleteHoaDonXuatSach(int idhdx);

}
