package Sermina.dto;

import java.util.ArrayList;
import java.util.List;

public class GetInsetHoaDonXuat {
	
	private int idHoaDonXuat;
	private String tenKhachHang;
	
	private List<GetListSachForInsertHoaDonXuat> listSachInsetHdx = new  ArrayList<GetListSachForInsertHoaDonXuat>();

	public int getIdHoaDonXuat() {
		return idHoaDonXuat;
	}

	public void setIdHoaDonXuat(int idHoaDonXuat) {
		this.idHoaDonXuat = idHoaDonXuat;
	}

	

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public List<GetListSachForInsertHoaDonXuat> getListSachInsetHdx() {
		return listSachInsetHdx;
	}

	public void setListSachInsetHdx(List<GetListSachForInsertHoaDonXuat> listSachInsetHdx) {
		this.listSachInsetHdx = listSachInsetHdx;
	}
	
	
	
	

}
