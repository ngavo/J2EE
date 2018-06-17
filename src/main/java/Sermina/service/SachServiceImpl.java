package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.GetDataForFinHoaDonNhapSachForEdit;
import Sermina.dao.SachDAO;
import Sermina.dto.GetSachForHomeSach;
import Sermina.model.NhaXuatBan;
import Sermina.model.Sach;
import Sermina.model.TheLoai;

@Service
@Transactional
public class SachServiceImpl implements SachService {

	@Autowired
	private SachDAO sachDAO;
	
	
	
	@Override
	@Transactional
	public List<Sach> listSach() {
		// TODO Auto-generated method stub
		return sachDAO.listSach();
	}
	
	@Override
	@Transactional
	public NhaXuatBan FinNXBWithName(String name)
	{
		return sachDAO.FinNXBWithName(name);
	}
	
	@Override
	@Transactional
	public void InsertSach(Sach sach)
	{
		 sachDAO.InsertSach(sach);
	}
	
	@Override
	@Transactional
	public TheLoai FinTheLoaiWithName(String name)
	{
		return sachDAO.FinTheLoaiWithName(name);
	}
	
	@Override
	@Transactional
	public void deleteSach(int id)
	{
		sachDAO.deleteSach(id);
	}
	
	@Override
	@Transactional
	public Sach findSach(int id)
	{
		return sachDAO.findSach(id);
	}
	
	@Override
	@Transactional
	public void updateSach(Sach sach)
	{
		sachDAO.UpdateSach(sach);
	}
	
	@Override
	@Transactional
	public List<Sach> findSachWothIdNXB(int nxb)
	{
		return sachDAO.findSachWothIdNXB(nxb);
	}
	
	@Override
	@Transactional
	public List<GetDataForFinHoaDonNhapSachForEdit> finHoaDonNhapSachForEdit(int id)
	{
		return sachDAO.finHoaDonNhapSachForEdit(id);
	}
	
	@Override
	@Transactional
	public void DeleteHoaDonNhapSachWithIdHDn(int id)
	{
		sachDAO.DeleteHoaDonNhapSachWithIdHDn(id);
	}
	
	@Override
	@Transactional
	public List<GetSachForHomeSach> listSachHomeSach()
	{
		return sachDAO.listSachHomeSach();
	}

}