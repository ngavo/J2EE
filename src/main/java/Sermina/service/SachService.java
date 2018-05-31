package Sermina.service;

import Sermina.dao.GetDataForFinHoaDonNhapSachForEdit;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.model.TheLoai;

import java.util.List;

public interface SachService {
	
	public List<Sach> listSach();
	public NhaXuatBan FinNXBWithName(String name);
	public void InsertSach(Sach sach);
	public TheLoai FinTheLoaiWithName(String name);
	public void deleteSach(int id);
	public Sach findSach(int id);
	public void updateSach(Sach sach);
	public List<Sach> findSachWothIdNXB(int nxb);
	public List<GetDataForFinHoaDonNhapSachForEdit> finHoaDonNhapSachForEdit(int id);
	public void DeleteHoaDonNhapSachWithIdHDn(int id);

}
