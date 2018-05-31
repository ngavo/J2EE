package Sermina.dao;

import java.util.List;

import Sermina.model.KhachHang;

public interface KhachHangDAO {
	
	public KhachHang findKhachHangWithName(String name);

	public void addKhachHang(KhachHang KhachHang);
	
	public List<KhachHang> getAllKhachHang();
	
	public void deleteKhachHang(int ID);
	 
    public KhachHang updateKhachHang(KhachHang KhachHang);
 
    public KhachHang getKhachHang(int ID);

}
