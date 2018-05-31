package Sermina.service;

import java.util.List;

import Sermina.model.KhachHang;

public interface KhachHangService {
	
	public KhachHang findKhachHangWithName(String name);

	public void addKhachHang(KhachHang KhachHang);
	 
    public List<KhachHang> getAllKhachHang();
 
    public void deleteKhachHang(int ID);
 
    public KhachHang getKhachHang(int ID);
 
    public KhachHang updateKhachHang(KhachHang KhachHang);

}
