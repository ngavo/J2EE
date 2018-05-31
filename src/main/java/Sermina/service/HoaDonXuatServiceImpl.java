package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.HoaDonXuatDAO;
import Sermina.dto.GetSachForNewHDX;
import Sermina.dto.GetSachKhacHangDaMua;

@Service
@Transactional
public class HoaDonXuatServiceImpl implements HoaDonXuatService {
	@Autowired
	private HoaDonXuatDAO hdx;
	
	@Override
	@Transactional
	public List<GetSachForNewHDX> SachConTonKhoDeXuatNew()
	{
		return hdx.SachConTonKhoDeXuatNew();
	}
	
	@Override
	@Transactional
	public List<GetSachKhacHangDaMua> SachKhachHangDaMua(int idhdx)
	{
		return hdx.SachKhachHangDaMua(idhdx);
	}
	
	@Override
	@Transactional
	public void DeleteHoaDonXuatSach(int idhdx)
	{
		hdx.DeleteHoaDonXuatSach(idhdx);
	}

}
