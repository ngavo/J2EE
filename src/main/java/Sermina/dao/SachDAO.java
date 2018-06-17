package Sermina.dao;

import java.util.List;
import java.util.Set;

import Sermina.dto.GetSachForHomeSach;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.model.TheLoai;

public interface SachDAO {
	
	public List<Sach> listSach();
	public List<GetSachForHomeSach> listSachHomeSach();
	public NhaXuatBan FinNXBWithName(String name);
	public void InsertSach(Sach sach);
	public TheLoai FinTheLoaiWithName(String name);
	public void deleteSach(int id);
	public Sach findSach(int id);
	public void UpdateSach(Sach sach);
	public List<Sach> findSachWothIdNXB(int nxb);
	
	public List finHoaDonNhapSachForEdit(int id);
	
	public void DeleteHoaDonNhapSachWithIdHDn(int id);
	
}
