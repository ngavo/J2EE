package Sermina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Sermina.dao.KhachHangDAO;
import Sermina.model.KhachHang;

@Service
@Transactional
public class KhachHangServiceImpl implements KhachHangService {
	
	@Autowired
	private KhachHangDAO khachhangDao;
	
	@Override
	@Transactional
	public KhachHang findKhachHangWithName(String name)
	{
		return khachhangDao.findKhachHangWithName(name);
	}

    @Override
    @Transactional
    public void addKhachHang(KhachHang khachHang) {
    	khachhangDao.addKhachHang(khachHang);
    }
 
    @Override
    @Transactional
    public List<KhachHang> getAllKhachHang() {
        return khachhangDao.getAllKhachHang();
    }
 
    @Override
    @Transactional
    public void deleteKhachHang(int ID) {
    	khachhangDao.deleteKhachHang(ID);
    }
 
    public KhachHang getKhachHang(int ID) {
        return khachhangDao.getKhachHang(ID);
    }
 
    public KhachHang updateKhachHang(KhachHang khachHang) {
        // TODO Auto-generated method stub
        return khachhangDao.updateKhachHang(khachHang);
    }
 
    public void setKhachHangDAO(KhachHangDAO KhachHangDAO) {
        this.khachhangDao = KhachHangDAO;
    }

	
}
